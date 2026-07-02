package com.metal_expansion.tags.menu;

import com.metal_expansion.MetalExpansion;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModMenuTypes {
    private ModMenuTypes() {
    }

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, MetalExpansion.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<HydroGeneratorMenu>> HYDRO_GENERATOR =
            MENUS.register("hydro_generator", () ->
                    IMenuTypeExtension.create((containerId, playerInventory, buffer) -> {
                        BlockPos pos = buffer.readBlockPos();
                        return new HydroGeneratorMenu(containerId, playerInventory, pos);
                    })
            );
}