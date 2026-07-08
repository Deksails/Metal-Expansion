package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.block.AlkaliMetalReactiveBlock;
import com.metal_expansion.tags.item.batteryitem.LeadAcidBatteryItem;
import com.metal_expansion.tags.item.ModToolMaterials;
import com.metal_expansion.tags.item.batteryitem.LeadAcidBatteryUnitItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.Weapon;
import com.metal_expansion.tags.item.OsmiumMaceItem;
import com.metal_expansion.tags.item.FishingRodItem;

import static com.metal_expansion.tags.registry.ModBlocks.BLOCKS;

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
    public static final DeferredItem<Item> OSMIUM_DUST =
            ITEMS.registerSimpleItem("osmium_dust", Item.Properties::new);
    public static final DeferredItem<Item> OSMIUM_NUGGET =
            ITEMS.registerSimpleItem("osmium_nugget", Item.Properties::new);
    public static final DeferredItem<Item> OSMIUM_UPGRADE_SMITHING_TEMPLATE =
            ITEMS.registerSimpleItem("osmium_upgrade_smithing_template", Item.Properties::new);

    //Sulfur_Items
    public static final DeferredItem<Item> SULFUR_DUST =
            ITEMS.registerSimpleItem("sulfur_dust", Item.Properties::new);
    public static final DeferredItem<Item> DIRTY_SULFUR_DUST =
            ITEMS.registerSimpleItem("dirty_sulfur_dust", Item.Properties::new);
    //Sliver_Items
    public static final DeferredItem<Item> SILVER_INGOT =
            ITEMS.registerSimpleItem("silver_ingot",Item.Properties::new);
    public static final DeferredItem<Item> RAW_SILVER =
            ITEMS.registerSimpleItem("raw_silver",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_SHARD =
            ITEMS.registerSimpleItem("silver_shard",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_DUST =
            ITEMS.registerSimpleItem("silver_dust",Item.Properties::new);
    public static final DeferredItem<Item> SILVER_NUGGET =
            ITEMS.registerSimpleItem("silver_nugget",Item.Properties::new);

    //Lead_Items
    public static final DeferredItem<Item> LEAD_INGOT =
            ITEMS.registerSimpleItem("lead_ingot", Item.Properties::new);
    public static final DeferredItem<Item> RAW_LEAD =
            ITEMS.registerSimpleItem("raw_lead", Item.Properties::new);
    public static final DeferredItem<Item> LEAD_SHARD =
            ITEMS.registerSimpleItem("lead_shard", Item.Properties::new);
    public static final DeferredItem<Item> LEAD_DUST =
            ITEMS.registerSimpleItem("lead_dust", Item.Properties::new);
    public static final DeferredItem<Item> LEAD_NUGGET =
            ITEMS.registerSimpleItem("lead_nugget", Item.Properties::new);

    //Lithium_Items
    public static final DeferredItem<Item> LITHIUM_INGOT =
            ITEMS.registerSimpleItem("lithium_ingot", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_OXIDE_INGOT =
            ITEMS.registerSimpleItem("lithium_oxide_ingot", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_SHARD =
            ITEMS.registerSimpleItem("lithium_shard", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_OXIDE_SHARD =
            ITEMS.registerSimpleItem("lithium_oxide_shard", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_DUST =
            ITEMS.registerSimpleItem("lithium_dust", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_OXIDE_DUST =
            ITEMS.registerSimpleItem("lithium_oxide_dust", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_NUGGET =
            ITEMS.registerSimpleItem("lithium_nugget", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_OXIDE_NUGGET =
            ITEMS.registerSimpleItem("lithium_oxide_nugget", Item.Properties::new);
    public static final DeferredItem<Item> SPODUMENE =
            ITEMS.registerSimpleItem("spodumene", Item.Properties::new);
    public static final DeferredItem<Item> HIGH_LITHIUM_SLAG =
            ITEMS.registerSimpleItem("high_lithium_slag", Item.Properties::new);

    //Tin_Items
    public static final DeferredItem<Item> TIN_INGOT =
            ITEMS.registerSimpleItem("tin_ingot", Item.Properties::new);
    public static final DeferredItem<Item> TIN_SHARD =
            ITEMS.registerSimpleItem("tin_shard", Item.Properties::new);
    public static final DeferredItem<Item> TIN_DUST =
            ITEMS.registerSimpleItem("tin_dust", Item.Properties::new);
    public static final DeferredItem<Item> RAW_TIN =
            ITEMS.registerSimpleItem("raw_tin", Item.Properties::new);
    public static final DeferredItem<Item> TIN_NUGGET =
            ITEMS.registerSimpleItem("tin_nugget", Item.Properties::new);
    public static final DeferredItem<Item> CASSITERITE =
            ITEMS.registerSimpleItem("cassiterite", Item.Properties::new);

    //Titanium_Items
    public static final DeferredItem<Item> TITANIUM_INGOT =
            ITEMS.registerSimpleItem("titanium_ingot", Item.Properties::new);
    public static final DeferredItem<Item> TITANIUM_SHARD =
            ITEMS.registerSimpleItem("titanium_shard", Item.Properties::new);
    public static final DeferredItem<Item> TITANIUM_DUST =
            ITEMS.registerSimpleItem("titanium_dust", Item.Properties::new);
    public static final DeferredItem<Item> TITANIUM_NUGGET =
            ITEMS.registerSimpleItem("titanium_nugget", Item.Properties::new);
    public static final DeferredItem<Item> RUTILE =
            ITEMS.registerSimpleItem("rutile", Item.Properties::new);
    public static final DeferredItem<Item> HIGH_TITANIUM_SLAG =
            ITEMS.registerSimpleItem("high_titanium_slag", Item.Properties::new);

    //Vanadium_Items
    public static final DeferredItem<Item> VANADIUM_INGOT =
            ITEMS.registerSimpleItem("vanadium_ingot", Item.Properties::new);
    public static final DeferredItem<Item> VANADIUM_SHARD =
            ITEMS.registerSimpleItem("vanadium_shard", Item.Properties::new);
    public static final DeferredItem<Item> VANADIUM_DUST =
            ITEMS.registerSimpleItem("vanadium_dust", Item.Properties::new);
    public static final DeferredItem<Item> HIGH_VANADIUM_SLAG =
            ITEMS.registerSimpleItem("high_vanadium_slag", Item.Properties::new);
    public static final DeferredItem<Item> VANADIUM_NUGGET =
            ITEMS.registerSimpleItem("vanadium_nugget", Item.Properties::new);

    //Compound_Mineral_Items
    public static final DeferredItem<Item> VANADIUM_TITANOMAGNETITE =
            ITEMS.registerSimpleItem("vanadium_titanomagnetite", Item.Properties::new);
    public static final DeferredItem<Item> ILMENITE =
            ITEMS.registerSimpleItem("ilmenite", Item.Properties::new);
    public static final DeferredItem<Item> LEPIDOLITE =
            ITEMS.registerSimpleItem("lepidolite", Item.Properties::new);
    public static final DeferredItem<Item> DEPOSITED_SALT =
            ITEMS.registerSimpleItem("deposited_salt", Item.Properties::new);

    //Miscellaneous_Items
    public static final DeferredItem<Item> CARBON_DUST =
            ITEMS.registerSimpleItem("carbon_dust", Item.Properties::new);
    public static final DeferredItem<Item> LITTLE_SODIUM_CHLORIDE =
            ITEMS.registerSimpleItem("little_sodium_chloride", Item.Properties::new);
    public static final DeferredItem<Item> SODIUM_CHLORIDE_POWDER =
            ITEMS.registerSimpleItem("sodium_chloride_powder", Item.Properties::new);
    public static final DeferredItem<Item> LITTLE_POTASSIUM_CHLORIDE =
            ITEMS.registerSimpleItem("little_potassium_chloride", Item.Properties::new);
    public static final DeferredItem<Item> POTASSIUM_CHLORIDE_POWDER =
            ITEMS.registerSimpleItem("potassium_chloride_powder", Item.Properties::new);
    public static final DeferredItem<Item> LITTLE_MAGNESIUM_CHLORIDE =
            ITEMS.registerSimpleItem("little_magnesium_chloride", Item.Properties::new);
    public static final DeferredItem<Item> MAGNESIUM_CHLORIDE_POWDER =
            ITEMS.registerSimpleItem("magnesium_chloride_powder", Item.Properties::new);
    public static final DeferredItem<Item> LITHIUM_CARBONATE_POWDER =
            ITEMS.registerSimpleItem("lithium_carbonate_powder", Item.Properties::new);
    public static final DeferredItem<Item> SODIUM_CARBONATE_POWDER =
            ITEMS.registerSimpleItem("sodium_carbonate_powder", Item.Properties::new);
    public static final DeferredItem<Item> MAGNESIUM_DUST =
            ITEMS.registerSimpleItem("magnesium_dust", Item.Properties::new);

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

    //Lithium_Blocks
    public static final DeferredItem<BlockItem> SPODUMENE_ORE =
            ITEMS.registerSimpleBlockItem("spodumene_ore", ModBlocks.SPODUMENE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_SPODUMENE_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_spodumene_ore", ModBlocks.DEEPSLATE_SPODUMENE_ORE);
    public static final DeferredItem<BlockItem> LITHIUM_BLOCK =
            ITEMS.registerSimpleBlockItem(ModBlocks.LITHIUM_BLOCK);
    public static final DeferredItem<BlockItem> LITHIUM_OXIDE_BLOCK =
            ITEMS.registerSimpleBlockItem(ModBlocks.LITHIUM_OXIDE_BLOCK);

    //Tin_Blocks
    public static final DeferredItem<BlockItem> CASSITERITE_ORE =
            ITEMS.registerSimpleBlockItem("cassiterite_ore", ModBlocks.CASSITERITE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_CASSITERITE_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_cassiterite_ore", ModBlocks.DEEPSLATE_CASSITERITE_ORE);
    public static final DeferredItem<BlockItem> TIN_BLOCK =
            ITEMS.registerSimpleBlockItem("tin_block", ModBlocks.TIN_BLOCK);

    //Titanium_Blocks
    public static final DeferredItem<BlockItem> RUTILE_ORE =
            ITEMS.registerSimpleBlockItem("rutile_ore", ModBlocks.RUTILE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_RUTILE_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_rutile_ore", ModBlocks.DEEPSLATE_RUTILE_ORE);
    public static final DeferredItem<BlockItem> TITANIUM_BLOCK =
            ITEMS.registerSimpleBlockItem("titanium_block", ModBlocks.TITANIUM_BLOCK);

    //Vanadium_Blocks
    public static final DeferredItem<BlockItem> VANADIUM_BLOCK =
            ITEMS.registerSimpleBlockItem("vanadium_block", ModBlocks.VANADIUM_BLOCK);

    //Compound_Mineral_Blocks
    public static final DeferredItem<BlockItem> VANADIUM_TITANOMAGNETITE_ORE =
            ITEMS.registerSimpleBlockItem("vanadium_titanomagnetite_ore", ModBlocks.VANADIUM_TITANOMAGNETITE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_VANADIUM_TITANOMAGNETITE_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_vanadium_titanomagnetite_ore", ModBlocks.DEEPSLATE_VANADIUM_TITANOMAGNETITE_ORE);
    public static final DeferredItem<BlockItem> ILMENITE_ORE =
            ITEMS.registerSimpleBlockItem("ilmenite_ore", ModBlocks.ILMENITE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_ILMENITE_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_ilmenite_ore", ModBlocks.DEEPSLATE_ILMENITE_ORE);
    public static final DeferredItem<BlockItem> LEPIDOLITE_ORE =
            ITEMS.registerSimpleBlockItem("lepidolite_ore", ModBlocks.LEPIDOLITE_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_LEPIDOLITE_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_lepidolite_ore", ModBlocks.DEEPSLATE_LEPIDOLITE_ORE);
    public static final DeferredItem<BlockItem> DEPOSITED_SALT_BLOCK =
            ITEMS.registerSimpleBlockItem("deposited_salt_block", ModBlocks.DEPOSITED_SALT_BLOCK);

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
