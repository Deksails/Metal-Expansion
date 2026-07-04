package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> OSMIUM_INGOTS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "ingots/osmium"));
        public static final TagKey<Item> SILVER_INGOTS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "ingots/silver"));
        public static final TagKey<Item> LEAD_INGOTS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "ingots/lead"));

        public static final TagKey<Item> MACHINES =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "machines"));
        public static final TagKey<Item> BATTERIES =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "batteries"));
        public static final TagKey<Item> TOOLS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "tools"));
        public static final TagKey<Item> WEAPONS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "weapons"));
        public static final TagKey<Item> MATERIALS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "materials"));
        public static final TagKey<Item> METAL_BLOCKS =
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "metal_blocks"));
    }
}