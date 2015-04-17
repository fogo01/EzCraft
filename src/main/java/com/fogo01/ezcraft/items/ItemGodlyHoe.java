package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemGodlyHoe extends ItemHoe {
    public ItemGodlyHoe() {
        super(RefMaterials.GODLY);
        this.setUnlocalizedName("GodlyHoe");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyHoe");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyHoe");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyHoe");
    }
}
