package com.metal_expansion.tags.item;

import com.metal_expansion.MetalExpansion;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.function.Predicate;

public class OsmiumMaceItem extends Item {
    private static final int DEFAULT_ATTACK_DAMAGE = 7;
    private static final float DEFAULT_ATTACK_SPEED = -3.5F;
    public static final float SMASH_ATTACK_FALL_THRESHOLD = 1.5F;
    private static final float SMASH_ATTACK_HEAVY_THRESHOLD = 5.0F;
    public static final float SMASH_ATTACK_KNOCKBACK_RADIUS = 4.375F;
    private static final float SMASH_ATTACK_KNOCKBACK_POWER = 0.875F;

    public OsmiumMaceItem(Item.Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double) 7.0F, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, (double) -3.5F, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(
                                Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "osmium_mace_movement_speed"),
                                -0.15D,
                                Operation.ADD_MULTIPLIED_TOTAL
                        ),
                        EquipmentSlotGroup.MAINHAND)
                .build();
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 2, false);
    }

    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        if (canSmashAttack(attacker)) {
            ServerLevel level = (ServerLevel) attacker.level();
            attacker.setDeltaMovement(attacker.getDeltaMovement().with(Axis.Y, (double) 0.01F));
            attacker.setIgnoreFallDamageFromCurrentImpulse(true, this.calculateImpactPosition(attacker));
            if (attacker instanceof ServerPlayer) {
                ServerPlayer player = (ServerPlayer) attacker;
                player.connection.send(new ClientboundSetEntityMotionPacket(player));
            }

            if (mob.onGround()) {
                if (attacker instanceof ServerPlayer) {
                    ServerPlayer player = (ServerPlayer) attacker;
                    player.setSpawnExtraParticlesOnFall(true);
                }

                SoundEvent sound = attacker.fallDistance > (double) SMASH_ATTACK_HEAVY_THRESHOLD ? SoundEvents.MACE_SMASH_GROUND_HEAVY : SoundEvents.MACE_SMASH_GROUND;
                level.playSound((Entity) null, attacker.getX(), attacker.getY(), attacker.getZ(), sound, attacker.getSoundSource(), 1.0F, 1.0F);
            } else {
                level.playSound((Entity) null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.MACE_SMASH_AIR, attacker.getSoundSource(), 1.0F, 1.0F);
            }

            knockback(level, attacker, mob);
        }

    }

    private Vec3 calculateImpactPosition(LivingEntity attacker) {
        return attacker.isIgnoringFallDamageFromCurrentImpulse() && attacker.currentImpulseImpactPos.y <= attacker.position().y ? attacker.currentImpulseImpactPos : attacker.position();
    }

    public void postHurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        if (canSmashAttack(attacker)) {
            attacker.resetFallDistance();
        }

    }

    public float getAttackDamageBonus(Entity victim, float ignoredDamage, DamageSource damageSource) {
        Entity var5 = damageSource.getDirectEntity();
        if (var5 instanceof LivingEntity attacker) {
            if (!canSmashAttack(attacker)) {
                return 0.0F;
            } else {
                double fallHeightThreshold1 = (double) 3.0F;
                double fallHeightThreshold2 = (double) 8.0F;
                double fallDistance = attacker.fallDistance;
                double damage;
                if (fallDistance <= (double) 3.0F) {
                    damage = (double) 5.0F * fallDistance;
                } else if (fallDistance <= (double) 8.0F) {
                    damage = (double) 15.0F + (double) 2.5F * (fallDistance - (double) 3.0F);
                } else {
                    damage = (double) 27.5F + (double) 1.75F * (fallDistance - (double) 8.0F);
                }

                Level var14 = attacker.level();
                float var10000;
                if (var14 instanceof ServerLevel) {
                    ServerLevel level = (ServerLevel) var14;
                    var10000 = (float) (damage + (double) EnchantmentHelper.modifyFallBasedDamage(level, attacker.getWeaponItem(), victim, damageSource, 0.0F) * fallDistance);
                } else {
                    var10000 = (float) damage;
                }

                return var10000;
            }
        } else {
            return 0.0F;
        }
    }

    private static void knockback(Level level, Entity attacker, Entity entity) {
        level.levelEvent(2013, entity.getOnPos(), 750);
        level.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate((double) SMASH_ATTACK_KNOCKBACK_RADIUS), knockbackPredicate(attacker, entity)).forEach((nearby) -> {
            Vec3 direction = nearby.position().subtract(entity.position());
            double knockbackPower = getKnockbackPower(attacker, nearby, direction);
            Vec3 knockbackVector = direction.normalize().scale(knockbackPower);
            if (knockbackPower > (double) 0.0F) {
                nearby.push(knockbackVector.x, (double) SMASH_ATTACK_KNOCKBACK_POWER, knockbackVector.z);
                if (nearby instanceof ServerPlayer) {
                    ServerPlayer otherPlayer = (ServerPlayer) nearby;
                    otherPlayer.connection.send(new ClientboundSetEntityMotionPacket(otherPlayer));
                }
            }

        });
    }

    private static Predicate<LivingEntity> knockbackPredicate(Entity attacker, Entity entity) {
        return (nearby) -> {
            boolean notSpectator;
            boolean notPlayer;
            boolean notAlliedToPlayer;
            boolean var10000;
            label87:
            {
                notSpectator = !nearby.isSpectator();
                notPlayer = nearby != attacker && nearby != entity;
                notAlliedToPlayer = !attacker.isAlliedTo(nearby);
                if (nearby instanceof TamableAnimal animal) {
                    if (entity instanceof LivingEntity livingAttacker) {
                        if (animal.isTame() && animal.isOwnedBy(livingAttacker)) {
                            var10000 = true;
                            break label87;
                        }
                    }
                }

                var10000 = false;
            }

            boolean notTamedByPlayer;
            label79:
            {
                notTamedByPlayer = !var10000;
                if (nearby instanceof ArmorStand armorStand) {
                    if (armorStand.isMarker()) {
                        var10000 = true;
                        break label79;
                    }
                }

                var10000 = false;
            }

            boolean notArmorStand;
            boolean withinRange;
            label73:
            {
                notArmorStand = !var10000;
                withinRange = entity.distanceToSqr(nearby) <= Math.pow((double) SMASH_ATTACK_KNOCKBACK_RADIUS, (double) 2.0F);
                if (nearby instanceof Player player) {
                    if (player.isCreative() && player.getAbilities().flying) {
                        var10000 = true;
                        break label73;
                    }
                }

                var10000 = false;
            }

            boolean notFlyingInCreative = !var10000;
            return notSpectator && notPlayer && notAlliedToPlayer && notTamedByPlayer && notArmorStand && withinRange && notFlyingInCreative;
        };
    }

    private static double getKnockbackPower(Entity attacker, LivingEntity nearby, Vec3 direction) {
        return ((double) SMASH_ATTACK_KNOCKBACK_RADIUS - direction.length()) * (double) SMASH_ATTACK_KNOCKBACK_POWER * (double) (attacker.fallDistance > (double) 5.0F ? 2 : 1) * ((double) 1.0F - nearby.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
    }

    public static boolean canSmashAttack(LivingEntity attacker) {
        return attacker.fallDistance > (double) 1.5F && !attacker.isFallFlying();
    }

    public @Nullable DamageSource getItemDamageSource(LivingEntity attacker) {
        return canSmashAttack(attacker) ? attacker.damageSources().mace(attacker) : super.getItemDamageSource(attacker);
    }
}