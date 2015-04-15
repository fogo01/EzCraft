package com.fogo01.ezcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipies {
	public static void init(){
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.AlBlock), "AAA", "AAA", "AAA", 'A', ModItems.AlIngot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Railgun), "AAA", "R R", "  R", 'A', ModBlocks.AlBlock, 'R', Blocks.redstone_block);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.RedstoneBolt), "TR ", "RAR", " RG", 'R', Items.redstone, 'A', Items.arrow, 'T', Blocks.tnt, 'G', Items.gunpowder);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.MiningExplosive), "TTT", "TTT", "TTT", 'T', Blocks.tnt);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.IronHammer), "III", " O ", " O ", 'I', Blocks.iron_block, 'O', Blocks.obsidian);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.DiamondHammer), "DDD", " O ", " O ", 'D', Blocks.diamond_block, 'O', Blocks.obsidian);


        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.AlIngot, 9), ModBlocks.AlBlock);



        GameRegistry.addSmelting(ModBlocks.AlOre, new ItemStack(ModItems.AlIngot), 0.6F);

	}
}
