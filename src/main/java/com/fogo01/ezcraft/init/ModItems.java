package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.items.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;

public class ModItems {
    public static final ItemEzCraft ChunkHammer = new ItemChunkHammer();
    public static final ItemEzCraft AlIngot = new ItemAlIngot();
    public static final ItemEzCraft Railgun = new ItemRailgun();
    public static final ItemEzCraft RedstoneBolt = new ItemRedstoneBolt();
    public static final ItemEzCraft EnderPearlLuancher = new ItemEnderpearlLauncher();
    public static final ItemEzCraft MagicCarpet = new ItemMagicCarpet();
    public static final ItemEzCraft FlameThrower = new ItemFlameThrower();
    public static final ItemEzCraft FuelTank = new ItemFuelTank();
    public static final ItemEzCraft Katana = new ItemKatana();
    public static final ItemEzCraft SpawnerWrench = new ItemSpawnerWrench();
    public static final ItemEzCraft ItemMagnet = new ItemItemMagnet();
    public static final ItemEzCraft AluminumRod = new ItemAluminumRod();
    public static final ItemEzCraft AluminumBlade = new ItemAluminumBlade();
    public static final ItemEzCraft Coil = new ItemCoil();
    public static final ItemEzCraft Wrench = new ItemWrench();
    public static final ItemEzCraft Launcher = new ItemLauncher();
    public static final ItemEzCraft Scanner = new ItemScanner();
    public static final ItemEzCraft CrateUppgrade = new ItemCrateUppgrade();
    public static final ItemEzCraft PlantMatter = new ItemPlantMatter();
    public static final ItemEzCraft OrganicPlastic = new ItemOrganicPlastic();
    public static final ItemEzCraft PlasticSheet = new ItemPlasticSheet();

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

    public static final ItemArmor GasMask = new ItemGasMask();
    public static final ItemArmor HazmatHelmet = new ItemHazmatHelmet();
    public static final ItemArmor HazmatChest = new ItemHazmatChets();
    public static final ItemArmor HazmatLeggings = new ItemHazmatLeggings();
    public static final ItemArmor HazmatBoots = new ItemHazmatBoots();

    public static final ItemArmor LeadBoots = new ItemLeadBoots();


    public static final ItemArmor ScannerGlasses = new ItemScannerGlasses();
    public static final ItemArmor AngelWings = new ItemAngelWings();


    public static void init(){
        GameRegistry.registerItem(IronHammer, "IronHammer");
        GameRegistry.registerItem(ChunkHammer, "ChunkHammer");
        GameRegistry.registerItem(DiamondHammer, "DiamondHammer");
        GameRegistry.registerItem(AlIngot, "AlIngot");
        GameRegistry.registerItem(Railgun, "Railgun");
        GameRegistry.registerItem(RedstoneBolt, "RedstoneBolt");
        GameRegistry.registerItem(EnderPearlLuancher, "EnderpearlLauncher");
        GameRegistry.registerItem(MagicCarpet, "MagicCarpet");
        GameRegistry.registerItem(FlameThrower, "FlameThrower");
        GameRegistry.registerItem(FuelTank, "FuelTank");
        GameRegistry.registerItem(Katana, "Katana");
        GameRegistry.registerItem(SpawnerWrench, "SpawnerWrench");
        GameRegistry.registerItem(ItemMagnet, "ItemMagnet");
        GameRegistry.registerItem(AluminumRod, "AluminumRod");
        GameRegistry.registerItem(AluminumBlade, "AluminumBlade");
        GameRegistry.registerItem(Coil, "Coil");
        GameRegistry.registerItem(Wrench, "Wrench");
        GameRegistry.registerItem(Launcher, "Launcher");
        GameRegistry.registerItem(Scanner, "Scanner");
        GameRegistry.registerItem(CrateUppgrade, "CrateUppgrade");
        GameRegistry.registerItem(PlantMatter, "PlantMatter");
        GameRegistry.registerItem(OrganicPlastic, "OrganicPlastic");
        GameRegistry.registerItem(PlasticSheet, "PlasticSheet");

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

        GameRegistry.registerItem(GasMask, "GasMask");
        GameRegistry.registerItem(HazmatHelmet, "HazmatHelmet");
        GameRegistry.registerItem(HazmatChest, "HazmatChest");
        GameRegistry.registerItem(HazmatLeggings, "HazmatLeggings");
        GameRegistry.registerItem(HazmatBoots, "HazmatBoots");

        GameRegistry.registerItem(LeadBoots, "LeadBoots");

        GameRegistry.registerItem(ScannerGlasses, "ScannerGlasses");
        GameRegistry.registerItem(AngelWings, "AngelWings");
	}
}
