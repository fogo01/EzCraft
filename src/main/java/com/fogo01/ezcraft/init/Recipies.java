package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.reference.Reference;
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
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.PlasticSheet), "PP", "PP", 'P', ModItems.OrganicPlastic);

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

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.GasMask), " P ", "PGP", 'P', new ItemStack(ModItems.PlasticSheet, 8, 15), 'G', "paneGlass"));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.HazmatHelmet), "PPP", "PGP", 'P', new ItemStack(ModItems.PlasticSheet, 1, 4), 'G', ModItems.GasMask);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.HazmatChest), "P P", "PPP", "PPP", 'P', new ItemStack(ModItems.PlasticSheet, 1, 4));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.HazmatLeggings), "PPP", "P P", "P P", 'P', new ItemStack(ModItems.PlasticSheet, 1, 4));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.HazmatBoots), "P P", "P P", 'P', new ItemStack(ModItems.PlasticSheet, 1, 15));

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
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.Crate), "WCW", "CCC", "WCW", 'W', "plankWood", 'C', Blocks.chest));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Scanner), "RGR", "ADA", 'R', "dustRedstone", 'G', "paneGlassLime", 'A', "ingotAluminum", 'D', "gemDiamond"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.PlantMatter), "SS", "SS", 'S', "treeSapling"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.InfiniWater), " B ", "BCB", " B ", 'B', Items.water_bucket, 'C', "cobblestone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.CobbleGen), "CCC", "CPC", "CCC", 'C', "cobblestone", 'P', Items.iron_pickaxe));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Wrench), " A ", " AA", "A  ", 'A', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.MagicCarpet), "DDD", "DSD", "DDD", 'D', "dyeMagenta", 'S', Items.nether_star));

        for (int i = 0; i < Reference.colors.length; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.PlasticSheet, 8, i), "PPP", "PDP", "PPP", 'P', "sheetPlastic", 'D', "dye" + Reference.colors[i]));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.AlIngot, 9), ModBlocks.AlBlock));

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ScannerGlasses), ModItems.Scanner, Items.leather_helmet);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CrateUppgrade, 1, 0), ModBlocks.Crate);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CrateUppgrade, 1, 1), ModBlocks.Crate, ModBlocks.Crate);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CrateUppgrade, 1, 2), ModBlocks.Crate, ModBlocks.Crate, ModBlocks.Crate);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CrateUppgrade, 1, 3), ModBlocks.Crate, ModBlocks.Crate, ModBlocks.Crate, ModBlocks.Crate);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CrateUppgrade, 1, 4), ModBlocks.Crate, ModBlocks.Crate, ModBlocks.Crate, ModBlocks.Crate, ModBlocks.Crate);


        GameRegistry.addSmelting(ModBlocks.AlOre, new ItemStack(ModItems.AlIngot), 0.6F);
        GameRegistry.addSmelting(ModItems.PlantMatter, new ItemStack(ModItems.OrganicPlastic), 0.3f);
	}
}
