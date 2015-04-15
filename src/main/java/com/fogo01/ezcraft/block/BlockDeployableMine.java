package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockDeployableMine extends BlockEzCraft {
    public BlockDeployableMine() {
        super();
        this.setBlockName("DeployableMine");
    }

    @Override
    public boolean onBlockActivated(World world, int blockX, int blockY, int blockZ, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        LogHelper.info(side);

        if(side <= 1) {
            LogHelper.info("Click on a side instead");
        }
        else {
            for (int Y = blockY; Y >= 0; Y--) {
                int X = blockX - 2;
                for (; X <= blockX + 2; X++) {
                    int Z = blockZ - 2;
                    for (; Z <= blockZ + 2; Z++) {
                        Block block = world.getBlock(X, Y, Z);
                        if (block != Blocks.bedrock) {
                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                        }
                    }
                }
            }

            switch (side) {
                case 2:
                for (int Y = blockY; Y >= 0; Y--) {
                    int X = blockX;
                    int Z = blockZ - 2;
                    Block block = world.getBlock(X, Y, Z);
                    if (block == Blocks.air) {
                        world.setBlock(X, Y, Z, Blocks.ladder, 3, 3);
                    }
                }
            }
        }

        return super.onBlockActivated(world, blockX, blockY, blockZ, player, side, p_149727_7_, p_149727_8_, p_149727_9_);
    }
}
