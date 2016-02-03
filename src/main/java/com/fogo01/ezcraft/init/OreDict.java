package com.fogo01.ezcraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init() {
        OreDictionary.registerOre("ingotAluminum", ModItems.AlIngot);

        OreDictionary.registerOre("oreAluminum", ModBlocks.AlOre);

        OreDictionary.registerOre("blockAluminum", ModBlocks.AlBlock);

        for (int i = 0; i < 16; i++)
            OreDictionary.registerOre("sheetPlastic", new ItemStack(ModItems.PlasticSheet, 1, i));
    }
}
