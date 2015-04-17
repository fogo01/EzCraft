package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemGodlyBoots extends ItemArmor {
    public ItemGodlyBoots() {
        super(RefMaterials.AGODLY, 0, 3);
        this.setUnlocalizedName("GodlyBoots");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyBoots");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyBoots");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyBoots");
    }
}
