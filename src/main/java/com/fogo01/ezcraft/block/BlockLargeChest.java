package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityLargeChest;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class BlockLargeChest extends BlockContainer {

    public BlockLargeChest() {
        super(Material.iron);
        this.setCreativeTab(com.fogo01.ezcraft.crativetab.CreativeTabEzCraft.EzCraft_TAB);
        this.setBlockName("LargeChest");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 22;
    }

    @Override
    public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int side, float playerX, float playerY, float playerZ) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, Reference.MOD_ID, Reference.GUI_ID_LARGECHEST, world, X, Y, Z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        TileEntityLargeChest tileentitychest = new TileEntityLargeChest();
        return tileentitychest;
    }
}
