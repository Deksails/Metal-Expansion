package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.block.HydroGenerator.HydroGeneratorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MetalExpansion.MODID);

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
                                    .strength(4.0f, 4.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> OSMIUM_BLOCK =
            BLOCKS.register("osmium_block", registryName ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.METAL)
                                    .strength(6.5f, 6.5f)
                                    .requiresCorrectToolForDrops()
                    )
            );

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

    private static DeferredBlock<HydroGeneratorBlock> registerHydroGenerator(String name, HydroGeneratorBlock.Settings settings) {
        return BLOCKS.register(name, registryName ->
                    new HydroGeneratorBlock(
                            BlockBehaviour.Properties.of()
                                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                                    .mapColor(MapColor.METAL)
                                    .strength(3.5f, 3.5f)
                                    .requiresCorrectToolForDrops(),
                            settings
                    )
            );
    }
}
