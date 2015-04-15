package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.items.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ModItems {
    public static final ItemEzCraft Hammer = new ItemHammer();
    public static final ItemEzCraft ChunkHammer = new ItemChunkHammer();
    public static final ItemEzCraft AlIngot = new ItemAlIngot();
    public static final ItemEzCraft Railgun = new ItemRailgun();
    public static final ItemEzCraft RedstoneBolt = new ItemRedstoneBolt();

    public static final ItemPickaxe IronHammer = new ItemIronHammer();
    public static final ItemPickaxe DiamondHammer = new ItemDiamondHammer();

    public static void init(){
        GameRegistry.registerItem(IronHammer, "IronHammer");
        GameRegistry.registerItem(Hammer, "Hammer");
        GameRegistry.registerItem(ChunkHammer, "ChunkHammer");
        GameRegistry.registerItem(DiamondHammer, "DiamondHammer");
        GameRegistry.registerItem(AlIngot, "AlIngot");
        GameRegistry.registerItem(Railgun, "Railgun");
        GameRegistry.registerItem(RedstoneBolt, "RedstoneBolt");
	}
}
