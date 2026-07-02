package com.metal_expansion.tags.energy;

import com.metal_expansion.tags.registry.ModBlockEntities;
import com.metal_expansion.tags.registry.ModItems;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.jspecify.annotations.NonNull;

public final class ModCapabilities {
    private ModCapabilities() {
    }

    public static void registerCapabilities(@NonNull RegisterCapabilitiesEvent event) {
        event.registerItem(
                Capabilities.Energy.ITEM,
                (stack, itemAccess) -> new BatteryEnergyStorage(itemAccess),
                ModItems.LEAD_ACID_BATTERY.get()
        );
        event.registerBlockEntity(
                Capabilities.Item.BLOCK,
                ModBlockEntities.HYDRO_GENERATOR.get(),
                (blockEntity, side) -> blockEntity.getItemHandler()
        );
    }
}
