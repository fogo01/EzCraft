package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class BlockGrinder extends BlockEzCraft {
    public BlockGrinder(){
        super();
        this.setBlockName("Grinder");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        this.setLightOpacity(255);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int X, int Y, int Z, Entity entity) {
        if (entity instanceof EntityLivingBase ) {
            if (entity.canBeCollidedWith()) {
                if (((EntityLivingBase) entity).getHealth() > 1) {
                    entity.attackEntityFrom(Reference.DMG_Grinder, 1.0F);
                }
            }
        }
    }
}
