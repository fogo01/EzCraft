package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.entities.EntityFlame;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class ItemFlameThrower extends ItemEzCraft {
    public ItemFlameThrower() {
        super();
        this.setUnlocalizedName("FlameThrower");
        this.setMaxDamage(512);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        float f = 0.15F;

        double yaw = player.rotationYaw + (Math.random() * 10) - 5;
        double pitch = player.rotationPitch + (Math.random() * 10) - 5;

        float X = -MathHelper.sin((float)yaw / 180.0F * (float) Math.PI) * MathHelper.cos((float)pitch / 180.0F * (float)Math.PI) * f;
        float Y = -MathHelper.sin((float)pitch / 180.0F * (float)Math.PI) * f;
        float Z = MathHelper.cos((float)yaw / 180.0F * (float)Math.PI) * MathHelper.cos((float)pitch / 180.0F * (float)Math.PI) * f;

        if (getDamage(itemStack) < this.getMaxDamage() && !player.isSneaking() ) {
            EntityFlame entityFlame = new EntityFlame(world, player);
            entityFlame.setVelocity(X, Y, Z);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entityFlame);
            }

            if (!player.capabilities.isCreativeMode) {
                itemStack.damageItem(1, player);
            }
        }

        if (player.isSneaking() && player.inventory.hasItem(ModItems.FuelTank) && getDamage(itemStack) > 128) {
            player.inventory.consumeInventoryItem(ModItems.FuelTank);
            itemStack.damageItem(-128, player);
        }

        return itemStack;
    }
}
