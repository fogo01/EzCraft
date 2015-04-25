package com.fogo01.ezcraft.container;

import com.fogo01.ezcraft.tileEntity.TileEntityBlastFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.tileentity.TileEntity;

public class ContainerBlastFurnace extends Container {
    private TileEntityBlastFurnace BlastFurnace;

    public int lastBurnTime;
    public int lastCurrentItemBurnTime;
    public int lastCookTime;

    public ContainerBlastFurnace(InventoryPlayer inventory, TileEntityBlastFurnace entity) {
        this.BlastFurnace = entity;

        this.addSlotToContainer(new Slot(entity, 0, 38, 35));
        this.addSlotToContainer(new Slot(entity, 1, 56, 35));
        this.addSlotToContainer(new Slot(entity, 2, 152, 62));
        this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 3, 116, 35));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; i++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 94 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.BlastFurnace.cookTime);
        iCrafting.sendProgressBarUpdate(this, 1, this.BlastFurnace.burnTime);
        iCrafting.sendProgressBarUpdate(this, 2, this.BlastFurnace.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); i ++) {
            ICrafting iCrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.BlastFurnace.cookTime) {
                iCrafting.sendProgressBarUpdate(this, 0,this.BlastFurnace.cookTime);
            }

            if (this.lastBurnTime != this.BlastFurnace.burnTime) {
                iCrafting.sendProgressBarUpdate(this, 1,this.BlastFurnace.burnTime);
            }

            if (this.lastCurrentItemBurnTime != this.BlastFurnace.currentItemBurnTime) {
                iCrafting.sendProgressBarUpdate(this, 2,this.BlastFurnace.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.BlastFurnace.cookTime;
        this.lastBurnTime = this.BlastFurnace.burnTime;
        this.lastCurrentItemBurnTime = this.BlastFurnace.currentItemBurnTime;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int value) {

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }
}
