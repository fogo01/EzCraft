package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.reference.ReferenceWormHole;
import com.fogo01.ezcraft.tileEntity.TileEntityWormHole;
import com.fogo01.ezcraft.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.List;

public class BlockWormHole extends BlockContainer {
    public BlockWormHole() {
        super(Material.rock);
        this.setBlockUnbreakable();
        this.setHardness(50.0F);
        this.setResistance(2000.0F);
        this.setBlockName("WormHole");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
        this.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
    }

    @Override
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
        super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        this.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        super.setBlockBoundsForItemRender();
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
    public void onBlockAdded(World world, int x, int y, int z) {
        TileEntityWormHole wormHole = null;
        if (world.getTileEntity(x, y, z) instanceof TileEntityWormHole)
            wormHole = (TileEntityWormHole) world.getTileEntity(x, y, z);
        double d =  Math.round((Math.random() * 2 - 1) * 10);
        d /= 10;
        wormHole.radiusMulti = d;
        wormHole.type = ReferenceWormHole.types[(int)Math.floor(Math.random() * ReferenceWormHole.types.length)];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == ModItems.Scanner) {
            TileEntityWormHole wormHole = null;
            if (world.getTileEntity(x, y, z) instanceof TileEntityWormHole)
                wormHole = (TileEntityWormHole) world.getTileEntity(x, y, z);
            if (!world.isRemote) {
                double temp = wormHole.radius * 2 + 1;
                player.addChatMessage(new ChatComponentText("Range: " + temp + "m"));
                temp = wormHole.dmgRadius * 2 + 1;
                player.addChatMessage(new ChatComponentText("Damage Range: " + temp + "m"));
                temp = wormHole.radiusMulti * 2;
                player.addChatMessage(new ChatComponentText("Extra Range: " + temp + "m"));
                player.addChatMessage(new ChatComponentText("Type: " + wormHole.type));
            }
        }
        return true;
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
