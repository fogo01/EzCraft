package com.fogo01.ezcraft.items;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemEnderpearlLauncher extends ItemEzCraft {
    public ItemEnderpearlLauncher(){
        super();
        this.setUnlocalizedName("EnderpearlLauncher");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        float f = 3.0F;

        float yaw = player.rotationYaw;
        float pitch = player.rotationPitch;

        float X = -MathHelper.sin(yaw / 180.0F * (float) Math.PI) * MathHelper.cos((float)pitch / 180.0F * (float)Math.PI) * f;
        float Y = -MathHelper.sin(pitch / 180.0F * (float)Math.PI) * f;
        float Z = MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos((float)pitch / 180.0F * (float)Math.PI) * f;

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.ender_pearl)) {
            EntityEnderPearl entityEnderPearl = new EntityEnderPearl(world, player);
            entityEnderPearl.setVelocity(X, Y, Z);

            if (!player.capabilities.isCreativeMode) {
                player.inventory.consumeInventoryItem(Items.ender_pearl);
                itemStack.damageItem(1, player);
            }

            if (!world.isRemote) {
                world.spawnEntityInWorld(entityEnderPearl);
            }
        }

        return super.onItemRightClick(itemStack, world, player);
    }
}
