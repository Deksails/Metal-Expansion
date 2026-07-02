package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MetalExpansion.MODID);

    private static void addTagItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output, TagKey<Item> tagKey) {
        params.holders().lookupOrThrow(Registries.ITEM).get(tagKey).ifPresent(tag ->
            tag.forEach(holder -> output.accept(holder.value().getDefaultInstance()))
        );
    }

    // 1. 主功能 Tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN =
            CREATIVE_MODE_TABS.register("metal_expansion_main", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.metal_expansion_main"))
                            .icon(() -> ModItems.LEAD_ACID_BATTERY.get().getDefaultInstance())
                            .displayItems((params, output) -> {
                                addTagItems(params, output, ModTags.Items.MACHINES);
                                addTagItems(params, output, ModTags.Items.BATTERIES);
                                addTagItems(params, output, ModTags.Items.METAL_BLOCKS);
                            })
                            .build()
            );
    // 2. 工具 Tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS =
            CREATIVE_MODE_TABS.register("metal_expansion_tools", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.metal_expansion_tools"))
                            .icon(() -> ModItems.OSMIUM_SWORD.get().getDefaultInstance())
                            .displayItems((params, output) -> {
                                addTagItems(params, output, ModTags.Items.TOOLS);
                                addTagItems(params, output, ModTags.Items.WEAPONS);
                            })
                            .build()
            );
    // 3. 材料 Tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MISC =
            CREATIVE_MODE_TABS.register("metal_expansion_miscellaneous", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.metal_expansion_miscellaneous"))
                            .icon(() -> ModItems.OSMIUM_INGOT.get().getDefaultInstance())
                            .displayItems((params, output) -> {
                                addTagItems(params, output, ModTags.Items.MATERIALS);
                                addTagItems(params, output, ModTags.Items.METAL_BLOCKS);
                            })
                            .build()
            );
}
