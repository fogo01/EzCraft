package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefHammers;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDiamondHammer extends ItemPickaxe {
    public ItemDiamondHammer() {
        super(ToolMaterial.EMERALD);
        this.setMaxStackSize(1);
        this.setTextureName("ezcraft:DiamondHammer");
        this.setMaxDamage(RefHammers.DIAMOND_DURABILITY);
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return super.onBlockDestroyed(p_150894_1_, p_150894_2_, p_150894_3_, p_150894_4_, p_150894_5_, p_150894_6_, p_150894_7_);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack ,int blockX, int blockY, int blockZ, EntityPlayer player) {
        //LogHelper.info(itemstack + " " + player + " " + world + " " + blockX + " " + blockY + " " + blockZ + " " + side + " " + hitX + " " + hitY + " " + hitZ);
        //LogHelper.info(side);
        World world = player.getEntityWorld();
        Block b = world.getBlock(blockX, blockY, blockZ);
        if(canHarvestBlock(b, itemstack) && !player.isSneaking()) {
            int l = BlockPistonBase.determineOrientation(world, blockX, blockY, blockZ, player);


            int X;
            int Y;
            int Z;

            switch (l) {
                //Up    +Y
                case 0:
                    Y = blockY;
                    for (; Y <= blockY + 6; Y++) {

                        X = blockX - 3;
                        for (; X <= blockX + 3; X++) {

                            Z = blockZ - 3;
                            for (; Z <= blockZ + 3; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < RefHammers.DIAMOND_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode && !world.isRemote) {
                                                player.dropItem(getItemFromBlock(block), 1);
                                                itemstack.damageItem(1, player);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                //Down  -Y
                case 1:
                    Y = blockY;
                    for (; Y >= blockY - 6; Y--) {

                        X = blockX - 3;
                        for (; X <= blockX + 3; X++) {

                            Z = blockZ - 3;
                            for (; Z <= blockZ + 3; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < RefHammers.DIAMOND_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode && !world.isRemote) {
                                                player.dropItem(getItemFromBlock(block), 1);
                                                itemstack.damageItem(1, player);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                //South +Z
                case 2:
                    Z = blockZ;
                    for (; Z <= blockZ + 6; Z++) {

                        X = blockX - 3;
                        for (; X <= blockX + 3; X++) {

                            Y = blockY - 3;
                            for (; Y <= blockY + 3; Y++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < RefHammers.DIAMOND_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode && !world.isRemote) {
                                                player.dropItem(getItemFromBlock(block), 1);
                                                itemstack.damageItem(1, player);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                //North -Z
                case 3:
                    Z = blockZ;
                    for (; Z >= blockZ - 6; Z--) {

                        X = blockX - 3;
                        for (; X <= blockX + 3; X++) {

                            Y = blockY - 3;
                            for (; Y <= blockY + 3; Y++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < RefHammers.DIAMOND_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode && !world.isRemote) {
                                                player.dropItem(getItemFromBlock(block), 1);
                                                itemstack.damageItem(1, player);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                //East  +X
                case 4:
                    X = blockX;
                    for (; X <= blockX + 6; X++) {

                        Y = blockY - 3;
                        for (; Y <= blockY + 3; Y++) {

                            Z = blockZ - 3;
                            for (; Z <= blockZ + 3; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < RefHammers.DIAMOND_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode && !world.isRemote) {
                                                player.dropItem(getItemFromBlock(block), 1);
                                                itemstack.damageItem(1, player);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                //West -X
                case 5:
                    X = blockX;
                    for (; X >= blockX - 6; X--) {

                        Y = blockY - 3;
                        for (; Y <= blockY + 3; Y++) {

                            Z = blockZ - 3;
                            for (; Z <= blockZ + 3; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < RefHammers.DIAMOND_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode && !world.isRemote) {
                                                player.dropItem(getItemFromBlock(block), 1);
                                                itemstack.damageItem(1, player);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
            }

        }


        return false;
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "DiamondHammer");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "DiamondHammer");
    }
}
