package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.items.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;

public class ModItems {
    public static final ItemEzCraft Hammer = new ItemHammer();
    public static final ItemEzCraft ChunkHammer = new ItemChunkHammer();
    public static final ItemEzCraft AlIngot = new ItemAlIngot();
    public static final ItemEzCraft Railgun = new ItemRailgun();
    public static final ItemEzCraft RedstoneBolt = new ItemRedstoneBolt();
    public static final ItemEzCraft EnderPearlLuancher = new ItemEnderpearlLauncher();

    public static final ItemPickaxe IronHammer = new ItemIronHammer();
    public static final ItemPickaxe DiamondHammer = new ItemDiamondHammer();

    public static final ItemSword GodlySword = new ItemGodlySword();
    public static final ItemPickaxe GodlyPickaxe = new ItemGodlyPickaxe();
    public static final ItemSpade GodlyShovel = new ItemGodlyShovel();
    public static final ItemAxe GodlyAxe = new ItemGodlyAxe();
    public static final ItemHoe GodlyHoe = new ItemGodlyHoe();

    public static final ItemArmor ItemGodlyHelmet = new ItemGodlyHelmet();
    public static final ItemArmor ItemGodlyChestplate = new ItemGodlyChestplate();
    public static final ItemArmor ItemGodlyLeggings = new ItemGodlyLeggings();
    public static final ItemArmor ItemGodlyBoots = new ItemGodlyBoots();

    public static void init(){
        GameRegistry.registerItem(IronHammer, "IronHammer");
        GameRegistry.registerItem(Hammer, "Hammer");
        GameRegistry.registerItem(ChunkHammer, "ChunkHammer");
        GameRegistry.registerItem(DiamondHammer, "DiamondHammer");
        GameRegistry.registerItem(AlIngot, "AlIngot");
        GameRegistry.registerItem(Railgun, "Railgun");
        GameRegistry.registerItem(RedstoneBolt, "RedstoneBolt");
        //GameRegistry.registerItem(EnderPearlLuancher, "EnderpearlLauncher");

        GameRegistry.registerItem(GodlySword, "GodlySword");
        GameRegistry.registerItem(GodlyPickaxe, "GodlyPickaxe");
        GameRegistry.registerItem(GodlyShovel, "GodlyShovel");
        GameRegistry.registerItem(GodlyAxe, "GodlyAxe");
        GameRegistry.registerItem(GodlyHoe, "GodlyHoe");

        GameRegistry.registerItem(ItemGodlyHelmet, "GodlyHelmet");
        GameRegistry.registerItem(ItemGodlyChestplate, "GodlyChestplate");
        GameRegistry.registerItem(ItemGodlyLeggings, "GodlyLeggins");
        GameRegistry.registerItem(ItemGodlyBoots, "GodlyBoots");
	}
}
