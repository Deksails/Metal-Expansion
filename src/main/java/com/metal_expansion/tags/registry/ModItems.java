package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.item.batteryitem.LeadAcidBatteryItem;
import com.metal_expansion.tags.item.ModToolMaterials;
import com.metal_expansion.tags.item.batteryitem.LeadAcidBatteryUnitItem;
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
    public static final DeferredItem<Item> OSMIUM_UPGRADE_SMITHING_TEMPLATE =
            ITEMS.registerSimpleItem("osmium_upgrade_smithing_template", Item.Properties::new);

    //Sulfur_Items
    public static final DeferredItem<Item> SULFUR_POWDER =
            ITEMS.registerSimpleItem("sulfur_powder", Item.Properties::new);
    public static final DeferredItem<Item> DIRTY_SULFUR_POWDER =
            ITEMS.registerSimpleItem("dirty_sulfur_powder", Item.Properties::new);
    //Sliver_Items
    public static final DeferredItem<Item> SILVER_INGOT =
            ITEMS.registerSimpleItem("silver_ingot",Item.Properties::new);
    public static final DeferredItem<Item> RAW_SILVER =
            ITEMS.registerSimpleItem("raw_silver",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_SHARD =
            ITEMS.registerSimpleItem("silver_shard",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_NUGGET =
            ITEMS.registerSimpleItem("silver_nugget",Item.Properties::new);

    //Lead_Items
    public static final DeferredItem<Item> LEAD_INGOT =
            ITEMS.registerSimpleItem("lead_ingot", Item.Properties::new);
    public static final DeferredItem<Item> RAW_LEAD =
            ITEMS.registerSimpleItem("raw_lead", Item.Properties::new);
    public static final DeferredItem<Item> LEAD_SHARD =
            ITEMS.registerSimpleItem("lead_shard", Item.Properties::new);
    public static final DeferredItem<Item> LEAD_NUGGET =
            ITEMS.registerSimpleItem("lead_nugget", Item.Properties::new);

    //Batteries
    public static final DeferredItem<Item> LEAD_ACID_BATTERY =
            ITEMS.registerItem("lead_acid_battery",
                    props -> new LeadAcidBatteryItem(props.stacksTo(1)));
    public static final DeferredItem<Item> LEAD_ACID_BATTERY_UNIT =
            ITEMS.registerItem("lead_acid_battery_unit",
                    props -> new LeadAcidBatteryUnitItem(props.stacksTo(1)));

    //Machine_Items
    public static final DeferredItem<Item> SIMPLE_ANTICORROSION_GAS_IRON_BOTTLE =
            ITEMS.registerSimpleItem("simple_anticorrosion_gas_iron_bottle", Item.Properties::new);
    public static final DeferredItem<Item> SIMPLE_ANTICORROSION_LIQUID_IRON_BOTTLE =
            ITEMS.registerSimpleItem("simple_anticorrosion_liquid_iron_bottle", Item.Properties::new);

    //Machine_Blocks
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

    //Silver_Blocks
    public static final DeferredItem<BlockItem> SILVER_BLOCK =
            ITEMS.registerSimpleBlockItem("silver_block", ModBlocks.SILVER_BLOCK);
    public static final DeferredItem<BlockItem> SILVER_ORE =
            ITEMS.registerSimpleBlockItem("silver_ore", ModBlocks.SILVER_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_SILVER_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_silver_ore", ModBlocks.DEEPSLATE_SILVER_ORE);
    public static final DeferredItem<BlockItem> NETHER_SILVER_ORE =
            ITEMS.registerSimpleBlockItem("nether_silver_ore", ModBlocks.NETHER_SILVER_ORE);

    //Lead_Blocks
    public static final DeferredItem<BlockItem> LEAD_BLOCK =
            ITEMS.registerSimpleBlockItem("lead_block", ModBlocks.LEAD_BLOCK);
    public static final DeferredItem<BlockItem> GALENA =
            ITEMS.registerSimpleBlockItem("galena", ModBlocks.GALENA);
    public static final DeferredItem<BlockItem> DEEPSLATE_GALENA =
            ITEMS.registerSimpleBlockItem("deepslate_galena", ModBlocks.DEEPSLATE_GALENA);
    public static final DeferredItem<BlockItem> END_LEAD_ORE =
            ITEMS.registerSimpleBlockItem("end_lead_ore", ModBlocks.END_LEAD_ORE);

    //Osmium_Tools
    public static final DeferredItem<Item> OSMIUM_SPEAR = ITEMS.registerItem(
        "osmium_spear",
        props -> new Item(props
                .spear(
                ModToolMaterials.OSMIUM,
                1.0f,
                1.015f,
                0.7f,
                3.5f,
                7.0f,
                6.5f,
                5.1f,
                9.5f,
                4.6f
        )
                .durability(800)
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

    public static final DeferredItem<Item> OSMIUM_SWORD = ITEMS.registerItem(
        "osmium_sword",
        props -> new Item(props.sword(
                ModToolMaterials.OSMIUM,
                2.5f,
                -2.4f
        )
                .durability(800)
        )
    );

    public static final DeferredItem<Item> OSMIUM_FISHING_ROD = ITEMS.registerItem(
            "osmium_fishing_rod",
            props -> new FishingRodItem(
                    props.durability(450).enchantable(1)
            )
    );

    public static final DeferredItem<Item> OSMIUM_PICKAXE = ITEMS.registerItem(
            "osmium_pickaxe",
            props -> new Item(props.pickaxe(
                    ModToolMaterials.OSMIUM,
                    1.0f,
                    -2.8f
            )
                    .durability(550)
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
                    .durability(600)
            )
    );

    public static final DeferredItem<Item> OSMIUM_HOE = ITEMS.registerItem(
            "osmium_hoe",
            props -> new Item(props.hoe(
                    ModToolMaterials.OSMIUM,
                    -3.0f,
                    -1.0f
            )
                    .durability(550)
            )
    );

    //Silver_Tools
    public static final DeferredItem<Item> SILVER_SPEAR = ITEMS.registerItem(
            "silver_spear",
            props -> new Item(props
                    .spear(
                            ModToolMaterials.SILVER,
                            0.8f,
                            0.75f,
                            0.65f,
                            4.0f,
                            11.0f,
                            9.0f,
                            5.1f,
                            13.75f,
                            4.6f
                    )
                    .durability(151)
            )
    );
    public static final DeferredItem<Item> SILVER_SWORD = ITEMS.registerItem(
            "silver_sword",
            props -> new Item(props.sword(
                            ModToolMaterials.SILVER,
                            2.0f,
                            -2.4f
                    )
                    .durability(151)
            )
    );
    public static final DeferredItem<Item> SILVER_AXE = ITEMS.registerItem(
            "silver_axe",
            props -> new Item(props.axe(
                            ModToolMaterials.SILVER,
                            6.0f,
                            -3.2f
                    )
                    .durability(151)
            )
    );
    public static final DeferredItem<Item> SILVER_PICKAXE = ITEMS.registerItem(
            "silver_pickaxe",
            props -> new Item(props.pickaxe(
                            ModToolMaterials.SILVER,
                            0.0f,
                            -2.8f
                    )
                    .durability(151)
            )
    );
    public static final DeferredItem<Item> SILVER_SHOVEL = ITEMS.registerItem(
            "silver_shovel",
            props -> new Item(props.shovel(
                            ModToolMaterials.SILVER,
                            0.5f,
                            -3.0f
                    )
                    .durability(151)
            )
    );
    public static final DeferredItem<Item> SILVER_HOE = ITEMS.registerItem(
            "silver_hoe",
            props -> new Item(props.hoe(
                            ModToolMaterials.SILVER,
                            -2.0f,
                            -2.0f
                    )
                    .durability(151)
            )
    );

}
