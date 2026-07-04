package com.metal_expansion.tags.item.batteryitem;

import java.util.function.Consumer;
import com.metal_expansion.tags.energy.LeadAcidBatteryUnit.LeadAcidBatteryUnit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

public class LeadAcidBatteryUnitItem extends Item {
    public LeadAcidBatteryUnitItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F * LeadAcidBatteryUnit.get(stack) / LeadAcidBatteryUnit.MAX);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float charge = (float) LeadAcidBatteryUnit.get(stack) / LeadAcidBatteryUnit.MAX;
        return Mth.hsvToRgb(charge / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        tooltip.accept(Component.literal(LeadAcidBatteryUnit.get(stack) + "/" + LeadAcidBatteryUnit.MAX + " FE").withStyle(ChatFormatting.GRAY));
    }
}
