package com.fogo01.ezcraft.container.inventory;

import com.fogo01.ezcraft.tileEntity.TileEntityGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerGenerator extends Container {
    private TileEntityGenerator tileEntityGenerator;
    private int lastEnergyAmount;
    private int lastItemEnergyAmount;

    public ContainerGenerator(InventoryPlayer inventoryPlayer, TileEntityGenerator tileEntityGenerator) {
        this.tileEntityGenerator = tileEntityGenerator;
        this.addSlotToContainer(new Slot(tileEntityGenerator, 0, 152, 62));

        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return this.tileEntityGenerator.isUseableByPlayer(p_75145_1_);
    }

    @Override
    public void addCraftingToCrafters(ICrafting p_75132_1_)
    {
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate(this, 0, this.tileEntityGenerator.energyAmount);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.tileEntityGenerator.itemEnergyAmount);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastEnergyAmount != this.tileEntityGenerator.energyAmount)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityGenerator.energyAmount);
            }

            if (this.lastItemEnergyAmount != this.tileEntityGenerator.itemEnergyAmount)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityGenerator.itemEnergyAmount);
            }
        }

        this.lastEnergyAmount = this.tileEntityGenerator.energyAmount;
        this.lastItemEnergyAmount = this.tileEntityGenerator.itemEnergyAmount;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_)
    {
        if (p_75137_1_ == 0)
        {
            this.tileEntityGenerator.energyAmount = p_75137_2_;
        }

        if (p_75137_1_ == 1)
        {
            this.tileEntityGenerator.itemEnergyAmount = p_75137_2_;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            }
            else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }
        return itemstack;
    }
}
