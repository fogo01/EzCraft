package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAngelWings extends ItemArmor {
    public ItemAngelWings() {
        super(RefMaterials.ARMOR, 0, 1);
        this.setUnlocalizedName("AngelWings");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MOD_ID + ":AngelWings");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(2).getItem() == ModItems.AngelWings) {
            
        }
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
