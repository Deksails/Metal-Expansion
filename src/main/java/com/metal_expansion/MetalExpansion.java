package com.metal_expansion;

import com.metal_expansion.tags.energy.ModCapabilities;
import com.metal_expansion.tags.menu.ModMenuTypes;
import com.metal_expansion.tags.registry.ModBlockEntities;
import com.metal_expansion.tags.registry.ModBlocks;
import com.metal_expansion.tags.registry.ModCreativeModeTabs;
import com.metal_expansion.tags.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(MetalExpansion.MODID)
public class MetalExpansion {
    public static final String MODID = "metal_expansion";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MetalExpansion(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ModCapabilities::registerCapabilities);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModMenuTypes.MENUS.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Metal Expansion loaded.");
    }
}
