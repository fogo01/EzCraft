package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemGodlyAxe extends ItemAxe {
    public ItemGodlyAxe() {
        super(RefMaterials.GODLY);
        this.setUnlocalizedName("GodlyAxe");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyAxe");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyAxe");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyAxe");
    }
}
