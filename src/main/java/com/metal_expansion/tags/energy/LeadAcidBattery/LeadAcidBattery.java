package com.metal_expansion.tags.energy.LeadAcidBattery;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class LeadAcidBattery {
    public static final String ENERGY = "energy";
    public static final int MAX = 1382400;

    public static int get(ItemStack stack) {
        CompoundTag tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
        return Mth.clamp(tag.getIntOr(ENERGY, 0), 0, MAX);
    }

    public static void set(ItemStack stack, int value) {
        CompoundTag tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
        tag.putInt(ENERGY, Mth.clamp(value, 0, MAX));
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }
}
