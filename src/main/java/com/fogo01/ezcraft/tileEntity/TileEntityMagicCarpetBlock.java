package com.fogo01.ezcraft.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicCarpetBlock extends TileEntity {
    int life;

    @Override
    public void writeToNBT(NBTTagCompound par1) {
        //super.writeToNBT(par1);
        par1.setInteger("life", life);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1) {
        //super.readFromNBT(par1);
        this.life = par1.getInteger("life");
    }

    @Override
    public void updateEntity() {
        if (life >= 5*20) {
            this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
        }else {
            life++;
        }
    }
}
