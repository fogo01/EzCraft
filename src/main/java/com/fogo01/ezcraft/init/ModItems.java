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
    public static final ItemEzCraft MagicCarpet = new ItemMagicCarpet();
    public static final ItemEzCraft FlameThrower = new ItemFlameThrower();
    public static final ItemEzCraft FuelTank = new ItemFuelTank();

    public static final ItemPickaxe IronHammer = new ItemIronHammer();
    public static final ItemPickaxe DiamondHammer = new ItemDiamondHammer();

    public static final ItemEzCraft GodlyIngot = new ItemGodlyIngot();
    public static final ItemSword GodlySword = new ItemGodlySword();
    public static final ItemPickaxe GodlyPickaxe = new ItemGodlyPickaxe();
    public static final ItemSpade GodlyShovel = new ItemGodlyShovel();
    public static final ItemAxe GodlyAxe = new ItemGodlyAxe();
    public static final ItemHoe GodlyHoe = new ItemGodlyHoe();

    public static final ItemArmor GodlyHelmet = new ItemGodlyHelmet();
    public static final ItemArmor GodlyChestplate = new ItemGodlyChestplate();
    public static final ItemArmor GodlyLeggings = new ItemGodlyLeggings();
    public static final ItemArmor GodlyBoots = new ItemGodlyBoots();

    public static void init(){
        GameRegistry.registerItem(IronHammer, "IronHammer");
        GameRegistry.registerItem(Hammer, "Hammer");
        GameRegistry.registerItem(ChunkHammer, "ChunkHammer");
        GameRegistry.registerItem(DiamondHammer, "DiamondHammer");
        GameRegistry.registerItem(AlIngot, "AlIngot");
        GameRegistry.registerItem(Railgun, "Railgun");
        GameRegistry.registerItem(RedstoneBolt, "RedstoneBolt");
        GameRegistry.registerItem(EnderPearlLuancher, "EnderpearlLauncher");
        GameRegistry.registerItem(MagicCarpet, "MagicCarpet");
        GameRegistry.registerItem(FlameThrower, "FlameThrower");
        GameRegistry.registerItem(FuelTank, "FuelTank");

        GameRegistry.registerItem(GodlyIngot, "GodlyIngot");
        GameRegistry.registerItem(GodlySword, "GodlySword");
        GameRegistry.registerItem(GodlyPickaxe, "GodlyPickaxe");
        GameRegistry.registerItem(GodlyShovel, "GodlyShovel");
        GameRegistry.registerItem(GodlyAxe, "GodlyAxe");
        GameRegistry.registerItem(GodlyHoe, "GodlyHoe");

        GameRegistry.registerItem(GodlyHelmet, "GodlyHelmet");
        GameRegistry.registerItem(GodlyChestplate, "GodlyChestplate");
        GameRegistry.registerItem(GodlyLeggings, "GodlyLeggins");
        GameRegistry.registerItem(GodlyBoots, "GodlyBoots");
	}
}
