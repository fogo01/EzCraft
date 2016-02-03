package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class ItemPlasticSheet extends ItemEzCraft {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemPlasticSheet() {
        super();
        this.setUnlocalizedName("PlasticSheet");
        this.setMaxStackSize(64);
        this.setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int meta = 0; meta < Reference.colors.length; meta++)
            list.add(new ItemStack(this, 1, meta));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "PlasticSheet_" + Reference.colors[MathHelper.clamp_int(itemStack.getItemDamage(), 0, Reference.colors.length - 1)]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return icons[MathHelper.clamp_int(meta, 0, Reference.colors.length)];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[Reference.colors.length];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":PlasticSheet_" + Reference.colors[i]);
        }
    }
}
