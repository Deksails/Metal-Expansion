package com.metal_expansion.tags.menu;

import com.metal_expansion.tags.block.HydroGenerator.HydroGeneratorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class HydroGeneratorMenu extends AbstractContainerMenu {
    private final HydroGeneratorBlockEntity blockEntity;
    private final ContainerData data;

    // 服务端构造
    public HydroGeneratorMenu(int containerId, Inventory playerInventory, HydroGeneratorBlockEntity blockEntity) {
        super(ModMenuTypes.HYDRO_GENERATOR.get(), containerId);
        this.blockEntity = blockEntity;
        this.addSlot(new Slot(blockEntity, 0, 26, 35));

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

        this.addSlot(new Slot(new net.minecraft.world.SimpleContainer(1), 0, 26, 35));

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