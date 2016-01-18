package com.fogo01.ezcraft.proxy;

import com.fogo01.ezcraft.entities.EntityFlame;
import com.fogo01.ezcraft.entities.EntityRailgunBolt;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.models.ModelAngelWings;
import com.fogo01.ezcraft.render.RenderFlame;
import com.fogo01.ezcraft.render.RenderGenerator;
import com.fogo01.ezcraft.render.RenderRailgunBolt;
import com.fogo01.ezcraft.render.RenderTurbine;
import com.fogo01.ezcraft.tileEntity.TileEntityGenerator;
import com.fogo01.ezcraft.tileEntity.TileEntityTurbine;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ClientProxy extends CommonProxy {

    public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

    public static void registerRenderThings() {


        ModelAngelWings angelWings = new ModelAngelWings(0.5f);

        armorModels.put(ModItems.AngelWings, angelWings);



        RenderingRegistry.registerEntityRenderingHandler(EntityRailgunBolt.class, new RenderRailgunBolt());
        RenderingRegistry.registerEntityRenderingHandler(EntityFlame.class, new RenderFlame());
    }

    public static void registerTileEntitySpecialRender() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurbine.class, new RenderTurbine());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.class, new RenderGenerator());
    }
}
