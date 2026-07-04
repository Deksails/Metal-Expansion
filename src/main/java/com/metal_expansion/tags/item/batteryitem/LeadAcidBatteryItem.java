package com.metal_expansion.tags.item.batteryitem;

import com.metal_expansion.tags.energy.LeadAcidBattery.LeadAcidBattery;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

public class LeadAcidBatteryItem extends Item {
    public LeadAcidBatteryItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F * LeadAcidBattery.get(stack) / LeadAcidBattery.MAX);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float charge = (float) LeadAcidBattery.get(stack) / LeadAcidBattery.MAX;
        return Mth.hsvToRgb(charge / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        tooltip.accept(Component.literal(LeadAcidBattery.get(stack) + "/" + LeadAcidBattery.MAX + " FE").withStyle(ChatFormatting.GRAY));
    }
}
