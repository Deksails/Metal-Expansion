package com.metal_expansion.tags.event;

import com.metal_expansion.tags.registry.ModItems;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public final class ModCombatEvents {
    private static final float SILVER_UNDEAD_DAMAGE_MULTIPLIER = 1.5f;

    private ModCombatEvents() {
    }

    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (!event.getEntity().is(EntityTypeTags.UNDEAD)) {
            return;
        }

        if (isSilverWeapon(event.getSource().getWeaponItem()) || isSilverWeaponHeldByAttacker(event.getSource().getEntity())) {
            event.setNewDamage(event.getNewDamage() * SILVER_UNDEAD_DAMAGE_MULTIPLIER);
        }
    }

    private static boolean isSilverWeaponHeldByAttacker(Entity sourceEntity) {
        return sourceEntity instanceof LivingEntity attacker && isSilverWeapon(attacker.getMainHandItem());
    }

    private static boolean isSilverWeapon(ItemStack stack) {
        if (stack == null || stack.isEmpty()) {
            return false;
        }

        Item item = stack.getItem();
        return item == ModItems.SILVER_SWORD.get() || item == ModItems.SILVER_SPEAR.get();
    }
}
