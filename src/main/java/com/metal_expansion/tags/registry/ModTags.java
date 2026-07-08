package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

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


        public static final TagKey<Item> EXPLODES_IN_WATER =
                itemTag("explodes_in_water");

        public static final TagKey<Item> DISAPPEARS_IN_WATER =
                itemTag("disappears_in_water");

        private static TagKey<Item> itemTag(String name) {
            return TagKey.create(
                    Registries.ITEM,
                    Identifier.fromNamespaceAndPath(MetalExpansion.MODID, name)
            );
        }
    }
    public static final class Blocks {
        public static final TagKey<Block> EXPLODES_IN_WATER =
                blockTag("explodes_in_water");
        private static TagKey<Block> blockTag(String name) {
            return TagKey.create(
                        Registries.BLOCK,
                        Identifier.fromNamespaceAndPath(MetalExpansion.MODID, name)
            );
        }
    }
}