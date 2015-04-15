package com.fogo01.ezcraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockTurbine extends BlockEzCraft {
    public BlockTurbine(){
        super();
        this.setBlockName("Turbine");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    @SideOnly(Side.CLIENT)
    protected IIcon blockIcon;
    protected IIcon blockIconTop;
    protected IIcon blockIconBottom;
    int type;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        if(type == 1) {

        }
        else {
            blockIcon = p_149651_1_.registerIcon("ezcraft:TurbineSideDisabled");
            blockIconTop = p_149651_1_.registerIcon("ezcraft:TurbineTopDisabled");
            blockIconBottom = p_149651_1_.registerIcon("ezcraft:TurbineBottomDisabled");
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata) {
        if (side == 1) {
            return blockIconTop;
        }
        if (side == 0) {
            return blockIconBottom;
        }
        else {
            return blockIcon;
        }
    }
}
