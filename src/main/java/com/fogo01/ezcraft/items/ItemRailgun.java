package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.entities.EntityRailgunBolt;
import com.fogo01.ezcraft.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRailgun extends ItemEzCraft {
    public ItemRailgun() {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(10240);
        this.setUnlocalizedName("Railgun");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.RedstoneBolt)) {
            if (itemstack.getItemDamage() < itemstack.getMaxDamage() - 10) {
                EntityRailgunBolt entityBolt = new EntityRailgunBolt(world, player);

                world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));

                if (!player.capabilities.isCreativeMode) {
                    player.inventory.consumeInventoryItem(ModItems.RedstoneBolt);
                    itemstack.damageItem(10, player);
                }

                if (!world.isRemote) {
                    world.spawnEntityInWorld(entityBolt);
                }
            }
        }

        return itemstack;
    }

}
