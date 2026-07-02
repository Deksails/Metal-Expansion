package com.metal_expansion.tags.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class FishingRodItem extends net.minecraft.world.item.FishingRodItem {
    private static final float BASE_SPEED_REDUCTION = 0.25F;

    public FishingRodItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (player.fishing != null) {
            return super.use(level, player, hand);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F,
                0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (level instanceof ServerLevel serverLevel) {
            int baseSpeed = (int) (BASE_SPEED_REDUCTION * 20.0F);
            int enchantSpeed = (int) (EnchantmentHelper.getFishingTimeReduction(serverLevel, itemStack, player) * 20.0F);
            int luck = EnchantmentHelper.getFishingLuckBonus(serverLevel, itemStack, player);
            Projectile.spawnProjectile(new FishingHook(player, level, luck, baseSpeed + enchantSpeed), serverLevel, itemStack);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        itemStack.causeUseVibration(player, GameEvent.ITEM_INTERACT_START);
        return InteractionResult.SUCCESS;
    }
}
