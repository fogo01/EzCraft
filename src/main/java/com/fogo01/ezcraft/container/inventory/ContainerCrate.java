package com.fogo01.ezcraft.container.inventory;


import com.fogo01.ezcraft.tileEntity.TileEntityCrate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

public class ContainerCrate extends Container {
    private TileEntityCrate tileEntityCrate;
    private int lastStackSize;

    public ContainerCrate(InventoryPlayer inventoryPlayer, TileEntityCrate tileEntityCrate) {
        this.tileEntityCrate = tileEntityCrate;
        this.addSlotToContainer(new Slot(tileEntityCrate, 0, 7, 50));
        this.addSlotToContainer(new Slot(tileEntityCrate, 1, 152, 50));
        int i = 0;
        for (i = 0; i < 5; ++i) {
            this.addSlotToContainer(new Slot(tileEntityCrate, i + 2, 43 + i * 18, 50));
        }


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
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntityCrate.isUseableByPlayer(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityCrate.stackSize);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastStackSize != this.tileEntityCrate.stackSize) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityCrate.stackSize);
            }
        }

        this.lastStackSize = this.tileEntityCrate.stackSize;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityCrate.stackSize = p_75137_2_;
        }
    }
}
