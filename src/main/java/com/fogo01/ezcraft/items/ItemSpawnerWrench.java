package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class ItemSpawnerWrench extends ItemEzCraft {
    public ItemSpawnerWrench() {
        this.setUnlocalizedName("SpawnerWrench");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (world.getBlock(x, y, z) == Blocks.mob_spawner) {
            if (world.getTileEntity(x, y, z) instanceof TileEntityMobSpawner) {
                TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getTileEntity(x, y, z);
                LogHelper.info(spawner.func_145881_a().func_98281_h());
                //spawner.field_145882_a.updateSpawner();
            }
        }

        return true;
    }
}
