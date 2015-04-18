package com.fogo01.ezcraft.block;

import net.minecraft.world.World;

import java.util.Random;

public class BlockMagicCarpetBlock extends BlockEzCraft {
    public BlockMagicCarpetBlock() {
        super();
        this.setBlockName("MagicCarpetBlock");
        this.setBlockUnbreakable();
    }

    @Override
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
        return super.onBlockPlaced(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
    }

    @Override
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderBlockPass() {
        return 1;
    }

    public boolean shouldSideBeRendered() {
        return false;
    }
}
