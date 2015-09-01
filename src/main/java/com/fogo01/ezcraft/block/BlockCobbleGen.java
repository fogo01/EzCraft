package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.tileEntity.TileEntityCobbleGen;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCobbleGen extends BlockContainer {
    public BlockCobbleGen() {
        super(Material.rock);
        this.setBlockName("CobbleGen");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCobbleGen();
    }

    public static void spawn(World world, int x, int y, int z) {
        EntityItem item = new EntityItem(world, x+0.5D, y+1.0D, z+0.5D, new ItemStack(Blocks.cobblestone));
        item.setVelocity(0.0D, 0.5D, 0.0D);
        if (!world.isRemote) {
            world.spawnEntityInWorld(item);
        }
    }
}
