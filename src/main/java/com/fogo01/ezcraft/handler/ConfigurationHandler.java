package com.fogo01.ezcraft.handler;

import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean CPUMeltdown = false;
    public static boolean AlGen = true;

    public static void init(File configFile){
        if(configuration == null) {
            configuration = new Configuration(configFile);
            loadconfiguration();
        }

    }

    @SubscribeEvent
    public void setConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadconfiguration();
        }
    }

    private static void loadconfiguration(){
        CPUMeltdown = configuration.getBoolean("CPUMeltdown", configuration.CATEGORY_GENERAL, false, "Should the Chunk Hammer drop blocks");
        AlGen = configuration.getBoolean("AlGen", configuration.CATEGORY_GENERAL, true, "Should Aluminum Ore generate in the world");

        if (configuration.hasChanged()) {
            configuration.save();
        }

    }
}
