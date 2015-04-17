package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemGodlySword extends ItemSword {
    public ItemGodlySword() {
        super(RefMaterials.GODLY);
        this.setUnlocalizedName("GodlySword");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlySword");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlySword");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlySword");
    }
}
