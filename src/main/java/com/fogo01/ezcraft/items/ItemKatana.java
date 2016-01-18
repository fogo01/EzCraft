package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModAchievements;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemKatana extends ItemEzCraft {
    public ItemKatana() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("Katana");
        this.setCreativeTab(null);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.getDisplayName().equals("fogo01")) {
            player.addStat(ModAchievements.RickRoll, 1);
            ItemStack item = new ItemStack(Items.record_13).setStackDisplayName("Rick Astley - Never Gonna Give You Up");
            player.inventory.clearInventory(itemStack.getItem(), -1);
            player.inventory.addItemStackToInventory(item);
        }
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        entity.attackEntityFrom(Reference.DMG_Katana, 100.0F);
        return true;
    }
}
