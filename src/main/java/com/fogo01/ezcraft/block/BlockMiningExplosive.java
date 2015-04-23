package com.fogo01.ezcraft.block;

import com.fogo01.ezcraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMiningExplosive extends BlockEzCraft {

    public BlockMiningExplosive() {
        super();
        this.setBlockName("MiningExplosive");
        this.setBlockTextureName("MiningExplosive");
        this.setResistance(0F);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData) {
        super.onBlockDestroyedByPlayer(world, x, y, z, metaData);
        EntityTNTPrimed entitytntprimed0 = new EntityTNTPrimed(world, (double) ((float) x - 4.5F), (double) ((float) y + 0.5F), (double) ((float) z - 4.5), null);
        entitytntprimed0.fuse = 180;
        entitytntprimed0.motionX = 0;
        entitytntprimed0.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed0);
        world.playSoundAtEntity(entitytntprimed0, "game.tnt.primed", 1.0F, 1.0F);

        EntityTNTPrimed entitytntprimed1 = new EntityTNTPrimed(world, (double) ((float) x - 4.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), null);
        entitytntprimed1.fuse = 180;
        entitytntprimed1.motionX = 0;
        entitytntprimed1.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed1);
        world.playSoundAtEntity(entitytntprimed1, "game.tnt.primed", 1.0F, 1.0F);

        EntityTNTPrimed entitytntprimed2 = new EntityTNTPrimed(world, (double) ((float) x -4.5F), (double) ((float) y + 0.5F), (double) ((float) z + 5.5F), null);
        entitytntprimed2.fuse = 180;
        entitytntprimed2.motionX = 0;
        entitytntprimed2.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed2);
        world.playSoundAtEntity(entitytntprimed2, "game.tnt.primed", 1.0F, 1.0F);


        EntityTNTPrimed entitytntprimed3 = new EntityTNTPrimed(world, (double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z - 4.5), null);
        entitytntprimed3.fuse = 180;
        entitytntprimed3.motionX = 0;
        entitytntprimed3.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed3);
        world.playSoundAtEntity(entitytntprimed3, "game.tnt.primed", 1.0F, 1.0F);

        EntityTNTPrimed entitytntprimed4 = new EntityTNTPrimed(world, (double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), null);
        entitytntprimed4.fuse = 180;
        entitytntprimed4.motionX = 0;
        entitytntprimed4.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed4);
        world.playSoundAtEntity(entitytntprimed4, "game.tnt.primed", 1.0F, 1.0F);

        EntityTNTPrimed entitytntprimed5 = new EntityTNTPrimed(world, (double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 5.5F), null);
        entitytntprimed5.fuse = 180;
        entitytntprimed5.motionX = 0;
        entitytntprimed5.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed5);
        world.playSoundAtEntity(entitytntprimed5, "game.tnt.primed", 1.0F, 1.0F);


        EntityTNTPrimed entitytntprimed6 = new EntityTNTPrimed(world, (double) ((float) x + 5.5F), (double) ((float) y + 0.5F), (double) ((float) z - 4.5), null);
        entitytntprimed6.fuse = 180;
        entitytntprimed6.motionX = 0;
        entitytntprimed6.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed6);
        world.playSoundAtEntity(entitytntprimed6, "game.tnt.primed", 1.0F, 1.0F);

        EntityTNTPrimed entitytntprimed7 = new EntityTNTPrimed(world, (double) ((float) x + 5.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), null);
        entitytntprimed7.fuse = 180;
        entitytntprimed7.motionX = 0;
        entitytntprimed7.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed7);
        world.playSoundAtEntity(entitytntprimed7, "game.tnt.primed", 1.0F, 1.0F);

        EntityTNTPrimed entitytntprimed8 = new EntityTNTPrimed(world, (double) ((float) x + 5.5F), (double) ((float) y + 0.5F), (double) ((float) z + 5.5F), null);
        entitytntprimed8.fuse = 180;
        entitytntprimed8.motionX = 0;
        entitytntprimed8.motionZ = 0;
        world.spawnEntityInWorld(entitytntprimed8);
        world.playSoundAtEntity(entitytntprimed8, "game.tnt.primed", 1.0F, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return p_149691_1_ == 0 ? this.bottom : (p_149691_1_ == 1 ? this.top : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getTextureName() + "_side");
        this.top = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getTextureName() + "_top");
        this.bottom = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getTextureName() + "_bottom");
    }
}
