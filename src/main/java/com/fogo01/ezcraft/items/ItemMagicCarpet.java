package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModBlocks;
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

        int playerX = (int)player.posX;
        int playerY = (int)player.posY;
        int playerZ = (int)player.posZ;

        if (playerX < 0) {
            playerX = playerX -1;
        }

        if (playerZ < 0) {
            playerZ = playerZ -1;
        }

        int X1 = playerX - 3;
        for (; X1 <= playerX + 3; X1++) {
            int Y1 = playerY -3;
            for (; Y1 <= playerY + 3; Y1++) {
                int Z1 = playerZ - 3;
                for (; Z1 <= playerZ + 3; Z1++) {
                    if (!world.isRemote) {
                        Block block = world.getBlock(X1, Y1, Z1);
                        if (block == ModBlocks.MagicCarpetBlock) {
                            world.setBlockToAir(X1, Y1, Z1);
                        }
                    }
                }
            }
        }

        int Y = playerY - 1;

        int X = playerX - 1;
        for (; X <= playerX + 1; X++) {
            int Z = playerZ - 1;
            for (; Z <= playerZ + 1; Z++) {
                if (!world.isRemote) {
                    Block block = world.getBlock(X, Y, Z);
                    if (block == Blocks.air) {
                        world.setBlock(X, Y, Z, ModBlocks.MagicCarpetBlock, 0, 3);
                    }
                }
            }
        }
        return itemStack;
    }
}
