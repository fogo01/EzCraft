package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.tileEntity.TileEntityCrate;
import com.fogo01.ezcraft.tileEntity.TileEntityGenerator;
import com.fogo01.ezcraft.tileEntity.TileEntityTurbine;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemWrench extends ItemEzCraft {

    public ItemWrench() {
        this.setUnlocalizedName("Wrench");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        Block block = world.getBlock(x, y, z);
        String string = "Didn't find a EzCraft Tile Entity";
        if (block == ModBlocks.Turbine) {
            TileEntityTurbine turbine = (TileEntityTurbine)world.getTileEntity(x, y, z);
            int rpm = turbine.rpm;
            int torque = turbine.torque;
            string = "RPM: " + rpm + " Torque: " + torque;
        } else if (block == ModBlocks.Generator) {
            TileEntityGenerator generator = (TileEntityGenerator)world.getTileEntity(x, y, z);
            int rpm = generator.rpm;
            int torque = generator.torque;
            string = "RPM: " + rpm + " Torque: " + torque;
        } else if (block == ModBlocks.Crate) {
            TileEntityCrate crate = (TileEntityCrate)world.getTileEntity(x, y, z);
            if (crate.currentStack != null)
                string = crate.currentStack.getDisplayName() + ": " + crate.stackSize + "/" + crate.maxSize;
            else
                string = "Empty";
        }

        if (!world.isRemote) {
            player.addChatMessage(new ChatComponentText(string));
        }
        return true;
    }
}
