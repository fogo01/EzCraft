package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.EzCraft;
import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityCrate;
import com.fogo01.ezcraft.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrate extends BlockContainer {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons = new IIcon[10];

    public BlockCrate() {
        super(Material.wood);
        this.setBlockName("Crate");
        this.setHarvestLevel("axe", 0);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
        //this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    }

    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return true;
    }

    @Override
    public int getRenderType(){
        return 0;
    }

/**
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        boolean flag = this.canConnectTo(world, x, y, z - 1);
        boolean flag1 = this.canConnectTo(world, x, y, z + 1);
        boolean flag2 = this.canConnectTo(world, x, y - 1, z);
        boolean flag3 = this.canConnectTo(world, x, y + 1, z);
        boolean flag4 = this.canConnectTo(world, x - 1, y, z);
        boolean flag5 = this.canConnectTo(world, x + 1, y, z);
        float f = 0.0625F;
        float f1 = 0.0F;
        float f2 = 0.0625F;
        float f3 = 0.9375F;
        float f4 = 0.875F;
        float f5 = 0.9375F;

        if (flag) {
            f2 = 0.0F;
        }

        if (flag1) {
            f5 = 1.0F;
        }

        if (flag2) {
            f1 = 0.0F;
        }

        if (flag3) {
            f4 = 1.0F;
        }

        if (flag4) {
            f = 0.0F;
        }

        if (flag5) {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, f1, f2, f3, f4, f5);
    }
*/

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (player.isSneaking()) {
            return false;
        } else {
            if (!world.isRemote) {
                if (world.getTileEntity(x, y, z) instanceof TileEntityCrate) {
                    player.openGui(EzCraft.instance, Reference.GUI_ID_CRATE, world, x, y, z);
                }
            }
            return true;
        }
    }

    public boolean canConnectTo(IBlockAccess world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        return block == ModBlocks.Crate;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        IIcon icon = icons[0];

        if (side == 2) {
            if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y + 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y - 1, z))
                icon = icons[1];
            else if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && !canConnectTo(world, x, y + 1, z))
                icon = icons[2];
            else if (canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[3];
            else if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[4];
            else if (!canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[5];
            else if (canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[6];
            else if (!canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[7];
            else if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x + 1, y, z) && !canConnectTo(world, x, y + 1, z))
                icon = icons[8];
            else if (!canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && !canConnectTo(world, x, y + 1, z))
                icon = icons[9];
        } else if (side == 3) {
            if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y + 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y - 1, z))
                icon = icons[1];
            else if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && !canConnectTo(world, x, y + 1, z))
                icon = icons[2];
            else if (canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[3];
            else if (!canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[4];
            else if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[5];
            else if (!canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[6];
            else if (canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y + 1, z))
                icon = icons[7];
            else if (!canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x + 1, y, z) && !canConnectTo(world, x, y + 1, z))
                icon = icons[8];
            else if (canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x + 1, y, z) && !canConnectTo(world, x, y + 1, z))
                icon = icons[9];
        } else if (side == 4) {
            if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y + 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y - 1, z))
                icon = icons[1];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x, y + 1, z))
                icon = icons[2];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[3];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[4];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[5];
            else if (!canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[6];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[7];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x, y + 1, z))
                icon = icons[8];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x, y + 1, z))
                icon = icons[9];
        } else  if (side == 5) {
            if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y + 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y - 1, z))
                icon = icons[1];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x, y + 1, z))
                icon = icons[2];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[3];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[4];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[5];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[6];
            else if (!canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x, y + 1, z))
                icon = icons[7];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && !canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x, y + 1, z))
                icon = icons[8];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x, y - 1, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x, y + 1, z))
                icon = icons[9];
        } else if (side == 0) {
            if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x - 1, y, z))
                icon = icons[1];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[2];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[3];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[4];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x + 1, y, z))
                icon = icons[5];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[6];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x + 1, y, z))
                icon = icons[7];
            else if (!canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[8];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x + 1, y, z))
                icon = icons[9];
        } else if (side == 1) {
            if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x + 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x - 1, y, z))
                icon = icons[1];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[2];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[3];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[4];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x + 1, y, z))
                icon = icons[5];
            else if (canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[6];
            else if (canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && !canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x + 1, y, z))
                icon = icons[7];
            else if (!canConnectTo(world, x, y, z - 1) && !canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && canConnectTo(world, x + 1, y, z))
                icon = icons[8];
            else if (!canConnectTo(world, x, y, z - 1) && canConnectTo(world, x - 1, y, z) && canConnectTo(world, x, y, z + 1) && !canConnectTo(world, x + 1, y, z))
                icon = icons[9];
        }

        return icon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata) {
        return icons[0];
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_middle");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_top");
        icons[3] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_bottom");
        icons[4] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_left");
        icons[5] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_right");
        icons[6] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_bottomleft");
        icons[7] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_bottomright");
        icons[8] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_topleft");
        icons[9] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_topright");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCrate();
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
