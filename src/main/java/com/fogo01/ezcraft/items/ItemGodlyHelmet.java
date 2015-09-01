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

public class ItemGodlyHelmet extends ItemArmor {
    public ItemGodlyHelmet() {
        super(RefMaterials.AGODLY, 0, 0);
        this.setUnlocalizedName("GodlyHelmet");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyHelmet");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(3).getItem() == ModItems.GodlyHelmet){
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 9));
            player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20, 9));
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/models/armor/godly_layer2.png";
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyHelmet");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyHelmet");
    }
}
