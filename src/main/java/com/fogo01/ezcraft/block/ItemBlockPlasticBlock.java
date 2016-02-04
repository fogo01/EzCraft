package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockPlasticBlock extends ItemBlockWithMetadata {
    public ItemBlockPlasticBlock(Block block) {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return this.getUnlocalizedName() + "_" + Reference.colors[itemStack.getItemDamage()];
    }
}
