package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.ContainerGenerator;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiGenerator extends GuiContainer {
    public TileEntityGenerator tileEntityGenerator;

    public GuiGenerator(InventoryPlayer inventoryPlayer, com.fogo01.ezcraft.tileEntity.TileEntityGenerator tileEntityGenerator) {
        super(new ContainerGenerator(inventoryPlayer, tileEntityGenerator));
        this.xSize = 176;
        this.ySize = 166;
        this.tileEntityGenerator = tileEntityGenerator;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = this.tileEntityGenerator.hasCustomInventoryName() ? this.tileEntityGenerator.getInventoryName() : I18n.format(this.tileEntityGenerator.getInventoryName(), new Object[0]);

        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("Container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/Generator.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        /*
        if (this.tileEntityGenerator.isBurning()) {
            int i1 = this.tileEntityGenerator.getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(k + 80, l + 47 + 14 - i1, 176, 12 - i1, 14, i1 + 1);
        }
        */
    }
}
