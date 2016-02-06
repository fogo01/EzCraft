package com.fogo01.ezcraft.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicCarpetBlock extends TileEntity {
    int life;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        life = nbtTagCompound.getInteger("life");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("life", life);
    }

    @Override
    public void updateEntity() {
        if (life >= 5*20) {
            if (!this.worldObj.isRemote)
                this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
        }else {
            life++;
        }
    }
}
