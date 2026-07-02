package com.metal_expansion.tags.client;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.client.screen.HydroGeneratorScreen;
import com.metal_expansion.tags.menu.ModMenuTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = MetalExpansion.MODID)
public final class ClientModEvents {
    private ClientModEvents() {
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.HYDRO_GENERATOR.get(), HydroGeneratorScreen::new);
    }
}