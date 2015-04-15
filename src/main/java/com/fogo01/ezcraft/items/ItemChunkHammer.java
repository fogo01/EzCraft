package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.handler.ConfigurationHandler;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChunkHammer extends ItemEzCraft {
    public ItemChunkHammer(){
        super();
        this.setUnlocalizedName("ChunkHammer");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int clickX, int clickY, int clickZ, int side, float hitX, float hitY, float hitZ) {

        int tempX = clickX % 16;
        int tempZ = clickZ % 16;

        int X = clickX - tempX;
        int Y = clickY;
        int Z = clickZ - tempZ;

        if(tempX <0){
            X = clickX - tempX - 16;
        }

        if(tempZ <0){
            Z = clickZ - tempZ - 16;
        }

        int startX = X;
        int startY = Y;
        int startZ = Z;


        LogHelper.info("tempX:" + tempX + " tempZ:" + tempZ);
        LogHelper.info("X:" + X + "Y:" + Y + " Z:" + Z);

        for (; Y >= /*startY - 5*/0; Y--) {

            X = startX;
            for (; X <= startX + 15; X++) {

                Z = startZ;
                for (; Z <= startZ + 15; Z++) {

                    Block block = world.getBlock(X, Y, Z);
                    if (block != Blocks.bedrock) {
                        world.setBlockToAir(X, Y, Z);
                        if (Y == startY){
                            world.setBlock(X, Y, Z, Blocks.glass);
                        }
                        if(ConfigurationHandler.CPUMeltdown && !world.isRemote) {
                            player.dropItem(getItemFromBlock(block), 1);
                        }
                    }
                }
            }
        }
        return true;
    }

}
