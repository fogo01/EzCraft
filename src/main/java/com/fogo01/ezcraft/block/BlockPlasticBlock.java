package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class BlockPlasticBlock extends BlockEzCraft {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockPlasticBlock() {
        super();
        this.setBlockName("PlasticBlock");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
        for (int meta = 0; meta < Reference.colors.length; meta++)
            list.add(new ItemStack(this, 1, meta));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[MathHelper.clamp_int(meta, 0, Reference.colors.length)];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[Reference.colors.length];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":PlasticBlock_" + Reference.colors[i]);
        }
    }
}
