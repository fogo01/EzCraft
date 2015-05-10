package com.fogo01.ezcraft.handler;

import com.fogo01.ezcraft.client.gui.GuiBlastFurnace;
import com.fogo01.ezcraft.client.gui.GuiGenerator;
import com.fogo01.ezcraft.client.gui.GuiLargeChest;
import com.fogo01.ezcraft.client.gui.GuiTurbine;
import com.fogo01.ezcraft.container.ContainerBlastFurnace;
import com.fogo01.ezcraft.container.ContainerGenerator;
import com.fogo01.ezcraft.container.ContainerLargeChest;
import com.fogo01.ezcraft.container.ContainerTurbine;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.tileEntity.TileEntityBlastFurnace;
import com.fogo01.ezcraft.tileEntity.TileEntityGenerator;
import com.fogo01.ezcraft.tileEntity.TileEntityLargeChest;
import com.fogo01.ezcraft.tileEntity.TileEntityTurbine;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y ,z);

        if (entity != null) {
            switch (ID){
                case Reference.GUI_ID_TURBINE:
                    if (entity instanceof TileEntityTurbine) {
                        return new ContainerTurbine(player.inventory, (TileEntityTurbine) entity);
                    }
                    return null;

                case Reference.GUI_ID_GENERATOR:
                    if (entity instanceof TileEntityGenerator) {
                        return new ContainerGenerator(player.inventory, (TileEntityGenerator) entity);
                    }
                    return null;

                case Reference.GUI_ID_BLASTFURNACE:
                    if (entity instanceof TileEntityBlastFurnace) {
                        return new ContainerBlastFurnace(player.inventory, (TileEntityBlastFurnace) entity);
                    }
                    return null;

                case Reference.GUI_ID_LARGECHEST:
                    if (entity instanceof TileEntityLargeChest) {
                        return new ContainerLargeChest(player.inventory, (TileEntityLargeChest) entity);
                    }
                    return null;
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y ,z);

        if (entity != null) {
            switch (ID){
                case Reference.GUI_ID_TURBINE:
                    if (entity instanceof TileEntityTurbine) {
                        return new GuiTurbine(player.inventory, (TileEntityTurbine) entity);
                    }
                    return null;

                case Reference.GUI_ID_GENERATOR:
                    if (entity instanceof TileEntityGenerator) {
                        return new GuiGenerator(player.inventory, (TileEntityGenerator) entity);
                    }
                    return null;

                case Reference.GUI_ID_BLASTFURNACE:
                    if (entity instanceof TileEntityBlastFurnace) {
                        return new GuiBlastFurnace(player.inventory, (TileEntityBlastFurnace) entity);
                    }
                    return null;

                case Reference.GUI_ID_LARGECHEST:
                    if (entity instanceof TileEntityLargeChest) {
                        return new GuiLargeChest(player.inventory, (TileEntityLargeChest) entity);
                    }
                    return null;
            }
        }
        return null;
    }
}
