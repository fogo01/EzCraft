package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.block.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static final BlockEzCraft AlOre = new BlockAlOre();
    public static final BlockEzCraft AlBlock = new BlockAlBlock();
    public static final BlockEzCraft Turbine = new BlockTurbine();
    public static final BlockEzCraft MiningExplosive = new BlockMiningExplosive();
    public static final BlockEzCraft DeployableMine = new BlockDeployableMine();
    public static final BlockEzCraft MagicCarpetBlock = new BlockMagicCarpetBlock();

    public static void init(){
        GameRegistry.registerBlock(AlOre, "AlOre");
        GameRegistry.registerBlock(AlBlock, "AlBlock");
        GameRegistry.registerBlock(Turbine, "Turbine");
        GameRegistry.registerBlock(MiningExplosive, "MiningExplosive");
        GameRegistry.registerBlock(DeployableMine, "DeployableMine");
        GameRegistry.registerBlock(MagicCarpetBlock, "MagicCarpetBlock");
    }
}
