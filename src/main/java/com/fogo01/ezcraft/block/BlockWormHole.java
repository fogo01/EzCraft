package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityWormHole;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class BlockWormHole extends BlockContainer {
    public BlockWormHole() {
        super(Material.rock);
        this.setBlockUnbreakable();
        this.setBlockName("WormHole");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
        this.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
    }

    @Override
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
        this.setBlockBounds(0, 0, 0, 0, 0, 0);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityWormHole();
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
