package com.metal_expansion.tags.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Orientation;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class AlkaliMetalReactiveBlock extends Block {
    private final float explosionPower;
    private final Supplier<? extends Block> oxidizedBlock;
    private final float oxidationChance;

    public AlkaliMetalReactiveBlock(Properties properties, float explosionPower) {
        this(properties, explosionPower, null, 0.0F);
    }

    public AlkaliMetalReactiveBlock(
            Properties properties,
            float explosionPower,
            @Nullable Supplier<? extends Block> oxidizedBlock,
            float oxidationChance
    ) {
        super(properties);
        this.explosionPower = explosionPower;
        this.oxidizedBlock = oxidizedBlock;
        this.oxidationChance = oxidationChance;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        reactIfTouchingWater(level, pos);
    }

    @Override
    protected void neighborChanged(
            BlockState state,
            Level level,
            BlockPos pos,
            Block block,
            @Nullable Orientation orientation,
            boolean movedByPiston
    ) {
        super.neighborChanged(state, level, pos, block, orientation, movedByPiston);
        reactIfTouchingWater(level, pos);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);

        if (this.oxidizedBlock == null) {
            return;
        }

        if (random.nextFloat() > this.oxidationChance) {
            return;
        }

        reactIfTouchingWater(level, pos);

        if (level.getBlockState(pos).is(this)) {
            level.setBlockAndUpdate(pos, this.oxidizedBlock.get().defaultBlockState());
        }
    }

    private void reactIfTouchingWater(Level level, BlockPos pos) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        if (!isTouchingWater(level, pos)) {
            return;
        }

        level.removeBlock(pos, false);

        serverLevel.explode(
                null,
                pos.getX() + 0.5D,
                pos.getY() + 0.5D,
                pos.getZ() + 0.5D,
                this.explosionPower,
                Level.ExplosionInteraction.BLOCK
        );
    }

    private static boolean isTouchingWater(Level level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighbor = pos.relative(direction);

            if (level.getFluidState(neighbor).is(FluidTags.WATER)) {
                return true;
            }
        }

        return false;
    }
}