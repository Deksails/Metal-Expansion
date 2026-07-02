package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.item.LeadAcidBatteryItem;
import com.metal_expansion.tags.item.ModToolMaterials;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.Weapon;
import com.metal_expansion.tags.item.OsmiumMaceItem;
import com.metal_expansion.tags.item.FishingRodItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MetalExpansion.MODID);

    //Osmium_Items
    public static final DeferredItem<Item> OSMIUM_INGOT =
            ITEMS.registerSimpleItem("osmium_ingot", Item.Properties::new);
    public static final DeferredItem<Item> RAW_OSMIUM =
            ITEMS.registerSimpleItem("raw_osmium", Item.Properties::new);
    public static final DeferredItem<Item> OSMIUM_SHARD =
            ITEMS.registerSimpleItem("osmium_shard", Item.Properties::new);
    public static final DeferredItem<Item> OSMIUM_NUGGET =
            ITEMS.registerSimpleItem("osmium_nugget", Item.Properties::new);
    public static final DeferredItem<Item> OSMIUM_DUST =
            ITEMS.registerSimpleItem("osmium_dust", Item.Properties::new);
    public static final DeferredItem<Item> OSMIUM_UPGRADE_SMITHING_TEMPLATE =
            ITEMS.registerSimpleItem("osmium_upgrade_smithing_template", Item.Properties::new);

    //Other_Items
    public static final DeferredItem<Item> SULFUR_POWDER =
            ITEMS.registerSimpleItem("sulfur_powder", Item.Properties::new);

    //Sliver_Items
    public static final DeferredItem<Item> SILVER_INGOT =
            ITEMS.registerSimpleItem("silver_ingot",Item.Properties::new);
    public static final DeferredItem<Item> RAW_SILVER =
            ITEMS.registerSimpleItem("raw_silver",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_SHARD =
            ITEMS.registerSimpleItem("silver_shard",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_NUGGET =
            ITEMS.registerSimpleItem("silver_nugget",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_DUST =
            ITEMS.registerSimpleItem("silver_dust", Item.Properties::new);

    //Batteries
    public static final DeferredItem<Item> LEAD_ACID_BATTERY =
            ITEMS.registerItem("lead_acid_battery",
                    props -> new LeadAcidBatteryItem(props.stacksTo(1)));

    //Machines_Items

    //Machines_Block
    public static final DeferredItem<BlockItem> HYDRO_GENERATOR =
            ITEMS.registerSimpleBlockItem("hydro_generator", ModBlocks.HYDRO_GENERATOR);
    public static final DeferredItem<BlockItem> HYDRO_GENERATOR_PLUS =
            ITEMS.registerSimpleBlockItem("hydro_generator_plus", ModBlocks.HYDRO_GENERATOR_PLUS);
    public static final DeferredItem<BlockItem> HYDRO_GENERATOR_MAX =
            ITEMS.registerSimpleBlockItem("hydro_generator_max", ModBlocks.HYDRO_GENERATOR_MAX);

    //Osmium_Blocks
    public static final DeferredItem<BlockItem> OSMIUM_ORE =
            ITEMS.registerSimpleBlockItem("osmium_ore", ModBlocks.OSMIUM_ORE);
    public static final DeferredItem<BlockItem> OSMIUM_BLOCK =
            ITEMS.registerSimpleBlockItem("osmium_block", ModBlocks.OSMIUM_BLOCK);
    public static final DeferredItem<BlockItem> DEEPSLATE_OSMIUM_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_osmium_ore", ModBlocks.DEEPSLATE_OSMIUM_ORE);

    public static final DeferredItem<Item> OSMIUM_SPEAR = ITEMS.registerItem(
        "osmium_spear",
        props -> new Item(props
                .spear(
                ModToolMaterials.OSMIUM,
                1.0f,
                1.15f,
                0.7f,
                3.5f,
                7.0f,
                6.5f,
                5.1f,
                9.0f,
                4.6f

        )
                .durability(900)
        )
    );
    public static final DeferredItem<Item> OSMIUM_MACE = ITEMS.registerItem(
            "osmium_mace",
            props -> new OsmiumMaceItem(props
                    .attributes(OsmiumMaceItem.createAttributes())
                    .component(DataComponents.TOOL, OsmiumMaceItem.createToolProperties())
                    .durability(750)
                    .component(DataComponents.WEAPON, new Weapon(1))
            )
    );

    public static final DeferredItem<Item> OSMIUM_FISHING_ROD = ITEMS.registerItem(
            "osmium_fishing_rod",
            props -> new FishingRodItem(
                    props.durability(256).enchantable(1)
            )
    );

    public static final DeferredItem<Item> OSMIUM_SWORD = ITEMS.registerItem(
        "osmium_sword",
        props -> new Item(props.sword(
                ModToolMaterials.OSMIUM,
                2.5f,
                -2.4f
        )
                .durability(900)
        )
    );

    public static final DeferredItem<Item> OSMIUM_PICKAXE = ITEMS.registerItem(
            "osmium_pickaxe",
            props -> new Item(props.pickaxe(
                    ModToolMaterials.OSMIUM,
                    1.0f,
                    -2.8f
            )
            )
    );

    public static final DeferredItem<Item> OSMIUM_AXE = ITEMS.registerItem(
            "osmium_axe",
            props -> new Item(props.axe(
                    ModToolMaterials.OSMIUM,
                    5.0f,
                    -3.1f
            )
                    .durability(750)
            )
    );

    public static final DeferredItem<Item> OSMIUM_SHOVEL = ITEMS.registerItem(
            "osmium_shovel",
            props -> new Item(props.shovel(
                    ModToolMaterials.OSMIUM,
                    1.0f,
                    -3.0f
            )
                    .durability(900)
            )
    );

    public static final DeferredItem<Item> OSMIUM_HOE = ITEMS.registerItem(
            "osmium_hoe",
            props -> new Item(props.hoe(
                    ModToolMaterials.OSMIUM,
                    -3.0f,
                    -1.0f
            )
                    .durability(700)
            )
    );

//Osmium_Tools

}
