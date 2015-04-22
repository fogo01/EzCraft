package com.fogo01.ezcraft.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class RefMaterials {
    public static Item.ToolMaterial GODLY = EnumHelper.addToolMaterial("GODLY", 4, 10000 , 80.0F, 16.0F, 20);

    public static ItemArmor.ArmorMaterial AGODLY = EnumHelper.addArmorMaterial("AGODLY", 40, new int[]{6, 16, 12, 6}, 20);
}
