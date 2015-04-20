package com.fogo01.ezcraft;

import com.fogo01.ezcraft.entities.EntityFlame;
import com.fogo01.ezcraft.handler.ConfigurationHandler;
import com.fogo01.ezcraft.entities.EntityRailgunBolt;
import com.fogo01.ezcraft.genaration.BlockGeneration;
import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.init.OreDict;
import com.fogo01.ezcraft.init.Recipies;
import com.fogo01.ezcraft.proxy.ClientProxy;
import com.fogo01.ezcraft.proxy.IProxy;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.render.RenderFlame;
import com.fogo01.ezcraft.render.RenderRailgunBolt;
import com.fogo01.ezcraft.utility.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERISION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class EzCraft {

    BlockGeneration eventWorldGen = new BlockGeneration();

    @Mod.Instance(Reference.MOD_ID)
    public static EzCraft instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();
        OreDict.init();

        EntityRegistry.registerModEntity(EntityRailgunBolt.class, "RailgunBolt", 1, instance, 120, 3, true );
        EntityRegistry.registerModEntity(EntityFlame.class, "Flame", 2, instance, 120, 3, true );

        RenderingRegistry.registerEntityRenderingHandler(EntityRailgunBolt.class, new RenderRailgunBolt());
        RenderingRegistry.registerEntityRenderingHandler(EntityFlame.class, new RenderFlame());

        GameRegistry.registerWorldGenerator(this.eventWorldGen, 0);

        LogHelper.info("Pre Initialization Complete!");
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

        Recipies.init();

        LogHelper.info("Initialization Complete!");
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("Post Initialization Complete!");
    }
}
