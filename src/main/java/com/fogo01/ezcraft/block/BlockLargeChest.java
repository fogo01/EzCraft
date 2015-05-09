package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.EzCraft;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityBlastFurnace;
import com.fogo01.ezcraft.tileEntity.TileEntityLargeChest;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockLargeChest extends BlockContainer {

    public BlockLargeChest() {
        super(Material.iron);
        this.setCreativeTab(com.fogo01.ezcraft.crativetab.CreativeTabEzCraft.EzCraft_TAB);
        this.setBlockName("LargeChest");
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType(){
        return 0;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float playerX, float playerY, float playerZ) {
        if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityLargeChest) {
            FMLNetworkHandler.openGui(player, EzCraft.instance, Reference.GUI_ID_LARGECHEST, world, x, y, z);
            //player.openGui(EzCraft.instance, Reference.GUI_ID_LARGECHEST, world, x, y, z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        TileEntityLargeChest tileentitychest = new TileEntityLargeChest();
        return tileentitychest;
    }

    @Override
    public void onBlockPlacedBy(World world, int X, int Y, int Z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(X, Y, Z, 2, 2);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(X, Y, Z, 5, 2);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(X, Y, Z, 3, 2);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(X, Y, Z, 4, 2);
        }

        if (itemStack.hasDisplayName()) {
            ((TileEntityBlastFurnace)world.getTileEntity(X, Y, Z)).setGuiDisplayName(itemStack.getDisplayName());
        }
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
