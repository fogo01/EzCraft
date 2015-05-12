package com.fogo01.ezcraft.reference;

import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.items.ItemEzCraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class Reference {
    public static final String MOD_ID = "EzCraft";
    public static final String MOD_NAME = "EzCraft";
    public static final String MOD_VERISION = "1.7.10-1.1.0";
    public static final String CLIENT_PROXY_CLASS = "com.fogo01.ezcraft.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.fogo01.ezcraft.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "com.fogo01.ezcraft.client.gui.GuiFactory";


    //------Hammers-------
    //Stone
    public static final int STONE_DURABILITY = 250;

    //IRON
    public static final int IRON_DURABILITY = 1000;

    //DIAMOND
    public static final  int DIAMOND_DURABILITY = 5000;


    //Guis
    public static final int GUI_ID_TURBINE = 0;
    public static final int GUI_ID_GENERATOR = 1;
    public static final int GUI_ID_BLASTFURNACE = 2;
    public static final int GUI_ID_LARGECHEST = 3;

    //DmgSource
    public static DamageSource DMG_Grinder = (new DamageSource("Grinder")).setDamageBypassesArmor();
    public static DamageSource DMG_Katana = (new DamageSource("Katana")).setDamageBypassesArmor().setDamageAllowedInCreativeMode();

    public static ItemStack[] chargeable = new ItemStack[]{new ItemStack(ModItems.Railgun), new ItemStack(ModItems.EnderPearlLuancher)};
}
