package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemGodlyPickaxe extends ItemPickaxe {
    public ItemGodlyPickaxe() {
        super(RefMaterials.GODLY);
        this.setUnlocalizedName("GodlyPickaxe");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":GodlyPickaxe");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyPickaxe");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GodlyPickaxe");
    }
}
