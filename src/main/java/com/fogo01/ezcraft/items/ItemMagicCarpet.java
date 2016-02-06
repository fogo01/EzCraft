package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemMagicCarpet extends ItemEzCraft {
    private boolean active;

    public ItemMagicCarpet() {
        super();
        this.setUnlocalizedName("MagicCarpet");
        this.setMaxStackSize(1);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setBoolean("active", false);
        active = false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound();
        if (player.isSneaking()) {
            if (nbtTagCompound == null) {
                nbtTagCompound = new NBTTagCompound();
                itemStack.setTagCompound(nbtTagCompound);
                nbtTagCompound.setBoolean("active", false);
            }

            if (!world.isRemote) {
                active = !nbtTagCompound.getBoolean("active");
                if (active)
                    player.addChatMessage(new ChatComponentText("Active: " + EnumChatFormatting.GREEN.toString() + active));
                else
                    player.addChatMessage(new ChatComponentText("Active: " + EnumChatFormatting.RED.toString() + active));
            }

            nbtTagCompound.setBoolean("active", active);
        }
        return itemStack;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
        if (active) {
            int playerX = (int)player.posX;
            int playerY = (int)player.posY;
            int playerZ = (int)player.posZ;

            if (playerX < 0) {
                playerX = playerX -1;
            }

            if (playerZ < 0) {
                playerZ = playerZ -1;
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
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (active) {
            list.add("Active: " + EnumChatFormatting.GREEN + active);
        } else {
            list.add("Active: " + EnumChatFormatting.RED + active);
        }
    }
}
