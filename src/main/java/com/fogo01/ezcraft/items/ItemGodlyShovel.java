package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemGodlyShovel extends ItemSpade {
    public ItemGodlyShovel() {
        super(RefMaterials.GODLY);
        this.setUnlocalizedName("GodlyShovel");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyShovel");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyShovel");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyShovel");
    }
}
