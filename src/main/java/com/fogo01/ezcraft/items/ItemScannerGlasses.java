package com.fogo01.ezcraft.items;

import com.fogo01.ezcraft.crativetab.CreativeTabEzCraft;
import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import com.fogo01.ezcraft.reference.ReferenceWormHole;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemScannerGlasses extends ItemArmor{
    int range = Reference.scannerRadius;
    int radius = ReferenceWormHole.radius;
    float dmgRadius = ReferenceWormHole.dmgRadius;

    public ItemScannerGlasses() {
        super(ArmorMaterial.CLOTH, 0, 0);
        this.setTextureName(Reference.MOD_ID + ":ScannerGlasses");
        this.setCreativeTab(CreativeTabEzCraft.EzCraft_TAB);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(3).getItem() == ModItems.ScannerGlasses){
            scan(player);
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

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/models/armor/utility_layer2.png";
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "ScannerGlasses");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", "ScannerGlasses");
    }
}
