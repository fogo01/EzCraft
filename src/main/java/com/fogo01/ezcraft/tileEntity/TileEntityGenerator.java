package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.block.BlockTurbine;
import com.fogo01.ezcraft.block.BlockWoddenShaft;
import com.fogo01.ezcraft.init.ModBlocks;
import com.fogo01.ezcraft.reference.Reference;
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
    private int maxEnergy = 30720;
    public int itemEnergyAmount = 1;
    private int maxItemEnergy = 1;
    public int rpm;
    public int torque;
    private String localizedName;
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
        this.itemEnergyAmount = tagCompound.getInteger("itemEnergyAmount");
        this.maxItemEnergy = tagCompound.getInteger("maxItemEnergy");

        if (tagCompound.hasKey("CustomName", 8)) {
            this.localizedName = tagCompound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("energyAmount", this.energyAmount);
        tagCompound.setInteger("itemEnergyAmount", this.itemEnergyAmount);
        tagCompound.setInteger("maxItemEnergy", this.maxItemEnergy);

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
        return rpm >= 100;
    }

    public boolean canCharge(ItemStack itemStack) {
        return this.energyAmount > 0 && isItemChargeable(itemStack);
    }

    public boolean isItemChargeable(ItemStack itemStack) {
        if (itemStack != null) {
            for (int i = 0; i < Reference.chargeable.length; i++) {
                ItemStack item = Reference.chargeable[i];
                item.setItemDamage(itemStack.getItemDamage());
                if (itemStack.isItemEqual(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateEntity() {
        boolean flag1 = false;

        this.rpm = 0;
        this.torque = 0;
        int x = xCoord, y = yCoord - 1, z = zCoord;
        while (worldObj.getBlock(x, y ,z) == ModBlocks.WoddenShaft) {
            y--;
        }

        if (worldObj.getBlock(x, y ,z) == ModBlocks.Turbine) {
            if (worldObj.getTileEntity(x, y, z) instanceof TileEntityTurbine) {
                TileEntityTurbine turbine = (TileEntityTurbine)worldObj.getTileEntity(x, y, z);
                this.rpm = turbine.rpm;
                this.torque = turbine.torque;
            }
        }

        if (!this.worldObj.isRemote) {
            if (rpm >= 100) {
                if (energyAmount < maxEnergy - rpm / 100) {
                    this.energyAmount += rpm / 100;
                    flag1 = true;
                }
            }

            this.itemEnergyAmount = 1;
            this.maxItemEnergy = 2;
            if (this.generatorItemStacks[0] != null) {
                if (canCharge(this.generatorItemStacks[0])) {
                    if (this.energyAmount > 0) {
                        int itemDmg = this.generatorItemStacks[0].getItemDamage();
                        if (itemDmg > 0) {
                            this.generatorItemStacks[0].setItemDamage(itemDmg - 1);
                            this.energyAmount -= 1;
                        }

                        this.itemEnergyAmount = this.generatorItemStacks[0].getItemDamage();
                        this.maxItemEnergy = this.generatorItemStacks[0].getMaxDamage();

                        flag1 = true;
                    }
                }
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getEnergyAmountScaled(int i) {
        return this.energyAmount * i / this.maxEnergy;
    }

    public int getItemEnergyAmountScaled(int i) {
        return this.itemEnergyAmount * i / this.maxItemEnergy;
    }
}
