package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicCarpet extends ItemEzCraft {
    public ItemMagicCarpet() {
        super();
        this.setUnlocalizedName("MagicCarpet");
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        LogHelper.info("Click");


        int playerX = (int)player.posX;
        int playerY = (int)player.posY;
        int playerZ = (int)player.posZ;

        LogHelper.info(playerX + " " + playerY + " " + playerZ);

        int Y = playerY - 1;

        int X = playerX - 1;
        for (; X <= playerX + 2; X++) {
            int Z = playerZ - 1;
            for (; Z <= playerZ + 2; Z++) {
                if (!world.isRemote) {
                    Block block = world.getBlock(X, Y, Z);
                    if (block == Blocks.air) {
                        world.setBlock(X, Y, Z, ModBlocks.MagicCarpetBlock, 0, 3);
                    }
                }
                LogHelper.info(X + " " + Y + " " + Z);
            }
        }
        return itemStack;
    }
}
