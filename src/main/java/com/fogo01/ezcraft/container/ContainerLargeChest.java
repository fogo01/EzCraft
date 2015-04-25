package com.fogo01.ezcraft.container;

import com.fogo01.ezcraft.tileEntity.TileEntityLargeChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerLargeChest extends Container {
    public ContainerLargeChest(InventoryPlayer inventory, TileEntityLargeChest entity) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 13; i++) {
                this.addSlotToContainer(new Slot(entity, j + i * 9 + 9, 8 + j * 12, 6 + i * 18));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; i++) {
                //this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 94 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            //this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
