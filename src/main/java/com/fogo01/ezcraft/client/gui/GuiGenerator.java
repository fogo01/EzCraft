package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.inventory.ContainerGenerator;
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
        name = I18n.format("Container.Inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/Generator.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i1 = this.tileEntityGenerator.getEnergyAmountScaled(100);
        this.drawTexturedModalRect(k + 37, l + 39, 99 - i1, 166, i1 + 1, 10);

        i1 = this.tileEntityGenerator.getItemEnergyAmountScaled(40);
        this.drawTexturedModalRect(k + 155, l + 17 + 39 - i1, 186, 39 - i1, 10, i1 + 1);

    }
}
