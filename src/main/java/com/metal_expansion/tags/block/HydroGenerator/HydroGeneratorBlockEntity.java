package com.metal_expansion.tags.block.HydroGenerator;

import com.metal_expansion.tags.energy.Battery;
import com.metal_expansion.tags.registry.ModBlockEntities;
import com.mojang.serialization.Codec;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;
import com.metal_expansion.tags.menu.HydroGeneratorMenu;

public class HydroGeneratorBlockEntity extends BlockEntity implements MenuProvider, Container {
    private ItemStack storedItem = ItemStack.EMPTY;
    private int cachedWaterCount = 0;
    private int cachedGeneratedPerTick = 0;
    private int scanCooldown = 0;
    private final HydroGeneratorItemHandler itemHandler = new HydroGeneratorItemHandler(this);

    public HydroGeneratorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.HYDRO_GENERATOR.get(), pos, blockState);
    }
    public HydroGeneratorItemHandler getItemHandler() {
        return this.itemHandler;
    }
    public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HydroGeneratorBlockEntity entity) {
        if (!(state.getBlock() instanceof HydroGeneratorBlock hydroGenerator)) {
            return;
        }

        HydroGeneratorBlock.Settings settings = hydroGenerator.settings();

        if (entity.scanCooldown-- <= 0) {
            entity.scanCooldown = 20;
            entity.cachedWaterCount = countConnectedWaterSources(
                    level,
                    pos,
                    settings.scanRadius(),
                    settings.maxEffectiveWaterCount()
            );
            entity.cachedGeneratedPerTick = entity.cachedWaterCount * settings.fePerWaterBlockPerTick();
        }

        if (entity.storedItem.isEmpty() || entity.cachedGeneratedPerTick <= 0) {
            return;
        }

        int energy = Battery.get(entity.storedItem);
        int toInsert = Math.min(Battery.MAX - energy, entity.cachedGeneratedPerTick);
        if (toInsert > 0) {
            Battery.set(entity.storedItem, energy + toInsert);
            entity.setChanged();
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }

    private static int countConnectedWaterSources(ServerLevel level, BlockPos machinePos, int radius, int maxCount) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new ArrayDeque<>();

        for (Direction direction : Direction.values()) {
            BlockPos neighbor = machinePos.relative(direction);

            if (!isInRange(machinePos, neighbor, radius) || !isValidWater(level, neighbor)) {
                continue;
            }

            visited.add(neighbor);
            queue.add(neighbor);

            if (visited.size() >= maxCount) {
                return visited.size();
            }
        }

        while (!queue.isEmpty()) {
            BlockPos current = queue.poll();

            for (Direction direction : Direction.values()) {
                BlockPos next = current.relative(direction);

                if (!isInRange(machinePos, next, radius) || visited.contains(next) || !isValidWater(level, next)) {
                    continue;
                }

                visited.add(next);
                queue.add(next);

                if (visited.size() >= maxCount) {
                    return visited.size();
                }
            }
        }

        return visited.size();
    }

    private static boolean isInRange(BlockPos center, BlockPos target, int radius) {
        return !target.equals(center)
                && Math.abs(target.getX() - center.getX()) <= radius
                && Math.abs(target.getY() - center.getY()) <= radius
                && Math.abs(target.getZ() - center.getZ()) <= radius;
    }

    private static boolean isValidWater(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        FluidState fluidState = state.getFluidState();
        return state.getBlock() instanceof LiquidBlock
                && fluidState.isSource()
                && fluidState.is(FluidTags.WATER);
    }

    public ItemStack getStoredItem() {
        return this.storedItem;
    }

    public boolean hasStoredItem() {
        return !this.storedItem.isEmpty();
    }

    public void setStoredItem(ItemStack stack) {
        this.storedItem = stack;
        this.setChanged();
    }

    public ItemStack removeStoredItem() {
        ItemStack removed = this.storedItem;
        this.storedItem = ItemStack.EMPTY;
        this.setChanged();
        return removed;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.store("storedItem", ItemStack.OPTIONAL_CODEC, this.storedItem);
        output.store("cachedWaterCount", Codec.INT, this.cachedWaterCount);
        output.store("cachedGeneratedPerTick", Codec.INT, this.cachedGeneratedPerTick);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.storedItem = input.read("storedItem", ItemStack.OPTIONAL_CODEC)
                .or(() -> input.read("battery", ItemStack.OPTIONAL_CODEC))
                .orElse(ItemStack.EMPTY);
        this.cachedWaterCount = input.getIntOr("cachedWaterCount", 0);
        this.cachedGeneratedPerTick = input.getIntOr("cachedGeneratedPerTick", 0);
    }
    public int getCachedWaterCount() {
        return this.cachedWaterCount;
    }

    public int getCachedGeneratedPerTick() {
        return this.cachedGeneratedPerTick;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.metal_expansion.hydro_generator");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new HydroGeneratorMenu(containerId, playerInventory, this);
    }
    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return this.storedItem.isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        return slot == 0 ? this.storedItem : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (slot != 0 || amount <= 0 || this.storedItem.isEmpty()) {
            return ItemStack.EMPTY;
        }

        ItemStack removed = this.storedItem.split(amount);

        if (this.storedItem.isEmpty()) {
            this.storedItem = ItemStack.EMPTY;
        }

        this.setChangedAndUpdate();
        return removed;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        if (slot != 0) {
            return ItemStack.EMPTY;
        }

        ItemStack removed = this.storedItem;
        this.storedItem = ItemStack.EMPTY;
        return removed;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        if (slot != 0) {
            return;
        }

        this.storedItem = stack;

        if (this.storedItem.getCount() > 1) {
            this.storedItem.setCount(1);
        }

        this.setChangedAndUpdate();
    }

    @Override
    public boolean stillValid(Player player) {
        return this.level != null
                && this.level.getBlockEntity(this.worldPosition) == this
                && player.distanceToSqr(
                this.worldPosition.getX() + 0.5,
                this.worldPosition.getY() + 0.5,
                this.worldPosition.getZ() + 0.5
        ) <= 64.0;
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return slot == 0;
    }

    @Override
    public void clearContent() {
        this.storedItem = ItemStack.EMPTY;
        this.setChangedAndUpdate();
    }

    private void setChangedAndUpdate() {
        this.setChanged();

        if (this.level != null && !this.level.isClientSide()) {
            BlockState state = this.getBlockState();
            this.level.sendBlockUpdated(this.worldPosition, state, state, 3);
        }
    }
    public int getStoredItemEnergy() {
        return this.storedItem.isEmpty() ? 0 : Battery.get(this.storedItem);
    }

    public int getStoredItemEnergyCapacity() {
        return this.storedItem.isEmpty() ? 0 : Battery.MAX;
    }
}
