package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.block.*;
import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;

public class ModBlocks {
    public static final BlockEzCraft AlOre = new BlockAlOre();
    public static final BlockEzCraft AlBlock = new BlockAlBlock();
    public static final BlockContainer Turbine = new BlockTurbine();
    public static final BlockEzCraft MiningExplosive = new BlockMiningExplosive();
    public static final BlockEzCraft DeployableMine = new BlockDeployableMine();
    public static final BlockContainer MagicCarpetBlock = new BlockMagicCarpetBlock();
    public static final BlockEzCraft Grinder = new BlockGrinder();

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
        GameRegistry.registerBlock(Grinder, "Grinder");

        GameRegistry.registerBlock(BlastFurnaceIdle, "BlastFurnaceIdle");
        GameRegistry.registerBlock(BlastFurnaceActive, "BlastFurnaceActive");

        GameRegistry.registerBlock(LargeChest, "LargeChest");
    }
}
