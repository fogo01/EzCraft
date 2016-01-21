package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.entities.EntityHomingMissile;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class ItemLauncher extends ItemEzCraft {
    private boolean lockOn;
    EntityLivingBase target;
    EntityLivingBase lastTarget;

    public ItemLauncher() {
        super();
        this.setUnlocalizedName("Launcher");
        this.setMaxStackSize(1);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setBoolean("lockOn", false);
        lockOn = false;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        if (lockOn) {
            target = null;
            lastTarget = target;
            EntityPlayer player;
            if (entity instanceof EntityPlayer) {
                player = (EntityPlayer) entity;

                if (player.getHeldItem() != null && player.getHeldItem().isItemEqual(new ItemStack(ModItems.Launcher))) {
                    if (world.isRemote) {
                        MovingObjectPosition movingObjectPosition = player.rayTrace(100D, 1.0f);
                        world.spawnParticle("reddust", movingObjectPosition.blockX + 0.5F, movingObjectPosition.blockY + 1.0F, movingObjectPosition.blockZ + 0.5F, 0D, 0D, 0D);
                        AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(movingObjectPosition.blockX, movingObjectPosition.blockY + 1, movingObjectPosition.blockZ, movingObjectPosition.blockX + 1, movingObjectPosition.blockY + 2, movingObjectPosition.blockZ + 1);
                        List entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AABB);
                        if (entities.size() > 0)
                            target = (EntityLivingBase) entities.get(0);
                        else
                            target = null;
                    }
                    if (target != null) {
                        LogHelper.info(target);
                    }
                }
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound();

        if (!player.isSneaking()) {
            EntityHomingMissile entityHomingMissile = null;
            if (!lockOn) {
                entityHomingMissile = new EntityHomingMissile(world, player, false);
            } else if (target != null){
                entityHomingMissile = new EntityHomingMissile(world, player, true);
                entityHomingMissile.target = target;
            } else {
                if (!world.isRemote)
                player.addChatMessage(new ChatComponentText("No Target"));
            }

            if (!world.isRemote && entityHomingMissile != null) {
                world.spawnEntityInWorld(entityHomingMissile);
            }
        } else {
            if (nbtTagCompound == null) {
                nbtTagCompound = new NBTTagCompound();
                itemStack.setTagCompound(nbtTagCompound);
                nbtTagCompound.setBoolean("lockOn", false);
            }

            if (!world.isRemote) {
                lockOn = !nbtTagCompound.getBoolean("lockOn");
                player.addChatMessage(new ChatComponentText("Lock on set to: " + lockOn));
            }

            nbtTagCompound.setBoolean("lockOn", lockOn);
        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (lockOn) {
            list.add("Lock on: " + EnumChatFormatting.GREEN + lockOn);
        } else {
            list.add("Lock on: " + EnumChatFormatting.RED + lockOn);
        }
    }
}
