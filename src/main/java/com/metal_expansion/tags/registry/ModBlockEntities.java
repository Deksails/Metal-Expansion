package com.metal_expansion.tags.registry;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.block.HydroGenerator.HydroGeneratorBlockEntity;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MetalExpansion.MODID);

    public static final Supplier<BlockEntityType<HydroGeneratorBlockEntity>> HYDRO_GENERATOR =
            BLOCK_ENTITIES.register("hydro_generator", () ->
                    new BlockEntityType<>(
                            HydroGeneratorBlockEntity::new,
                            ModBlocks.HYDRO_GENERATOR.get(),
                            ModBlocks.HYDRO_GENERATOR_PLUS.get(),
                            ModBlocks.HYDRO_GENERATOR_MAX.get()
                    )
            );
}
