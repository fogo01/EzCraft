package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDeployableMine extends BlockEzCraft {
    public BlockDeployableMine() {
        super();
        this.setBlockName("DeployableMine");
        this.setBlockTextureName("DeployableMine");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }


    @Override
    public boolean onBlockActivated(World world, int blockX, int blockY, int blockZ, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        LogHelper.info(side);

        if(side <= 1) {
            LogHelper.info("Click on a side instead");
        }
        else {

            world.playSoundAtEntity(player, "random.anvil_land", 0.3F, 1.0F);

            for (int Y = blockY; Y >= 0; Y--) {
                int X = blockX - 2;
                for (; X <= blockX + 2; X++) {
                    int Z = blockZ - 2;
                    for (; Z <= blockZ + 2; Z++) {
                        Block block = world.getBlock(X, Y, Z);
                        if (block != Blocks.bedrock) {
                            world.setBlock(X, Y, Z, Blocks.air);
                        }
                    }
                }
            }




            switch (side) {
                case 2:
                    for (int Y = blockY - 1; Y >= 0; Y--) {
                        int X = blockX;
                        int Z = blockZ - 2;
                        Block block = world.getBlock(X, Y, Z);
                        Block block1 = world.getBlock(X, Y, Z-1);
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X, Y, Z-1, Blocks.stone);
                        }
                        if (!block.isOpaqueCube()) {
                            world.setBlock(X, Y, Z, Blocks.ladder, 3, 3);
                        }
                    }
                    for (int Y = 0; Y < blockY; Y = Y + 10) {
                        int X = blockX;
                        int Z = blockZ - 3;
                        Block block0 = world.getBlock(X-1, Y, Z);
                        Block block1 = world.getBlock(X+1, Y, Z);
                        if (!block0.isOpaqueCube()) {
                            world.setBlock(X-1, Y, Z, Blocks.stone);
                        }
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X+1, Y, Z, Blocks.stone);
                        }
                        world.setBlock(X-1, Y, Z+1, Blocks.torch, 3, 3);
                        world.setBlock(X+1, Y, Z+1, Blocks.torch, 3, 3);
                    }
                break;

                case 3:
                    for (int Y = blockY - 1; Y >= 0; Y--) {
                        int X = blockX;
                        int Z = blockZ + 2;
                        Block block = world.getBlock(X, Y, Z);
                        Block block1 = world.getBlock(X, Y, Z+1);
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X, Y, Z+1, Blocks.stone);
                        }
                        if (!block.isOpaqueCube()) {
                            world.setBlock(X, Y, Z, Blocks.ladder, 2, 3);
                        }
                    }
                    for (int Y = 0; Y < blockY; Y = Y + 10) {
                        int X = blockX;
                        int Z = blockZ + 3;
                        Block block0 = world.getBlock(X-1, Y, Z);
                        Block block1 = world.getBlock(X+1, Y, Z);
                        if (!block0.isOpaqueCube()) {
                            world.setBlock(X-1, Y, Z, Blocks.stone);
                        }
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X+1, Y, Z, Blocks.stone);
                        }
                        world.setBlock(X-1, Y, Z-1, Blocks.torch, 4, 3);
                        world.setBlock(X+1, Y, Z-1, Blocks.torch, 4, 3);
                    }
                break;

                case 4:
                    for (int Y = blockY - 1; Y >= 0; Y--) {
                        int X = blockX - 2;
                        int Z = blockZ;
                        Block block = world.getBlock(X, Y, Z);
                        Block block1 = world.getBlock(X-1, Y, Z);
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X-1, Y, Z, Blocks.stone);
                        }
                        if (!block.isOpaqueCube()) {
                            world.setBlock(X, Y, Z, Blocks.ladder, 5, 3);
                        }
                    }
                    for (int Y = 0; Y < blockY; Y = Y + 10) {
                        int X = blockX - 3;
                        int Z = blockZ;
                        Block block0 = world.getBlock(X, Y, Z-1);
                        Block block1 = world.getBlock(X, Y, Z+1);
                        if (!block0.isOpaqueCube()) {
                            world.setBlock(X, Y, Z-1, Blocks.stone);
                        }
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X, Y, Z+1, Blocks.stone);
                        }
                        world.setBlock(X+1, Y, Z-1, Blocks.torch, 1, 3);
                        world.setBlock(X+1, Y, Z+1, Blocks.torch, 1, 3);
                    }
                break;

                case 5:
                    for (int Y = blockY - 1; Y >= 0; Y--) {
                        int X = blockX + 2;
                        int Z = blockZ;
                        Block block = world.getBlock(X, Y, Z);
                        Block block1 = world.getBlock(X+1, Y, Z);
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X+1, Y, Z, Blocks.stone);
                        }
                        if (!block.isOpaqueCube()) {
                            world.setBlock(X, Y, Z, Blocks.ladder, 4, 3);
                        }
                    }
                    for (int Y = 0; Y < blockY; Y = Y + 10) {
                        int X = blockX + 3;
                        int Z = blockZ;

                        Block block0 = world.getBlock(X, Y, Z-1);
                        Block block1 = world.getBlock(X, Y, Z+1);
                        if (!block0.isOpaqueCube()) {
                            world.setBlock(X, Y, Z-1, Blocks.stone);
                        }
                        if (!block1.isOpaqueCube()) {
                            world.setBlock(X, Y, Z+1, Blocks.stone);
                        }
                        world.setBlock(X-1, Y, Z-1, Blocks.torch, 2, 3);
                        world.setBlock(X-1, Y, Z+1, Blocks.torch, 2, 3);
                    }
                break;
            }
        }

        return true;
                //super.onBlockActivated(world, blockX, blockY, blockZ, player, side, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return p_149691_1_ == 0 ? this.bottom : (p_149691_1_ == 1 ? this.top : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getTextureName() + "_side");
        this.top = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getTextureName() + "_top");
        this.bottom = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getTextureName() + "_bottom");
    }

}
