package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.reference.ReferenceWormHole;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemScanner extends ItemEzCraft {
    int range = Reference.scannerRadius;
    int radius = ReferenceWormHole.radius;
    float dmgRadius = ReferenceWormHole.dmgRadius;

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

            if (player.getHeldItem() != null && player.getHeldItem().isItemEqual(new ItemStack(ModItems.Scanner))) {
               scan(player);
            }
        }
    }

    private void scan(EntityPlayer player) {
        World world = player.worldObj;
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
                                        if (Math.random() < 0.1)
                                            world.spawnParticle("crit", x + 0.5 + x1, y + 0.5 + y1, z + 0.5 + z1, 0.0f, 0.0f, 0.0f);
                                }
                            }
                        }
                        for (float x1 = -(dmgRadius + 0.5f); x1 <= dmgRadius + 0.5f; x1++) {
                            for (float y1 = -(dmgRadius + 0.5f); y1 <= dmgRadius + 0.5f; y1++) {
                                for (float z1 = -(dmgRadius + 0.5f); z1 <= dmgRadius + 0.5f; z1++) {
                                    if (Math.random() < 0.1)
                                        world.spawnParticle("reddust", x + 0.5 + x1, y + 0.5 + y1, z + 0.5 + z1, 0.0f, 0.0f, 0.0f);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
