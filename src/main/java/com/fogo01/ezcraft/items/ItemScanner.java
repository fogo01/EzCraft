package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.tileEntity.TileEntityWormHole;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class ItemScanner extends ItemEzCraft {
    public ItemScanner() {
        super();
        this.setUnlocalizedName("Scanner");
        this.setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        EntityPlayer player;
        if (entity instanceof EntityPlayer) {
            player = (EntityPlayer) entity;

            int range = 32;
            int radius = 4;

            if (player.getHeldItem() != null && player.getHeldItem().isItemEqual(new ItemStack(ModItems.Scanner))) {
                AxisAlignedBB.getBoundingBox(player.posX - range, player.posY - range, player.posZ - range, player.posX + range, player.posY + range, player.posZ + range);

                for (int x = (int) player.posX - range; x < player.posX + range; x++) {
                    for (int y = (int) player.posY - range; y < player.posY + range; y++) {
                        for (int z = (int) player.posZ - range; z < player.posZ + range; z++) {
                            if (world.getBlock(x, y, z) == ModBlocks.WormHole) {
                                for (float x1 = -radius; x1 <= radius; x1++) {
                                    for (float y1 = -radius; y1 <= radius; y1++) {
                                        for (float z1 = -radius; z1 <= radius; z1++) {
                                            if (x1 == radius && y1 == radius || x1 == radius && z1 == radius || y1 == radius && z1 == radius ||
                                                    x1 == -radius && y1 == -radius || x1 == -radius && z1 == -radius || y1 == -radius && z1 == -radius ||
                                                    x1 == -radius && y1 == radius || x1 == -radius && z1 == radius || y1 == -radius && z1 == radius ||
                                                    x1 == radius && y1 == -radius || x1 == radius && z1 == -radius || y1 == radius && z1 == -radius ||

                                                    x1 == y1 && x1 == z1 || x1 == -y1 && x1 == z1 || x1 == y1 && x1 == -z1 || x1 == -y1 && x1 == -z1)
                                                world.spawnParticle("flame", x + 0.5 + x1, y + 0.5 + y1, z + 0.5 + z1, 0.0f, -0.05f, 0.0f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return;
        }
    }
}
