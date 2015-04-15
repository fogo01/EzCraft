package com.fogo01.ezcraft.crativetab;

import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabEzCraft {
	public static final CreativeTabs EzCraft_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		@Override
		public Item getTabIconItem() {
			return ModItems.Hammer;
		}
	};
}
