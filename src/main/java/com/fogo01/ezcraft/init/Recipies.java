package com.fogo01.ezcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipies {
	public static void init(){
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.RedstoneBolt), "TR ", "RAR", " RG", 'R', Items.redstone, 'A', Items.arrow, 'T', Blocks.tnt, 'G', Items.gunpowder);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.MiningExplosive), "TTT", "TTT", "TTT", 'T', Blocks.tnt);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Katana), "S", "S", "D", 'S', Items.nether_star, 'D', Items.diamond);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.DeployableMine), "TLT", "TLT", "TLT", 'T', Blocks.torch, 'L', Blocks.ladder);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.AngelWings), "FGF", "F F", "F F", 'F', Items.feather, 'G', ModItems.GodlyIngot);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyIngot), "DDD", "GSG", "DDD", 'D', Items.diamond, 'G', Items.gold_ingot, 'S', Items.nether_star);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlySword), "G", "G", "S", 'G', ModItems.GodlyIngot, 'S', Blocks.obsidian);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyPickaxe), "GGG", " S ", " S ", 'G', ModItems.GodlyIngot, 'S', Blocks.obsidian);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyShovel), "G", "S", "S", 'G', ModItems.GodlyIngot, 'S', Blocks.obsidian);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyAxe), "GG ", "GS ", " S ", 'G', ModItems.GodlyIngot, 'S', Blocks.obsidian);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyHoe), "GG ", " S ", " S ", 'G', ModItems.GodlyIngot, 'S', Blocks.obsidian);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyHelmet), "GGG", "G G", 'G', ModItems.GodlyIngot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyChestplate), "G G", "GGG", "GGG", 'G', ModItems.GodlyIngot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyLeggings), "GGG", "G G", "G G", 'G', ModItems.GodlyIngot);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GodlyBoots), "G G", "G G", 'G', ModItems.GodlyIngot);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Railgun, 1, ModItems.Railgun.getMaxDamage()), "AAA", "R R", "  R", 'A', "ingotAluminum", 'R', "blockRedstone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.AlBlock), "AAA", "AAA", "AAA", 'A', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.IronHammer), "III", " O ", " O ", 'I', "blockIron", 'O', Blocks.obsidian));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.DiamondHammer), "DDD", " O ", " O ", 'D', "blockDiamond", 'O', Blocks.obsidian));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FlameThrower), "AAA", "F C", 'A', "ingotAluminum", 'F', Items.flint_and_steel, 'C', "blockCoal"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FuelTank), " C ", "CAC", " C ", 'C', Items.coal, 'A', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.EnderPearlLuancher, 1, ModItems.EnderPearlLuancher.getMaxDamage()), "EA ", "AA ", " RA", 'E', Items.ender_eye, 'A', "ingotAluminum", 'R', "blockRedstone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.AluminumBlade), "AAA", 'A', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.AluminumRod), "A", "A", "A", 'A', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.Turbine), "ARA", "BRB", "ARA", 'A', "ingotAluminum", 'R', ModItems.AluminumRod, 'B', ModItems.AluminumBlade));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Coil), " R ", "RIR", " R ", 'R', "dustRedstone", 'I', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ItemMagnet, 1, ModItems.ItemMagnet.getMaxDamage()), "CI", " I", "CI", 'C', ModItems.Coil, 'I', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.MobGrinder), "SSS", "III", 'S', Items.iron_sword, 'I', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.Generator), "CCC", "ARA", "CCC", 'C', ModItems.Coil, 'A', "ingotAluminum", 'R', ModItems.AluminumRod));



        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.AlIngot, 9), ModBlocks.AlBlock));


        GameRegistry.addSmelting(ModBlocks.AlOre, new ItemStack(ModItems.AlIngot), 0.6F);
	}
}
