package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.EzCraft;
import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityBlastFurnace;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBlastfurnace extends BlockContainer {
    private final boolean isActive;

    private static boolean keepInventory;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    public BlockBlastfurnace(boolean isActive){
        super(Material.iron);
        this.setCreativeTab(com.fogo01.ezcraft.crativetab.CreativeTabEzCraft.EzCraft_TAB);
        this.setBlockName("BlastFurnace");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.isActive = isActive;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":BlastfurnaceSide");
        this.iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":BlastfurnaceFront" + (this.isActive ? "On" : "Off"));
        this.iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":BlastFurnaceTop");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        //return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
        return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
    }

    public Item getItemDropped(World world, int X, int Y, int Z) {
        return Item.getItemFromBlock(ModBlocks.BlastFurnaceIdle);
    }


    @Override
    public void onBlockAdded(World world, int X, int Y, int Z) {
        super.onBlockAdded(world, X, Y, Z);
        this.setDefaultDirection(world, X, Y, Z);
    }

    private void setDefaultDirection(World world, int X, int Y, int Z) {
        if(!world.isRemote) {
            Block block1 = world.getBlock(X, Y, Z - 1);
            Block block2 = world.getBlock(X, Y, Z + 1);
            Block block3 = world.getBlock(X - 1, Y, Z);
            Block block4 = world.getBlock(X + 1, Y, Z);

            byte b = 3;

            if(block1.func_149730_j() && !block2.func_149730_j()) {
                b = 3;
            }

            if(block2.func_149730_j() && !block1.func_149730_j()) {
                b = 2;
            }

            if(block3.func_149730_j() && !block4.func_149730_j()) {
                b = 5;
            }

            if(block4.func_149730_j() && !block3.func_149730_j()) {
                b = 4;
            }
            //world.setBlockMetadataWithNotify(X, Y, Z, b, 2);
        }
    }


    @Override
    public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int side, float playerX, float palyerY, float playerZ) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, Reference.MOD_ID, Reference.GUI_ID_BLASTFURNACE, world, X, Y, Z);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int X, int Y, int Z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
           world.setBlockMetadataWithNotify(X, Y, Z, 2, 2);
        }

        if (l == 1)
        {
           world.setBlockMetadataWithNotify(X, Y, Z, 5, 2);
        }

        if (l == 2)
        {
           world.setBlockMetadataWithNotify(X, Y, Z, 3, 2);
        }

        if (l == 3)
        {
           world.setBlockMetadataWithNotify(X, Y, Z, 4, 2);
        }

        if (itemStack.hasDisplayName())
        {
            ((TileEntityBlastFurnace)world.getTileEntity(X, Y, Z)).setGuiDisplayName(itemStack.getDisplayName());
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBlastFurnace();
    }

    public static void updateBlastfurnaceBlockState(boolean active, World world, int x, int y, int z) {
        int i = world.getBlockMetadata(x, y, z);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        keepInventory = true;

        if (active) {
            world.setBlock(x, y, z, ModBlocks.BlastFurnaceActive);
        }else{
            world.setBlock(x, y, z, ModBlocks.BlastFurnaceIdle);
        }
        keepInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, i, 2);

        if (tileEntity != null) {
            tileEntity.validate();
            world.setTileEntity(x, y, z, tileEntity);
        }
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
