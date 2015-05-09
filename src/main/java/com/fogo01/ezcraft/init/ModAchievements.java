package com.fogo01.ezcraft.init;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class ModAchievements {
    public static final Achievement RickRoll = new Achievement("RickRoll", "RickRoll", 1, -2, Items.record_13, AchievementList.openInventory).setSpecial();

    static void addAchievementLocalizations() {
        LanguageRegistry.instance().addStringLocalization("achievement.TimeAchieve", "en_US", "Got Time Achieve!");
        LanguageRegistry.instance().addStringLocalization("achievement.TimeAchieve.desc", "en_US", "You built a Time Machine!");
    }

    public static void init() {
        RickRoll.registerStat();
        //addAchievementLocalizations();
    }
}
