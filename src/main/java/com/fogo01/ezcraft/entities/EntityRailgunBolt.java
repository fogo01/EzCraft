package com.fogo01.ezcraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRailgunBolt extends EntityThrowable
{
    public EntityRailgunBolt(World par1World) {
        super(par1World);
    }

    public EntityRailgunBolt(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityRailgunBolt(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.0F;
    }

    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, true);
        this.setDead();
    }

    private int life = 0;
    @Override
    public void onUpdate(){
        super.onUpdate();
        this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, 0, 0, 0);
        life++;
        if(life >= 100) {
            this.setDead();
        }



    }
}
