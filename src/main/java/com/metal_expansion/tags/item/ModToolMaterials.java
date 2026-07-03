package com.metal_expansion.tags.item;

import com.metal_expansion.tags.registry.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial OSMIUM = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            650,
            7.0f,
            3f,
            35,
            ModTags.Items.OSMIUM_INGOTS
    );
    public static final ToolMaterial SILVER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            151,
            4.0f,
            2f,
            20,
            ModTags.Items.OSMIUM_INGOTS
    );
}

