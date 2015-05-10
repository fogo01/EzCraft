package com.fogo01.ezcraft.container;

import com.fogo01.ezcraft.tileEntity.TileEntityGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerGenerator extends Container {
    private TileEntityGenerator tileEntityGenerator;

    public ContainerGenerator(InventoryPlayer inventoryPlayer, TileEntityGenerator tileEntityGenerator) {
        this.tileEntityGenerator = tileEntityGenerator;
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
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
