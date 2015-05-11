package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.ContainerTurbine;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityTurbine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTurbine extends GuiContainer {
    public TileEntityTurbine tileEntityTurbine;
    
    public GuiTurbine(InventoryPlayer inventoryPlayer, TileEntityTurbine tileEntityTurbine) {
        super(new ContainerTurbine(inventoryPlayer, tileEntityTurbine));
        this.xSize = 176;
        this.ySize = 166;
        this.tileEntityTurbine = tileEntityTurbine;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = this.tileEntityTurbine.hasCustomInventoryName() ? this.tileEntityTurbine.getInventoryName() : I18n.format(this.tileEntityTurbine.getInventoryName(), new Object[0]);

        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("Container.Inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/Turbine.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        if (this.tileEntityTurbine.isBurning()) {
            int i1 = this.tileEntityTurbine.getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(k + 80, l + 47 + 14 - i1, 176, 12 - i1, 14, i1 + 1);
        }
    }
}
