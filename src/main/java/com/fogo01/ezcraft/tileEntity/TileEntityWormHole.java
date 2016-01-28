package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.reference.ReferenceWormHole;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

public class TileEntityWormHole extends TileEntity {
    public float radius = ReferenceWormHole.radius;
    public float dmgRadius = ReferenceWormHole.dmgRadius;
    public double radiusMulti = -1;

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        LogHelper.info("Write");
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setDouble("radiusMulti", radiusMulti);
        LogHelper.info("Write1");
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        LogHelper.info("Read");
        super.readFromNBT(nbtTagCompound);
        radiusMulti = nbtTagCompound.getDouble("radiusMulti");
        LogHelper.info("Read1");
    }

    @Override
    public void updateEntity() {
        if (radiusMulti == -1) {
            radiusMulti = Math.round((Math.random() * 2 - 1) * 10);
            radiusMulti /= 10;
            worldObj.notifyBlockChange(xCoord, yCoord, zCoord, ModBlocks.WormHole);
        }

        float centreX = xCoord + 0.5f, centreY = yCoord + 0.5f, centreZ = zCoord + 0.5f;

        for (int x = xCoord - (int)radius; x < xCoord + radius; x++) {
            for (int y = yCoord - (int)radius; y < yCoord + radius; y++) {
                for (int z = zCoord - (int)radius; z < zCoord + radius; z++) {
                    if (Math.random() < 0.01)
                        worldObj.spawnParticle("smoke", x + 0.5f,y + 0.5f, z + 0.5f, 0, 0, 0);
                }
            }
        }
        
        AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(centreX - radius, centreY - radius, centreZ - radius, centreX + radius, centreY + radius, centreZ + radius);
        List list = worldObj.getEntitiesWithinAABB(Entity.class, AABB);

        float f = 0;
        Entity entity;
        for (int i = 0; i < list.size(); ++i) {
            entity = (Entity)list.get(i);
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() != ModItems.LeadBoots)
                    f = 0.04f;
            } else {
                f = 0.075f;
            }

            //f -= entity.getDistanceSq(centreX, centreY, centreZ) * 0.0001;

            double X = centreX - entity.posX;
            double Y = centreY - entity.posY;
            double Z = centreZ - entity.posZ;

            entity.addVelocity(X * f, Y * f, Z * f);
        }

        AABB = AxisAlignedBB.getBoundingBox(centreX - dmgRadius, centreY - dmgRadius, centreZ - dmgRadius, centreX + dmgRadius, centreY + dmgRadius, centreZ + dmgRadius);
        list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AABB);

        for (int i = 0; i < list.size(); ++i) {
            entity = (Entity)list.get(i);
            entity.attackEntityFrom(Reference.DMG_WORMHOLE, 1.0f);
        }
    }
}
