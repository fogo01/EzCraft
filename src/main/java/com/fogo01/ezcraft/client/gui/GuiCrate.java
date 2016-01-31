package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.inventory.ContainerCrate;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCrate extends GuiContainer {
    public TileEntityCrate tileEntityCrate;

    public GuiCrate(InventoryPlayer inventoryPlayer, TileEntityCrate tileEntityCrate) {
        super(new ContainerCrate(inventoryPlayer, tileEntityCrate));
        this.xSize = 176;
        this.ySize = 166;
        this.tileEntityCrate = tileEntityCrate;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = this.tileEntityCrate.hasCustomInventoryName() ? this.tileEntityCrate.getInventoryName() : I18n.format(this.tileEntityCrate.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/Crate.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i = this.tileEntityCrate.getStorageScaled(100);
        this.drawTexturedModalRect(k + 37, l + 28, 100 - i, 166, i, 10);
    }
}
