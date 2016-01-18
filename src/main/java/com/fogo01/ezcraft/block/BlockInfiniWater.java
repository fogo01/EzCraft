package com.fogo01.ezcraft.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockInfiniWater extends BlockEzCraft {
    public BlockInfiniWater() {
        super();
        this.setBlockName("InfiniWater");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.getCurrentEquippedItem().isItemEqual(new ItemStack(Items.bucket))) {
            player.inventory.consumeInventoryItem(Items.bucket);
            player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket, 1));
        }
        return true;
    }
}
