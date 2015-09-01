package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.block.BlockCobbleGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCobbleGen extends TileEntity {
    boolean water;
    boolean lava;

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        //super.readFromNBT(tagCompound);

        this.water = tagCompound.getBoolean("water");
        this.lava = tagCompound.getBoolean("lava");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        //super.writeToNBT(tagCompound);

        tagCompound.setBoolean("water", this.water);
        tagCompound.setBoolean("lava", this.lava);
    }

    @Override
    public void updateEntity() {
        boolean water = false;
        boolean lava = false;
        Block block[] = {this.worldObj.getBlock(this.xCoord-1, this.yCoord, this.zCoord), this.worldObj.getBlock(this.xCoord+1, this.yCoord, this.zCoord), this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord-1), this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord+1)};

        for (int i = 0; i < block.length; i++) {
            if (block[i] == Blocks.water) {
                water = true;
            } else if (block[i] == Blocks.lava) {
                lava = true;
            }
        }

        if (water && lava) {
            BlockCobbleGen.spawn(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        }
        this.water = water;
        this.lava = lava;
    }
}
