package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemIronHammer extends ItemPickaxe {
    public ItemIronHammer() {
        super(ToolMaterial.IRON);
        this.setMaxStackSize(1);
        this.setTextureName("ezcraft:IronHammer");
        this.setMaxDamage(Reference.IRON_DURABILITY);
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack ,int blockX, int blockY, int blockZ, EntityPlayer player) {
        World world = player.getEntityWorld();
        Block b = world.getBlock(blockX, blockY, blockZ);
        if(canHarvestBlock(b, itemstack) && !player.isSneaking()) {
            int l = determineOrientation(world, blockX, blockY, blockZ, player);

            int X;
            int Y;
            int Z;

            switch (l) {
                //Up    +Y
                case 0:
                    Y = blockY;
                    for (; Y <= blockY + 4; Y++) {

                        X = blockX - 2;
                        for (; X <= blockX + 2; X++) {

                            Z = blockZ - 2;
                            for (; Z <= blockZ + 2; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < Reference.IRON_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode) {
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
                    for (; Y >= blockY - 4; Y--) {

                        X = blockX - 2;
                        for (; X <= blockX + 2; X++) {

                            Z = blockZ - 2;
                            for (; Z <= blockZ + 2; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < Reference.IRON_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode) {
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
                    for (; Z <= blockZ + 4; Z++) {

                        X = blockX - 2;
                        for (; X <= blockX + 2; X++) {

                            Y = blockY - 2;
                            for (; Y <= blockY + 2; Y++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < Reference.IRON_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode) {
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
                    for (; Z >= blockZ - 4; Z--) {

                        X = blockX - 2;
                        for (; X <= blockX + 2; X++) {

                            Y = blockY - 2;
                            for (; Y <= blockY + 2; Y++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < Reference.IRON_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode) {
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
                    for (; X <= blockX + 4; X++) {

                        Y = blockY - 2;
                        for (; Y <= blockY + 2; Y++) {

                            Z = blockZ - 2;
                            for (; Z <= blockZ + 2; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < Reference.IRON_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode) {
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
                    for (; X >= blockX - 4; X--) {

                        Y = blockY - 2;
                        for (; Y <= blockY + 2; Y++) {

                            Z = blockZ - 2;
                            for (; Z <= blockZ + 2; Z++) {

                                Block block = world.getBlock(X, Y, Z);
                                if (block != Blocks.bedrock) {
                                    if (canHarvestBlock(block, itemstack)) {
                                        if (getDamage(itemstack) < Reference.IRON_DURABILITY) {
                                            world.setBlock(X, Y, Z, Blocks.air, 0, 3);
                                            if (!player.capabilities.isCreativeMode) {
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

    public static int determineOrientation(World p_150071_0_, int p_150071_1_, int p_150071_2_, int p_150071_3_, EntityLivingBase p_150071_4_) {
        if (MathHelper.abs((float) p_150071_4_.posX - (float) p_150071_1_) < 2.0F && MathHelper.abs((float)p_150071_4_.posZ - (float)p_150071_3_) < 2.0F) {
            double d0 = p_150071_4_.posY + 1.82D - (double)p_150071_4_.yOffset;

            if (d0 - (double)p_150071_2_ > 2.0D) {
                return 1;
            }

            if ((double)p_150071_2_ - d0 > 0.0D) {
                return 0;
            }
        }

        int l = MathHelper.floor_double((double)(p_150071_4_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "IronHammer");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "IronHammer");
    }

}
