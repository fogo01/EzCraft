package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemAngelWings extends ItemArmor {
    public ItemAngelWings() {
        super(ArmorMaterial.CHAIN, 0, 1);
        this.setUnlocalizedName("AngelWings");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":AngelWings");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/models/armor/Armor_layer2.png";
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "AngelWings");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "AngelWings");
    }
}
