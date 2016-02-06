package com.fogo01.ezcraft.container;

import com.fogo01.ezcraft.tileEntity.TileEntityTurbine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerTurbine extends Container {
    private TileEntityTurbine tileEntityTurbine;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerTurbine(InventoryPlayer inventoryPlayer, TileEntityTurbine tileEntityTurbine) {
        this.tileEntityTurbine = tileEntityTurbine;
        this.addSlotToContainer(new Slot(tileEntityTurbine, 0, 80, 30));

        int i;
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting p_75132_1_) {
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate(this, 0, this.tileEntityTurbine.turbineBurnTime);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.tileEntityTurbine.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastBurnTime != this.tileEntityTurbine.turbineBurnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityTurbine.turbineBurnTime);
            }

            if (this.lastItemBurnTime != this.tileEntityTurbine.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileEntityTurbine.currentItemBurnTime);
            }
        }

        this.lastBurnTime = this.tileEntityTurbine.turbineBurnTime;
        this.lastItemBurnTime = this.tileEntityTurbine.currentItemBurnTime;
    }

    @Override
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityTurbine.turbineBurnTime = p_75137_2_;
        }

        if (p_75137_1_ == 1) {
            this.tileEntityTurbine.currentItemBurnTime = p_75137_2_;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntityTurbine.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}
