package com.fogo01.ezcraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlame extends EntityThrowable {
    private float speed = 0.15F;
    EntityLivingBase player;

    public EntityFlame(World world) {
        super(world);
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }

    public EntityFlame(World world, EntityLivingBase entity) {
        super(world, entity);
        player = entity;
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }

    public EntityFlame(World world, double X, double Y, double Z) {
        super(world, X, Y, Z);
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0F;
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0, 0, 0);
        Entity entity = movingObjectPosition.entityHit;
        if (entity != null && entity != player) {
            entity.setFire(5);
            entity.setVelocity(this.motionX, this.motionY, this.motionZ);
        }
        this.setDead();
    }

    private int life = 0;
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (life > 0) {
            this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
            this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0, 0, 0);
            this.worldObj.spawnParticle("flame", this.posX + Math.random() - 0.5, this.posY + Math.random() - 0.5, this.posZ + Math.random() - 0.5, 0, 0, 0);
        }

        life++;
        if(life >= 80) {
            this.setDead();
            //this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1, true);
        }
    }
}
