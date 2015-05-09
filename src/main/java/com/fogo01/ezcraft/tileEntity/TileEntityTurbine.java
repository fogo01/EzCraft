package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.block.BlockTurbine;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTurbine extends TileEntity implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{};
    private static final int[] slotsSides = new int[]{0};
    private ItemStack[] turbineItemStacks = new ItemStack[1];
    public int turbineBurnTime;
    public int currentItemBurnTime;
    private String localizedName;

    public TileEntityTurbine() {

    }

    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.turbineItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.turbineItemStacks.length)
            {
                this.turbineItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.turbineBurnTime = p_145839_1_.getShort("BurnTime");
        this.currentItemBurnTime = getItemBurnTime(this.turbineItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.localizedName = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.turbineBurnTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.turbineItemStacks.length; ++i)
        {
            if (this.turbineItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.turbineItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.localizedName);
        }
    }

    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    public static int getItemBurnTime(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        } else {
            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab) {
                    return 150;
                }

                if (block.getMaterial() == Material.wood) {
                    return 300;
                }

                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemStack);
        }
    }

    public static boolean isItemFuel(ItemStack itemStack) {
        return getItemBurnTime(itemStack) > 0;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot == 0 ? isItemFuel(itemStack) : false;
    }

    @Override
    public int getSizeInventory() {
        return this.turbineItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.turbineItemStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.turbineItemStacks[p_70298_1_] != null) {
            ItemStack itemstack;

            if (this.turbineItemStacks[p_70298_1_].stackSize <= p_70298_2_) {
                itemstack = this.turbineItemStacks[p_70298_1_];
                this.turbineItemStacks[p_70298_1_] = null;
                return itemstack;
            } else {
                itemstack = this.turbineItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.turbineItemStacks[p_70298_1_].stackSize == 0) {
                    this.turbineItemStacks[p_70298_1_] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.turbineItemStacks[p_70304_1_] != null) {
            ItemStack itemstack = this.turbineItemStacks[p_70304_1_];
            this.turbineItemStacks[p_70304_1_] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.turbineItemStacks[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit()) {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "Container.Turbine";
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    public boolean isBurning() {
        return this.turbineBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }

        return this.turbineBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    private boolean canSmelt() {
        return this.worldObj.getBlock(this.xCoord, this.yCoord-1, this.zCoord) == Blocks.water;
    }

    @Override
    public void updateEntity() {
        boolean flag = this.turbineBurnTime > 0;
        boolean flag1 = false;

        if (this.turbineBurnTime > 0) {
            --this.turbineBurnTime;
            worldObj.spawnParticle("reddust", this.xCoord+0.5F, this.yCoord+1.0F, this.zCoord+0.5F, 0.0F, 1.0F, 0.0F);
        }

        if (!this.worldObj.isRemote) {
            if (this.turbineBurnTime != 0 || this.turbineItemStacks[0] != null) {
                if (this.turbineBurnTime == 0 && this.canSmelt()) {
                    this.currentItemBurnTime = this.turbineBurnTime = getItemBurnTime(this.turbineItemStacks[0]);

                    if (this.turbineBurnTime > 0) {
                        flag1 = true;

                        if (this.turbineItemStacks[0] != null) {
                            --this.turbineItemStacks[0].stackSize;

                            if (this.turbineItemStacks[0].stackSize == 0) {
                                this.turbineItemStacks[0] = turbineItemStacks[0].getItem().getContainerItem(turbineItemStacks[0]);
                            }
                        }
                    }
                }

                /*
                if (this.isBurning() && this.canSmelt())
                {
                    ++this.turbineCookTime;

                    if (this.turbineCookTime == 200)
                    {
                        this.turbineCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.turbineCookTime = 0;
                }
                */
            }

            if (flag != this.turbineBurnTime > 0) {
                flag1 = true;
                BlockTurbine.updateTurbineBlockState(this.turbineBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }
}