package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGodlyChestplate extends ItemArmor {
    public ItemGodlyChestplate() {
        super(RefMaterials.AGODLY, 0, 1);
        this.setUnlocalizedName("GodlyChestplate");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyChestplate");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(2).getItem() == ModItems.GodlyChestplate) {
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20, 9));
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20, 9));
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/models/armor/godly_layer2.png";
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyChestplate");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyChestplate");
    }
}
