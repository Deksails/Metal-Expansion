package com.metal_expansion.tags.event;

import com.metal_expansion.tags.registry.ModItems;
import com.metal_expansion.tags.registry.ModTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public final class AlkaliMetalReactionEvents {
    private AlkaliMetalReactionEvents() {
    }

    public static void onEntityTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof ItemEntity itemEntity)) {
            return;
        }

        Level level = itemEntity.level();

        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        if (!itemEntity.isInWater()) {
            return;
        }

        ItemStack stack = itemEntity.getItem();

        if (stack.is(ModTags.Items.EXPLODES_IN_WATER)) {
            explodeDroppedItem(serverLevel, itemEntity, stack);
            return;
        }

        if (stack.is(ModTags.Items.DISAPPEARS_IN_WATER)) {
            dissolveDroppedItem(serverLevel, itemEntity);
        }
    }

    private static void explodeDroppedItem(ServerLevel level, ItemEntity itemEntity, ItemStack stack) {
        float power = 3.0F;

        if (stack.is(ModItems.LITHIUM_OXIDE_BLOCK.get())) {
            power = 1.5F;
        }

        itemEntity.discard();

        level.explode(
                null,
                itemEntity.getX(),
                itemEntity.getY(),
                itemEntity.getZ(),
                power,
                Level.ExplosionInteraction.BLOCK
        );
    }

    private static void dissolveDroppedItem(ServerLevel level, ItemEntity itemEntity) {
        level.playSound(
                null,
                itemEntity.blockPosition(),
                SoundEvents.LAVA_EXTINGUISH,
                SoundSource.BLOCKS,
                0.8F,
                1.2F
        );

        level.sendParticles(
                ParticleTypes.SMOKE,
                itemEntity.getX(),
                itemEntity.getY() + 0.1D,
                itemEntity.getZ(),
                8,
                0.2D,
                0.1D,
                0.2D,
                0.02D
        );

        itemEntity.discard();
    }
}