package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.entities.EntityHomingMissile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLauncher extends ItemEzCraft {

    public ItemLauncher() {
        super();
        this.setUnlocalizedName("Launcher");
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        EntityHomingMissile entityHomingMissile = new EntityHomingMissile(world, player);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entityHomingMissile);
        }
        return itemStack;
    }
}
