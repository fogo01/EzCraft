package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.init.ModBlocks;
import net.minecraft.world.IBlockAccess;

public class BlockAlBlock extends BlockEzCraft {
    public BlockAlBlock() {
        super();
        this.setBlockName("AlBlock");
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return this == ModBlocks.AlBlock;
    }
}
