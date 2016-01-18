package com.fogo01.ezcraft.entities;

import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import java.util.List;

public class EntityHomingMissile extends EntityThrowable {
    private int life = 0;

    public EntityHomingMissile(World par1World) {
        super(par1World);
    }

    public EntityHomingMissile(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityHomingMissile(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.0F;
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!worldObj.isRemote) {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, true);
        }
        this.setDead();
        if (movingObjectPosition.entityHit != null && movingObjectPosition.entityHit instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase)movingObjectPosition.entityHit;
            //entity.setVelocity(this.motionX, this.motionY, this.motionZ);
        }
    }

    @Override
    public void onUpdate(){
        super.onUpdate();
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0, 0, 0);
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, -this.motionX / 10, -this.motionY / 10, -this.motionZ / 10);
        this.worldObj.spawnParticle("smoke", this.posX + Math.random() - 0.5, this.posY + Math.random() - 0.5, this.posZ + Math.random() - 0.5, 0, 0, 0);

        //-------
        AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(this.posX - 10, this.posY - 10, this.posZ - 10, this.posX + 10, this.posY + 10, this.posZ + 10);

        List entities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AABB);
        EntityLivingBase entity;
        EntityLivingBase entity1 = null;
        double distance = 0;
        for (int i = 0; i < entities.size(); ++i) {
            entity = (EntityLivingBase)entities.get(i);

            double X = this.posX - entity.posX;
            double Y = this.posY - entity.posY;
            double Z = this.posZ - entity.posZ;

            if (getDistanceSq(X, Y, Z) > distance && entity != this.getThrower()) {
                entity1 = (EntityLivingBase) entities.get(i);
                distance = getDistanceSq(X, Y, Z);
            }
        }

        LogHelper.info(entity1);

        if (entity1 != null) {
            double X = entity1.posX - this.posX;
            double Y = entity1.posY - this.posY;
            double Z = entity1.posZ - this.posZ;
            float f = 0.1f;
            this.addVelocity(X * f, Y * f, Z * f);
        }
        //----------


        if(life >= 100) {
            this.setDead();
        }
        life++;
    }
}
