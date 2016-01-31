package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.reference.ReferenceWormHole;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

public class TileEntityWormHole extends TileEntity {
    public float radius = ReferenceWormHole.radius;
    public float dmgRadius = ReferenceWormHole.dmgRadius;
    public double radiusMulti;
    public String type;

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        LogHelper.info("Write");
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setDouble("radiusMulti", radiusMulti);
        nbtTagCompound.setString("type", type);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        LogHelper.info("Read");
        super.readFromNBT(nbtTagCompound);
        radiusMulti = nbtTagCompound.getDouble("radiusMulti");
        type = nbtTagCompound.getString("type");
    }

    @Override
    public void updateEntity() {
        float centreX = xCoord + 0.5f, centreY = yCoord + 0.5f, centreZ = zCoord + 0.5f;

        for (int x = xCoord - (int)radius; x < xCoord + radius; x++) {
            for (int y = yCoord - (int)radius; y < yCoord + radius; y++) {
                for (int z = zCoord - (int)radius; z < zCoord + radius; z++) {
                    if (Math.random() < 0.01)
                        worldObj.spawnParticle("smoke", x + 0.5f, y + 0.5f, z + 0.5f, 0, 0, 0);
                }
            }
        }
        
        AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(centreX - radius, centreY - radius, centreZ - radius, centreX + radius, centreY + radius, centreZ + radius);
        List list = worldObj.getEntitiesWithinAABB(Entity.class, AABB);

        Entity entity;
        for (int i = 0; i < list.size(); ++i) {
            float f = 0.0f;
            entity = (Entity)list.get(i);
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                boolean flag = false;
                if (player.getCurrentArmor(0) != null) {
                    if (player.getCurrentArmor(0).getItem() == ModItems.LeadBoots)
                        flag = true;
                }
                if (!flag)
                    f = 0.05f;
            } else {
                f = 0.075f;
            }
            if (entity instanceof EntityLivingBase) {
                boolean flag = false;
                EntityLivingBase entityLiving = (EntityLivingBase)entity;
                if (entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) entity;
                    if (player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null) {
                        if (player.getCurrentArmor(0).getItem() == ModItems.HazmatBoots && player.getCurrentArmor(1).getItem() == ModItems.HazmatLeggings && player.getCurrentArmor(2).getItem() == ModItems.HazmatChest && player.getCurrentArmor(3).getItem() == ModItems.HazmatHelmet)
                            flag = true;
                    }
                }

                if (!flag) {
                    if (type == ReferenceWormHole.types[5]) {
                        entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 5, 0));
                        entityLiving.addPotionEffect(new PotionEffect(Potion.hunger.id, 20 * 5, 0));
                    } else if (type == ReferenceWormHole.types[6]) {
                        entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.id, 20 * 5, 1));
                    } else if (type == ReferenceWormHole.types[7]) {
                        entityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 20 * 5, 0));
                    }
                }
            }
            if (type == ReferenceWormHole.types[1])
                f *= 1.8;

            //f -= entity.getDistanceSq(centreX, centreY, centreZ) * 0.0001;

            double X = centreX - entity.posX;
            double Y = centreY - entity.posY;
            double Z = centreZ - entity.posZ;

            entity.addVelocity(X * f, Y * f, Z * f);
        }

        AABB = AxisAlignedBB.getBoundingBox(centreX - dmgRadius, centreY - dmgRadius, centreZ - dmgRadius, centreX + dmgRadius, centreY + dmgRadius, centreZ + dmgRadius);
        list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AABB);

        float dmg = 1.0f;
        if (type == ReferenceWormHole.types[2])
            dmg *= 2;
        for (int i = 0; i < list.size(); ++i) {
            entity = (Entity)list.get(i);
            entity.attackEntityFrom(Reference.DMG_WORMHOLE, dmg);
        }
    }
}
