package com.metal_expansion.tags.menu;

import com.metal_expansion.tags.block.HydroGenerator.HydroGeneratorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class HydroGeneratorMenu extends AbstractContainerMenu {
    private static final int GENERATOR_SLOT = 0;
    private static final int FIRST_PLAYER_SLOT = 1;
    private static final int SHIFT_LEFT_CLICK_BUTTON = 0;
    private final HydroGeneratorBlockEntity blockEntity;
    private final ContainerData data;

    // 服务端构造
    public HydroGeneratorMenu(int containerId, Inventory playerInventory, HydroGeneratorBlockEntity blockEntity) {
        super(ModMenuTypes.HYDRO_GENERATOR.get(), containerId);
        this.blockEntity = blockEntity;
        this.addSlot(new Slot(blockEntity, GENERATOR_SLOT, 26, 35));

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                if (HydroGeneratorMenu.this.blockEntity == null) {
                    return 0;
                }

                return switch (index) {
                    case 0 -> HydroGeneratorMenu.this.blockEntity.getCachedWaterCount();
                    case 1 -> HydroGeneratorMenu.this.blockEntity.getCachedGeneratedPerTick();
                    case 2 -> HydroGeneratorMenu.this.blockEntity.getStoredItemEnergy();
                    case 3 -> HydroGeneratorMenu.this.blockEntity.getStoredItemEnergyCapacity();
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
            }

            @Override
            public int getCount() {
                return 4;
            }
        };

        this.addDataSlots(this.data);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    // 客户端构造
    public HydroGeneratorMenu(int containerId, Inventory playerInventory, BlockPos pos) {
        super(ModMenuTypes.HYDRO_GENERATOR.get(), containerId);
        this.blockEntity = null;
        this.data = new SimpleContainerData(4);

        this.addSlot(new Slot(new net.minecraft.world.SimpleContainer(1), GENERATOR_SLOT, 26, 35));

        this.addDataSlots(this.data);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public int getWaterCount() {
        return this.data.get(0);
    }

    public int getGeneratedPerTick() {
        return this.data.get(1);
    }

    public int getStoredItemEnergy() {
        return this.data.get(2);
    }

    public int getStoredItemEnergyCapacity() {
        return this.data.get(3);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void clicked(int slotId, int button, ContainerInput input, Player player) {
        if (input == ContainerInput.PICKUP_ALL && button == SHIFT_LEFT_CLICK_BUTTON) {
            if (slotId == GENERATOR_SLOT) {
                this.moveOneItemToPlayerInventory();
            } else if (slotId >= FIRST_PLAYER_SLOT) {
                this.moveOneItemToGenerator(slotId);
            }
            return;
        }

        super.clicked(slotId, button, input, player);
    }

    private void moveOneItemToGenerator(int sourceSlotId) {
        if (!this.isValidSlotIndex(sourceSlotId)) {
            return;
        }

        Slot generatorSlot = this.getSlot(GENERATOR_SLOT);
        Slot sourceSlot = this.getSlot(sourceSlotId);
        ItemStack sourceStack = sourceSlot.getItem();

        if (generatorSlot.hasItem() || sourceStack.isEmpty()) {
            return;
        }

        ItemStack oneItem = sourceStack.copyWithCount(1);
        if (!generatorSlot.mayPlace(oneItem)) {
            return;
        }

        sourceSlot.remove(1);
        sourceSlot.setChanged();
        generatorSlot.set(oneItem);
        generatorSlot.setChanged();
        this.broadcastChanges();
    }

    private void moveOneItemToPlayerInventory() {
        Slot generatorSlot = this.getSlot(GENERATOR_SLOT);
        ItemStack generatorStack = generatorSlot.getItem();

        if (generatorStack.isEmpty()) {
            return;
        }

        ItemStack oneItem = generatorStack.copyWithCount(1);
        if (!this.insertOneItemIntoPlayerInventory(oneItem)) {
            return;
        }

        generatorSlot.remove(1);
        generatorSlot.setChanged();
        this.broadcastChanges();
    }

    private boolean insertOneItemIntoPlayerInventory(ItemStack oneItem) {
        for (int slotId = FIRST_PLAYER_SLOT; slotId < this.slots.size(); slotId++) {
            Slot targetSlot = this.getSlot(slotId);
            ItemStack targetStack = targetSlot.getItem();

            if (targetSlot.mayPlace(oneItem)
                    && ItemStack.isSameItemSameComponents(targetStack, oneItem)
                    && targetStack.getCount() < targetSlot.getMaxStackSize(oneItem)) {
                targetStack.grow(1);
                targetSlot.setChanged();
                return true;
            }
        }

        for (int slotId = FIRST_PLAYER_SLOT; slotId < this.slots.size(); slotId++) {
            Slot targetSlot = this.getSlot(slotId);
            if (targetSlot.getItem().isEmpty() && targetSlot.mayPlace(oneItem)) {
                targetSlot.set(oneItem);
                targetSlot.setChanged();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.blockEntity == null) {
            return true;
        }

        return player.distanceToSqr(
                this.blockEntity.getBlockPos().getX() + 0.5,
                this.blockEntity.getBlockPos().getY() + 0.5,
                this.blockEntity.getBlockPos().getZ() + 0.5
        ) <= 64;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new net.minecraft.world.inventory.Slot(
                        playerInventory,
                        column + row * 9 + 9,
                        8 + column * 18,
                        84 + row * 18
                ));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new net.minecraft.world.inventory.Slot(
                    playerInventory,
                    column,
                    8 + column * 18,
                    142
            ));
        }
    }
}
