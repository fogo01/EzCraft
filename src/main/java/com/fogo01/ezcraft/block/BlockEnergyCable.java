package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockEnergyCable extends BlockEzCraft {

    public BlockEnergyCable(){
        super(Material.rock);
        this.setBlockName("EnergyCable");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setCreativeTab(com.fogo01.ezcraft.crativetab.CreativeTabEzCraft.EzCraft_TAB);
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {
        boolean flag = this.canConnectCableTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1);
        boolean flag1 = this.canConnectCableTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1);
        boolean flag2 = this.canConnectCableTo(p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_);
        boolean flag3 = this.canConnectCableTo(p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_);
        boolean flag4 = this.canConnectCableTo(p_149743_1_, p_149743_2_, p_149743_3_ - 1, p_149743_4_);
        boolean flag5 = this.canConnectCableTo(p_149743_1_, p_149743_2_, p_149743_3_ + 1, p_149743_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        float f4 = 0.375F;
        float f5 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.setBlockBounds(f, f4, f2, f1, f5, f3);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.setBlockBounds(f, f4, f2, f1, f5, f3);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, f4, f2, f1, f5, f3);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        boolean flag = this.canConnectCableTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
        boolean flag1 = this.canConnectCableTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
        boolean flag2 = this.canConnectCableTo(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
        boolean flag3 = this.canConnectCableTo(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
        boolean flag4 = this.canConnectCableTo(p_149719_1_, p_149719_2_, p_149719_3_ - 1, p_149719_4_);
        boolean flag5 = this.canConnectCableTo(p_149719_1_, p_149719_2_, p_149719_3_ + 1, p_149719_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        float f4 = 0.375F;
        float f5 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag4)
        {
            f4 = 0.0F;
        }

        if (flag5)
        {
            f5 = 1.0F;
        }

        this.setBlockBounds(f, f4, f2, f1, f5, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_)
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 0;
    }

    /**
     * Returns true if the specified block can be connected
     */
    public boolean canConnectCableTo(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_)
    {
        Block block = p_149826_1_.getBlock(p_149826_2_, p_149826_3_, p_149826_4_);
        return block == this || block == ModBlocks.Generator;
    }
}
