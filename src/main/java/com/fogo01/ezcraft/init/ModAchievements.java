package com.fogo01.ezcraft.init;

import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class ModAchievements {
    public static final Achievement RickRoll = new Achievement("RickRoll", "RickRoll", 1, -2, Items.record_13, AchievementList.openInventory).setSpecial();

    public static void init() {
        RickRoll.registerStat();
    }
}
