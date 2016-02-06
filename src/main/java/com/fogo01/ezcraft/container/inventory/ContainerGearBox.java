package com.fogo01.ezcraft.container.inventory;

import com.fogo01.ezcraft.tileEntity.TileEntityGearBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGearBox extends Container {
    private TileEntityGearBox tileEntityGearBox;

    public ContainerGearBox(InventoryPlayer inventoryPlayer, TileEntityGearBox tileEntityGearBox) {
        this.tileEntityGearBox = tileEntityGearBox;

        this.addSlotToContainer(new Slot(tileEntityGearBox, 0, 80, 35));


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
        return this.tileEntityGearBox.isUseableByPlayer(p_75145_1_);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}
