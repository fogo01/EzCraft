package com.fogo01.ezcraft.init;

import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init() {
        OreDictionary.registerOre("ingotAluminum", ModItems.AlIngot);

        OreDictionary.registerOre("oreAluminum", ModBlocks.AlOre);

        OreDictionary.registerOre("blockAluminum", ModBlocks.AlBlock);
    }
}
