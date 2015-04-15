package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.init.ModBlocks;
import net.minecraft.world.IBlockAccess;

public class BlockAlOre extends BlockEzCraft {
        public BlockAlOre(){
            super();
            this.setBlockName("AlOre");
            this.setHarvestLevel("pickaxe", 1);
        }
}
