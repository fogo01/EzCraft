package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockInfiniWater extends BlockEzCraft {
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    public BlockInfiniWater() {
        super();
        this.setBlockName("InfiniWater");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.getCurrentEquippedItem() != null) {
            if (player.getCurrentEquippedItem().isItemEqual(new ItemStack(Items.bucket)) && !player.capabilities.isCreativeMode) {
                player.inventory.consumeInventoryItem(Items.bucket);
                player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket, 1));
            }
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : this.blockIcon);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":InfiniWater");
        iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":InfiniWaterTop");
        iconBottom = iconRegister.registerIcon(Reference.MOD_ID + ":InfiniWaterBottom");
    }
}
