package com.metal_expansion.tags.client.screen;

import com.metal_expansion.MetalExpansion;
import com.metal_expansion.tags.menu.HydroGeneratorMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class HydroGeneratorScreen extends AbstractContainerScreen<HydroGeneratorMenu> {
    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(MetalExpansion.MODID, "textures/gui/hydro_generator.png");

    public HydroGeneratorScreen(HydroGeneratorMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractBackground(graphics, mouseX, mouseY, partialTick);
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
    }

    @Override
    public void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        super.extractLabels(graphics, mouseX, mouseY);

        graphics.pose().pushMatrix();
        graphics.pose().scale(0.7f);

        graphics.text(this.font,
                this.menu.getGeneratedPerTick() + " FE/t",
                (int) (103 / 0.7f),
                (int) (13 / 0.7f),
                0xFF404040,
                false
        );

        graphics.text(this.font,
                "Water: " + this.menu.getWaterCount(),
                (int) (103 / 0.7f),
                (int) (19 / 0.7f),
                0xFF404040,
                false
        );

        int energy = this.menu.getStoredItemEnergy();
        int capacity = this.menu.getStoredItemEnergyCapacity();

        graphics.text(this.font,
                "Energy: ",
                (int) (103 / 0.7f),
                (int) (25 / 0.7f),
                0xFF404040,
                false
        );

        graphics.text(this.font,
                String.valueOf(energy),
                (int) (103 / 0.7f),
                (int) (37 / 0.7f),
                0xFF46FF60,
                false
        );
        graphics.text(this.font,
                " / ",
                (int) (103 / 0.7f),
                (int) (49 / 0.7f),
                0xFF404040,
                false
        );
        graphics.text(this.font,
                capacity + " FE",
                (int) (103 / 0.7f),
                (int) (61 / 0.7f),
                0xFF46FF60,
                false
        );

        graphics.pose().popMatrix();
    }
}
