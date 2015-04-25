package com.fogo01.ezcraft.client.gui;

import com.fogo01.ezcraft.container.ContainerBlastFurnace;
import com.fogo01.ezcraft.container.ContainerLargeChest;
import com.fogo01.ezcraft.tileEntity.TileEntityBlastFurnace;
import com.fogo01.ezcraft.tileEntity.TileEntityLargeChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GuiLargeChest extends GuiContainer {
    public TileEntityLargeChest LargeChest;

    public GuiLargeChest(InventoryPlayer inventoryPlayer, TileEntityLargeChest entity) {
        super(new ContainerLargeChest(inventoryPlayer, entity));

        this.LargeChest = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
