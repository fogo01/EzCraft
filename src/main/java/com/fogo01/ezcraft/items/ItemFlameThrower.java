package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.entities.EntityFlame;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFlameThrower extends ItemEzCraft {
    public ItemFlameThrower() {
        super();
        this.setUnlocalizedName("FlameThrower");
        this.setMaxDamage(512);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        LogHelper.info(player.rotationYaw);
        LogHelper.info(player.rotationPitch);

        float f = 0.8F;


        double yaw = player.rotationYaw;
        double pitch = player.rotationPitch;

        float X = -MathHelper.sin((float)yaw / 180.0F * (float) Math.PI) * MathHelper.cos((float)pitch / 180.0F * (float)Math.PI) * f;
        float Y = -MathHelper.sin((float)pitch / 180.0F * (float)Math.PI) * f;
        float Z = MathHelper.cos((float)yaw / 180.0F * (float)Math.PI) * MathHelper.cos((float)pitch / 180.0F * (float)Math.PI) * f;

        EntityFlame entityFlame = new EntityFlame(world, player);
        if (!world.isRemote) {
            world.spawnEntityInWorld(entityFlame);
        }

        if (!player.capabilities.isCreativeMode) {
            itemStack.damageItem(1, player);
        }
        return itemStack;
    }
}
