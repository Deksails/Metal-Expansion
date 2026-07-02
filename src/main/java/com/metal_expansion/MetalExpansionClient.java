package com.metal_expansion;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = MetalExpansion.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MetalExpansion.MODID, value = Dist.CLIENT)
public class MetalExpansionClient {
    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        MetalExpansion.LOGGER.info("Metal Expansion client loaded.");
    }
}
