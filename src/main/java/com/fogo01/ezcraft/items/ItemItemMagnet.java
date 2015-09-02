package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemItemMagnet extends ItemEzCraft {
    private boolean active;

    public ItemItemMagnet() {
        super();
        this.setUnlocalizedName("ItemMagnet");
        this.setMaxStackSize(1);
        this.setMaxDamage(10240);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setBoolean("active", false);
        active = false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if (player.isSneaking() && world.isRemote) {
            if (active) {
                //this.setUnlocalizedName("ItemMagnetUnActive");
                active = false;
            } else {
                //this.setUnlocalizedName("ItemMagnetActive");
                active = true;
            }
        }
        return itemStack;
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (active) {
            list.add("Active: " + EnumChatFormatting.GREEN + active);
        } else {
            list.add("Active: " + EnumChatFormatting.RED + active);
        }
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        EntityPlayer player = null;
        if (entity instanceof EntityPlayer) {
            player = (EntityPlayer)entity;
        }

        if (this.active) {
            LogHelper.info("ACTIVE");
            double playerX = entity.posX;
            double playerY = entity.posY;
            double playerZ = entity.posZ;

            AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(playerX - 4, playerY - 4, playerZ - 4, playerX + 4, playerY + 4, playerZ + 4);
            List items = world.getEntitiesWithinAABB(EntityItem.class, AABB);

            float f = 0.1f;
            EntityItem item;
            for (int i = 0; i < items.size(); ++i) {
                item = (EntityItem) items.get(i);

                double X = playerX - item.posX;
                double Y = playerY - item.posY;
                double Z = playerZ - item.posZ;

                item.addVelocity(X * f, Y * f, Z * f);
            }

            if (items.size() > 0 && !player.capabilities.isCreativeMode) {
                itemStack.setItemDamage(itemStack.getItemDamage() + 1);
            }
        }
    }
}
