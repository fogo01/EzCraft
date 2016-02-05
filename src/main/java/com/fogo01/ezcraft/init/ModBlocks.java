package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;

public class ModBlocks {
    public static final BlockEzCraft AlOre = new BlockAlOre();
    public static final BlockEzCraft AlBlock = new BlockAlBlock();
    public static final BlockContainer Turbine = new BlockTurbine();
    public static final BlockEzCraft MiningExplosive = new BlockMiningExplosive();
    public static final BlockEzCraft DeployableMine = new BlockDeployableMine();
    public static final BlockContainer MagicCarpetBlock = new BlockMagicCarpetBlock();
    public static final BlockEzCraft MobGrinder = new BlockMobGrinder();
    public static final BlockEzCraft InfiniWater = new BlockInfiniWater();
    public static final BlockContainer Generator = new BlockGenerator();
    public static final BlockContainer CobbleGen = new BlockCobbleGen();
    public static final BlockEzCraft EnergyCable = new BlockEnergyCable();
    public static final BlockEzCraft WoddenShaft = new BlockWoddenShaft();
    public static final BlockContainer GearBox = new BlockGearBox();

    public static final BlockContainer WormHole = new BlockWormHole();

    public static final BlockContainer Crate = new BlockCrate();

    public static final BlockPlasticBlock PlasticBlock = new BlockPlasticBlock();
    public static final BlockIlluminatedPlasticBlock IlluminatedPlasticBlock = new BlockIlluminatedPlasticBlock();

    public static final BlockContainer BlastFurnaceIdle = new BlockBlastfurnace(false);
    public static final BlockContainer BlastFurnaceActive = new BlockBlastfurnace(true);

    public static final BlockContainer LargeChest = new BlockLargeChest();


    public static void init(){
        GameRegistry.registerBlock(AlOre, "AlOre");
        GameRegistry.registerBlock(AlBlock, "AlBlock");
        GameRegistry.registerBlock(Turbine, "Turbine");
        GameRegistry.registerBlock(MiningExplosive, "MiningExplosive");
        GameRegistry.registerBlock(DeployableMine, "DeployableMine");
        GameRegistry.registerBlock(MagicCarpetBlock, "MagicCarpetBlock");
        GameRegistry.registerBlock(MobGrinder, "MobGrinder");
        GameRegistry.registerBlock(InfiniWater, "InfiniWater");
        GameRegistry.registerBlock(Generator, "Generator");
        GameRegistry.registerBlock(CobbleGen, "CobbleGen");
        GameRegistry.registerBlock(EnergyCable, "EnergyCable");
        GameRegistry.registerBlock(WoddenShaft, "WoddenShaft");
        GameRegistry.registerBlock(GearBox, "GearBox");

        GameRegistry.registerBlock(WormHole, "WormHole");

        GameRegistry.registerBlock(Crate, "Crate");

        GameRegistry.registerBlock(PlasticBlock, ItemBlockPlasticBlock.class, "PlasticBlock");
        GameRegistry.registerBlock(IlluminatedPlasticBlock, ItemBlockIlluminatedPlasticBlock.class, "IlluminatedPlasticBlock");

        GameRegistry.registerBlock(BlastFurnaceIdle, "BlastFurnaceIdle");
        GameRegistry.registerBlock(BlastFurnaceActive, "BlastFurnaceActive");

        GameRegistry.registerBlock(LargeChest, "LargeChest");
    }
}
