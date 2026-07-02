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
        // 第一版：允许任何非空物品进入机器
        // 这样 Jade、管道、漏斗类测试会最直观。
        return !resource.isEmpty();

        // 如果你只想允许铅酸蓄电池，可以改成：
        // return !resource.isEmpty()
        //        && resource.is(ModItems.LEAD_ACID_BATTERY.get());
    }

    @Override
    protected int getCapacity(ItemResource resource) {
        // 这个机器内部只有 1 个槽位，而且最多存 1 个物品。
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