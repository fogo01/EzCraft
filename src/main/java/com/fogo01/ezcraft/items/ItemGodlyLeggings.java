package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemGodlyLeggings extends ItemArmor {
    public ItemGodlyLeggings() {
        super(RefMaterials.AGODLY, 0, 2);
        this.setUnlocalizedName("GodlyLeggings");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyLeggings");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyLeggings");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyLeggings");
    }
}
