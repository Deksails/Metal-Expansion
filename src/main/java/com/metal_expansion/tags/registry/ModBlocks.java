package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.block.AlkaliMetalReactiveBlock;
import com.metal_expansion.tags.block.HydroGenerator.HydroGeneratorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MetalExpansion.MODID);

    //Osmium
    public static final DeferredBlock<Block> OSMIUM_ORE =
            BLOCKS.register("osmium_ore", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.STONE)
                                    .strength(3.0f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> DEEPSLATE_OSMIUM_ORE =
            BLOCKS.register("deepslate_osmium_ore", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.DEEPSLATE)
                                    .strength(4.5f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> OSMIUM_BLOCK =
            BLOCKS.register("osmium_block", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.METAL)
                                    .strength(5.0f, 6.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    //Silver
    public static final DeferredBlock<Block> SILVER_ORE =
            BLOCKS.register("silver_ore", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.STONE)
                                    .strength(3.0f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE =
            BLOCKS.register("deepslate_silver_ore", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.DEEPSLATE)
                                    .strength(4.5f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> SILVER_BLOCK =
            BLOCKS.register("silver_block", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.METAL)
                                    .strength(5.0f, 6.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    //Lead
    public static final DeferredBlock<Block> GALENA =
            BLOCKS.register("galena", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.STONE)
                                    .strength(3.0f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> DEEPSLATE_GALENA =
            BLOCKS.register("deepslate_galena", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.DEEPSLATE)
                                    .strength(4.5f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> END_LEAD_ORE =
            BLOCKS.register("end_lead_ore", registryName ->
                    new DropExperienceBlock(
                            ConstantInt.of(1),
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.SAND)
                                    .strength(3.0f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );

    public static final DeferredBlock<Block> NETHER_SILVER_ORE =
            BLOCKS.register("nether_silver_ore", registryName ->
                    new DropExperienceBlock(
                            UniformInt.of(0, 1),
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.NETHER)
                                    .strength(3.0f, 3.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );

    public static final DeferredBlock<Block> LEAD_BLOCK =
            BLOCKS.register("lead_block", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.METAL)
                                    .strength(5.0f, 6.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );

    //Lithium
    public static final DeferredBlock<Block> SPODUMENE_ORE =
            registerSimpleBlock("spodumene_ore", MapColor.STONE, 3.0f, 3.0f);
    public static final DeferredBlock<Block> DEEPSLATE_SPODUMENE_ORE =
            registerSimpleBlock("deepslate_spodumene_ore", MapColor.DEEPSLATE, 4.5f, 3.0f);
    public static final DeferredBlock<Block> LITHIUM_BLOCK =
            BLOCKS.registerBlock("lithium_block",
                    props -> new AlkaliMetalReactiveBlock(
                            props.strength(5.0F, 6.0F).randomTicks(),
                            3.0F,
                            () -> ModBlocks.LITHIUM_OXIDE_BLOCK.get(),
                            0.05F
                    ));
    public static final DeferredBlock<Block> LITHIUM_OXIDE_BLOCK =
            BLOCKS.registerBlock("lithium_oxide_block",
                    props -> new AlkaliMetalReactiveBlock(
                            props.strength(5.0F, 6.0F),
                            1.5F
                    ));

    //Tin
    public static final DeferredBlock<Block> CASSITERITE_ORE =
            registerSimpleBlock("cassiterite_ore", MapColor.STONE, 3.0f, 3.0f);
    public static final DeferredBlock<Block> DEEPSLATE_CASSITERITE_ORE =
            registerSimpleBlock("deepslate_cassiterite_ore", MapColor.DEEPSLATE, 4.5f, 3.0f);
    public static final DeferredBlock<Block> TIN_BLOCK =
            registerSimpleBlock("tin_block", MapColor.METAL, 5.0f, 6.0f);

    //Titanium
    public static final DeferredBlock<Block> RUTILE_ORE =
            registerSimpleBlock("rutile_ore", MapColor.STONE, 3.0f, 3.0f);
    public static final DeferredBlock<Block> DEEPSLATE_RUTILE_ORE =
            registerSimpleBlock("deepslate_rutile_ore", MapColor.DEEPSLATE, 4.5f, 3.0f);
    public static final DeferredBlock<Block> TITANIUM_BLOCK =
            registerSimpleBlock("titanium_block", MapColor.METAL, 5.0f, 6.0f);

    //Vanadium
    public static final DeferredBlock<Block> VANADIUM_BLOCK =
            registerSimpleBlock("vanadium_block", MapColor.METAL, 5.0f, 6.0f);

    //Compound Minerals
    public static final DeferredBlock<Block> VANADIUM_TITANOMAGNETITE_ORE =
            registerSimpleBlock("vanadium_titanomagnetite_ore", MapColor.STONE, 3.0f, 3.0f);
    public static final DeferredBlock<Block> DEEPSLATE_VANADIUM_TITANOMAGNETITE_ORE =
            registerSimpleBlock("deepslate_vanadium_titanomagnetite_ore", MapColor.DEEPSLATE, 4.5f, 3.0f);
    public static final DeferredBlock<Block> ILMENITE_ORE =
            registerSimpleBlock("ilmenite_ore", MapColor.STONE, 3.0f, 3.0f);
    public static final DeferredBlock<Block> DEEPSLATE_ILMENITE_ORE =
            registerSimpleBlock("deepslate_ilmenite_ore", MapColor.DEEPSLATE, 4.5f, 3.0f);
    public static final DeferredBlock<Block> LEPIDOLITE_ORE =
            registerSimpleBlock("lepidolite_ore", MapColor.STONE, 3.0f, 3.0f);
    public static final DeferredBlock<Block> DEEPSLATE_LEPIDOLITE_ORE =
            registerSimpleBlock("deepslate_lepidolite_ore", MapColor.DEEPSLATE, 4.5f, 3.0f);
    public static final DeferredBlock<Block> DEPOSITED_SALT_BLOCK =
            registerBlockWithoutCorrectTool("deposited_salt_block", MapColor.SAND, 2.0f, 2.0f);

    public static final DeferredBlock<HydroGeneratorBlock> HYDRO_GENERATOR =
            registerHydroGenerator("hydro_generator", new HydroGeneratorBlock.Settings(
                    1, 4, 20)
            );
    public static final DeferredBlock<HydroGeneratorBlock> HYDRO_GENERATOR_PLUS =
            registerHydroGenerator("hydro_generator_plus", new HydroGeneratorBlock.Settings(
                    2, 10, 40)
            );
    public static final DeferredBlock<HydroGeneratorBlock> HYDRO_GENERATOR_MAX =
            registerHydroGenerator("hydro_generator_max", new HydroGeneratorBlock.Settings(
                    2, 24, 80)
            );

    private static DeferredBlock<Block> registerSimpleBlock(String name, MapColor mapColor, float destroyTime, float explosionResistance) {
        return BLOCKS.register(name, registryName ->
                new Block(
                        BlockBehaviour.Properties.of()
                                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                .mapColor(mapColor)
                                .strength(destroyTime, explosionResistance)
                                .requiresCorrectToolForDrops()
                )
        );
    }

    private static DeferredBlock<Block> registerBlockWithoutCorrectTool(String name, MapColor mapColor, float destroyTime, float explosionResistance) {
        return BLOCKS.register(name, registryName ->
                new Block(
                        BlockBehaviour.Properties.of()
                                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                .mapColor(mapColor)
                                .strength(destroyTime, explosionResistance)
                )
        );
    }

    private static DeferredBlock<HydroGeneratorBlock> registerHydroGenerator(String name, HydroGeneratorBlock.Settings settings) {
        return BLOCKS.register(name, registryName ->
                    new HydroGeneratorBlock(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.METAL)
                                    .strength(4.0f, 8.0f)
                                    .requiresCorrectToolForDrops(),
                            settings
                    )
            );
    }
}
