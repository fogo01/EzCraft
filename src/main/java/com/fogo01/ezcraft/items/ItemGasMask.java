package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.RefMaterials;
import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemGasMask extends ItemArmor {
    public ItemGasMask() {
        super(RefMaterials.HAZMAT, 0, 0);
        this.setUnlocalizedName("GasMask");
        this.setTextureName(Reference.MOD_ID + ":GasMask");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/models/armor/gasmask_layer2.png";
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GasMask");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "GasMask");
    }
}
