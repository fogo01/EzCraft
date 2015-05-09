package com.fogo01.ezcraft.tileEntity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicCarpetBlock extends TileEntity {
    int life = 0;

    @Override
    public void updateEntity() {
        if (life >= 5*20) {
            this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
        }else {
            life++;
        }
    }
}
