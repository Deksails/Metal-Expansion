package com.metal_expansion.tags.block.HydroGenerator;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStackResourceHandler;

public class HydroGeneratorItemHandler extends ItemStackResourceHandler {
    private final HydroGeneratorBlockEntity blockEntity;

    public HydroGeneratorItemHandler(HydroGeneratorBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    protected ItemStack getStack() {
        return this.blockEntity.getStoredItem();
    }

    @Override
    protected void setStack(ItemStack stack) {
        this.blockEntity.setStoredItem(stack);
    }

    @Override
    protected boolean isValid(ItemResource resource) {
        return !resource.isEmpty();
    }

    @Override
    protected int getCapacity(ItemResource resource) {
        // 这个机器内部只有 1 个槽位，而且最多存 1 个物品
        return 1;
    }

    @Override
    protected void onRootCommit(ItemStack originalState) {
        this.blockEntity.setChanged();

        if (this.blockEntity.getLevel() != null && !this.blockEntity.getLevel().isClientSide()) {
            this.blockEntity.getLevel().sendBlockUpdated(
                    this.blockEntity.getBlockPos(),
                    this.blockEntity.getBlockState(),
                    this.blockEntity.getBlockState(),
                    3
            );

            this.blockEntity.getLevel().invalidateCapabilities(this.blockEntity.getBlockPos());
        }
    }
}