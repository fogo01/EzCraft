package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.inventory.ContainerGearBox;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityGearBox;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiGearBox extends GuiContainer {
    public TileEntityGearBox tileEntityGearBox;

    public GuiGearBox(InventoryPlayer inventoryPlayer, com.fogo01.ezcraft.tileEntity.TileEntityGearBox tileEntityGearBox) {
        super(new ContainerGearBox(inventoryPlayer, tileEntityGearBox));
        this.xSize = 176;
        this.ySize = 166;
        this.tileEntityGearBox = tileEntityGearBox;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = this.tileEntityGearBox.hasCustomInventoryName() ? this.tileEntityGearBox.getInventoryName() : I18n.format(this.tileEntityGearBox.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("Container.Inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GearBox.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
