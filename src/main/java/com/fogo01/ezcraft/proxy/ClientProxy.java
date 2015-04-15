package com.fogo01.ezcraft.proxy;

import com.fogo01.ezcraft.entities.EntityRailgunBolt;
import com.fogo01.ezcraft.render.RenderRailgunBolt;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    public void registerRenderThings() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRailgunBolt.class, new RenderRailgunBolt());
    }

    public void registerTileEntitySpecialRender() {

    }
}
