package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityMagicCarpetBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMagicCarpetBlock extends BlockContainer {
    public BlockMagicCarpetBlock() {
        super(Material.iron);
        this.setBlockName("MagicCarpetBlock");
        this.setBlockTextureName(Reference.MOD_ID + ":MagicCarpetBlock");
        this.setBlockUnbreakable();
        this.setCreativeTab(null);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityMagicCarpetBlock();
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderBlockPass() {
        return 1;
    }

    public boolean shouldSideBeRendered() {
        return false;
    }



}
