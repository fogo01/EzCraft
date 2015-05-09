package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.EzCraft;
import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityTurbine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTurbine extends BlockContainer {
    public BlockTurbine(){
        super(Material.rock);
        this.setBlockName("Turbine");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setCreativeTab(com.fogo01.ezcraft.crativetab.CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public int getRenderType() {
        return -1;
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
        return new TileEntityTurbine();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking()) {
            return false;
        } else {
            if (!world.isRemote) {
                if (world.getTileEntity(x, y, z) instanceof TileEntityTurbine) {
                    player.openGui(EzCraft.instance, Reference.GUI_ID_TURBINE, world, x, y, z);
                }
            }

            return true;
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random p_149674_5_) {
        TileEntity tileentity = world.getTileEntity(x, y, z);
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

    public static void updateTurbineBlockState(boolean b, World worldObj, int xCoord, int yCoord, int zCoord) {
    }
}
