package com.fogo01.ezcraft.block;

public class BlockAlOre extends BlockEzCraft {
        public BlockAlOre(){
            super();
            this.setBlockName("AlOre");
            this.setHarvestLevel("pickaxe", 1);
            this.setHardness(3.0F);
            this.setResistance(5.0F);
        }
}
