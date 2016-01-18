package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.entities.*;
import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {
    public static void init() {
        EntityRegistry.registerModEntity(EntityRailgunBolt.class, "RailgunBolt", 1, Reference.MOD_ID, 120, 3, true);
        EntityRegistry.registerModEntity(EntityFlame.class, "Flame", 2, Reference.MOD_ID, 120, 3, true );
        EntityRegistry.registerModEntity(EntityHomingMissile.class, "HomingMissile", 3, Reference.MOD_ID, 120, 3, true );
    }
}
