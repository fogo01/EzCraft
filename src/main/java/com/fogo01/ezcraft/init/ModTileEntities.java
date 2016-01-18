package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.tileEntity.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntityTurbine.class, "Turbine");
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "Generator");
        GameRegistry.registerTileEntity(TileEntityWormHole.class, "WormHole");
    }
}
