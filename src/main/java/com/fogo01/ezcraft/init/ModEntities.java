package com.fogo01.ezcraft.init;

import com.fogo01.ezcraft.entities.*;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.render.RenderFlame;
import com.fogo01.ezcraft.render.RenderRailgunBolt;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {
    public static void init() {
        EntityRegistry.registerModEntity(EntityRailgunBolt.class, "RailgunBolt", 1, Reference.MOD_ID, 120, 3, true);
        EntityRegistry.registerModEntity(EntityFlame.class, "Flame", 2, Reference.MOD_ID, 120, 3, true );

        RenderingRegistry.registerEntityRenderingHandler(EntityRailgunBolt.class, new RenderRailgunBolt());
        RenderingRegistry.registerEntityRenderingHandler(EntityFlame.class, new RenderFlame());
    }
}