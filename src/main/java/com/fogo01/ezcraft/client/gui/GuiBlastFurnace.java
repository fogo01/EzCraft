package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.ContainerBlastFurnace;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityBlastFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiBlastFurnace extends GuiContainer {
    public TileEntityBlastFurnace BlastFurnace;

    public static final ResourceLocation bground = new ResourceLocation(Reference.MOD_ID,"textures/gui/guiBlastFurnace.png");

    public GuiBlastFurnace(InventoryPlayer inventoryPlayer, TileEntityBlastFurnace entity) {
        super(new ContainerBlastFurnace(inventoryPlayer, entity));

        this.BlastFurnace = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = this.BlastFurnace.hasCustomInventoryName() ? this.BlastFurnace.getInventoryName() : I18n.format(this.BlastFurnace.getInventoryName(), new Object[0]);

        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("Container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
