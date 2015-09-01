package com.fogo01.ezcraft;

import com.fogo01.ezcraft.genaration.BlockGeneration;
import com.fogo01.ezcraft.handler.ConfigurationHandler;
import com.fogo01.ezcraft.handler.GuiHandler;
import com.fogo01.ezcraft.init.*;
import com.fogo01.ezcraft.proxy.ClientProxy;
import com.fogo01.ezcraft.proxy.CommonProxy;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.utility.LogHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERISION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class EzCraft {

    BlockGeneration eventWorldGen = new BlockGeneration();

    @Mod.Instance(Reference.MOD_ID)
    public static com.fogo01.ezcraft.EzCraft instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static CommonProxy Common_Proxy;
    public static ClientProxy Client_proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        ModItems.init();
        ModBlocks.init();
        OreDict.init();
        ModEntities.init();
        ModAchievements.init();

        Client_proxy.registerRenderThings();
        Client_proxy.registerTileEntitySpecialRender();

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
