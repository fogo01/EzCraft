package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

public class TileEntityWormHole extends TileEntity {
    float radius = 4.0f;
    float dmgRadius = 0.5f;

    @Override
    public void updateEntity() {
        float centreX = xCoord + 0.5f, centreY = yCoord + 0.5f, centreZ = zCoord + 0.5f;

        double x = Math.random(), y = Math.random(), z = Math.random();
        worldObj.spawnParticle("smoke", xCoord + x * 8 - 4, yCoord + y * 8 - 4, zCoord + z * 8 - 4, -x +0.5, -y +0.5, -z +0.5);
        worldObj.spawnParticle("smoke", xCoord + Math.random() * 5 - 2.5, yCoord + Math.random() * 5 - 2.5, zCoord + Math.random() * 5 - 2.5, 0, 0, 0);

        worldObj.spawnParticle("smoke", centreX + x * 2 * radius - radius, centreY + y * 2 * radius - radius, centreZ + z * 2 * radius - radius, -x / 2, -y / 2, -z / 2);

        worldObj.spawnParticle("smoke", centreX, centreY, centreZ, 0.0f, 0.0f, 0.0f);
        
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

            f -= entity.getDistanceSq(centreX, centreY, centreZ) * 0.0001;

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

        for (float x1 = -(dmgRadius + 0.5f); x1 <= dmgRadius + 0.5f; x1++) {
            for (float y1 = -(dmgRadius + 0.5f); y1 <= dmgRadius + 0.5f; y1++) {
                for (float z1 = -(dmgRadius + 0.5f); z1 <= dmgRadius + 0.5f; z1++) {
                    worldObj.spawnParticle("reddust", centreX + x1, centreY + y1, centreZ + z1, 0.0f, -0.05f, 0.0f);
                }
            }
        }

        for (float x1 = -radius; x1 <= radius; x1++) {
            for (float y1 = -radius; y1 <= radius; y1++) {
                for (float z1 = -radius; z1 <= radius; z1++) {
                    if (x1 == radius && y1 == radius || x1 == radius && z1 == radius || y1 == radius && z1 == radius ||
                            x1 == -radius && y1 == -radius || x1 == -radius && z1 == -radius || y1 == -radius && z1 == -radius ||
                            x1 == -radius && y1 == radius || x1 == -radius && z1 == radius || y1 == -radius && z1 == radius ||
                            x1 == radius && y1 == -radius || x1 == radius && z1 == -radius || y1 == radius && z1 == -radius ||

                            x1 == y1 && x1 == z1 || x1 == -y1 && x1 == z1 || x1 == y1 && x1 == -z1 || x1 == -y1 && x1 == -z1)
                        worldObj.spawnParticle("smoke", centreX + x1, centreY + y1, centreZ + z1, 0.0f, -0.05f, 0.0f);
                }
            }
        }
    }
}
