package com.fogo01.ezcraft.items;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderpearlLauncher extends ItemEzCraft {
    public ItemEnderpearlLauncher(){
        super();
        this.setUnlocalizedName("EnderpearlLauncher");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.ender_pearl)) {
            EntityEnderPearl entityEnderPearl = new EntityEnderPearl(world, player);
            entityEnderPearl.setVelocity(1.0F, 1.0F, 1.0F);

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
