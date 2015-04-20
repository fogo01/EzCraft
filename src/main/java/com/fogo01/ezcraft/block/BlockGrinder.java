package com.fogo01.ezcraft.block;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockGrinder extends BlockEzCraft {
    public BlockGrinder(){
        super();
        this.setBlockName("Grinder");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public void onEntityWalking(World world, int X, int Y, int Z, Entity entity) {
        //super.onEntityWalking(world, X, Y, Z, entity);
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
        if (entityLivingBase.getHealth() > 1) {
            entityLivingBase.attackEntityFrom(DamageSource.cactus, 1.0F);
        }
    }
}
