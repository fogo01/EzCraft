package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGenerator extends TileEntity implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{0};
    private static final int[] slotsSides = new int[]{1};
    private ItemStack[] generatorItemStacks = new ItemStack[2];
    public int energyAmount;
    private int maxEnergy = 1000000;
    public int steamAmount;
    private int maxSteam = 8000;
    private int steamUsage = 4;
    private String localizedName;
    private TileEntity tileEntity;
    private TileEntityTurbine tileEntityTurbine;
    private int energyProduction = 80;

    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.generatorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.generatorItemStacks.length) {
                this.generatorItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.energyAmount = tagCompound.getInteger("energyAmount");
        this.steamAmount = tagCompound.getInteger("steamAmount");

        if (tagCompound.hasKey("CustomName", 8)) {
            this.localizedName = tagCompound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("energyAmount", this.energyAmount);
        tagCompound.setInteger("steamAmount", this.steamAmount);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.generatorItemStacks.length; ++i) {
            if (this.generatorItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.generatorItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        tagCompound.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName()) {
            tagCompound.setString("CustomName", this.localizedName);
        }
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
        return true;
    }

    @Override
    public int getSizeInventory() {
        return this.generatorItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.generatorItemStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.generatorItemStacks[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.generatorItemStacks[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.generatorItemStacks[p_70298_1_];
                this.generatorItemStacks[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.generatorItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.generatorItemStacks[p_70298_1_].stackSize == 0)
                {
                    this.generatorItemStacks[p_70298_1_] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.generatorItemStacks[p_70304_1_] != null)
        {
            ItemStack itemstack = this.generatorItemStacks[p_70304_1_];
            this.generatorItemStacks[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.generatorItemStacks[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "Container.Generator";
    }

    @Override
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

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        if (slot == 0) {
            return isItemChargeable(itemStack);
        }
        return true;
    }

    public boolean isGenerating() {
        return this.steamAmount > 0;
    }

    public boolean canCharge(ItemStack itemStack) {
        if (this.energyAmount > 0 && this.generatorItemStacks[1] != null && isItemChargeable(itemStack)) {
            return true;
        }
        return false;
    }

    public boolean isItemChargeable(ItemStack itemStack) {
        if (itemStack != null) {
            if (itemStack.isItemDamaged()) {
                if (itemStack == new ItemStack(ModItems.Railgun) || itemStack == new ItemStack(ModItems.EnderPearlLuancher)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateEntity() {
        boolean flag = this.isGenerating();
        boolean flag1 = false;
        this.tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);

        if (!this.worldObj.isRemote) {
            if (this.tileEntity instanceof TileEntityTurbine) {
                this.tileEntityTurbine = (TileEntityTurbine) this.tileEntity;

                if (this.tileEntityTurbine.isBurning() && this.steamAmount < this.maxSteam - this.tileEntityTurbine.steamGen) {
                    this.steamAmount += this.tileEntityTurbine.steamGen;
                }
            }

            if (this.steamAmount > 0) {
                this.steamAmount -= steamUsage;
                if (energyAmount < maxEnergy) {
                    this.energyAmount += this.energyProduction;
                }
            }

            if (this.generatorItemStacks[0] != null) {
                int itemDmg = this.generatorItemStacks[0].getItemDamage();
                this.generatorItemStacks[0].setItemDamage(itemDmg - 1);
                this.energyAmount -= 1;
            }

            if (this.canCharge(this.generatorItemStacks[0])) {
                int itemDmg = this.generatorItemStacks[0].getItemDamage();
                //this.generatorItemStacks[0].setItemDamage(itemDmg - 1);
                this.energyAmount -= 1;
            }

            if (this.steamAmount > 0) {
                flag1 = true;
            }

            if (flag != this.steamAmount > 0) {
                flag1 = true;
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getEnergyAmountScaled(int i) {
        return this.energyAmount * i / this.maxEnergy;
    }

    public int getSteamAmountScaled(int i) {
        return this.steamAmount * i / this.maxSteam;
    }
}
