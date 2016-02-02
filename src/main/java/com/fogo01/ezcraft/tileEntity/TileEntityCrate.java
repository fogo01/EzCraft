package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.init.ModItems;
import com.fogo01.ezcraft.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrate extends TileEntity implements ISidedInventory {
    private String localizedName;
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{1};
    private static final int[] slotsSides = new int[]{2, 3, 4, 5, 6};
    private ItemStack[] crateItemStacks = new ItemStack[7];
    public ItemStack currentStack = null;
    public int stackSize = 0;
    public int maxSize = 64 * 64;
    public boolean[] upgrades = new boolean[Reference.numUpggrades];

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        stackSize = nbtTagCompound.getInteger("stackSize");

        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items", 10);
        this.crateItemStacks = new ItemStack[this.getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
            if(b0 >= 0 && b0 < this.crateItemStacks.length) {
                this.crateItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        if (stackSize > 0 && crateItemStacks[1] != null)
            currentStack = new ItemStack(crateItemStacks[1].getItem(), 1);

        if(nbtTagCompound.hasKey("CustomName", 8)) {
            this.localizedName = nbtTagCompound.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("stackSize", stackSize);

        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < this.crateItemStacks.length; ++i) {
            if(this.crateItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.crateItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbtTagCompound.setTag("Items", nbttaglist);

        if(this.hasCustomInventoryName()) {
            nbtTagCompound.setString("CustomName", this.localizedName);
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int p_102007_3_) {
        return this.isItemValidForSlot(slot, itemStack);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return crateItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return crateItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.crateItemStacks[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.crateItemStacks[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.crateItemStacks[p_70298_1_];
                this.crateItemStacks[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.crateItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.crateItemStacks[p_70298_1_].stackSize == 0)
                {
                    this.crateItemStacks[p_70298_1_] = null;
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
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        crateItemStacks[slot] = itemStack;
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "Container.Crate";
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
            ItemStack item = itemStack;
            if (currentStack == null || currentStack.isItemEqual(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateEntity() {
        if (!worldObj.isRemote) {
            if (crateItemStacks[0] != null) {
                if (currentStack == null || crateItemStacks[0].isItemEqual(currentStack)) {
                    if (maxSize - stackSize >= crateItemStacks[0].stackSize) {
                        currentStack = new ItemStack(crateItemStacks[0].getItem());
                        stackSize += crateItemStacks[0].stackSize;
                        crateItemStacks[0] = null;
                    } else {
                        crateItemStacks[0].stackSize -= maxSize - stackSize;
                        stackSize += maxSize - stackSize;
                    }
                }
            }

            if (crateItemStacks[1] == null) {
                if (currentStack != null) {
                    if (stackSize <= currentStack.getMaxStackSize()) {
                        crateItemStacks[1] = new ItemStack(currentStack.getItem(), stackSize);
                        stackSize = 0;
                        currentStack = null;
                    } else {
                        crateItemStacks[1] = new ItemStack(currentStack.getItem(), currentStack.getMaxStackSize());
                        stackSize -= currentStack.getMaxStackSize();
                    }
                }
            } else if (crateItemStacks[1].stackSize < crateItemStacks[1].getMaxStackSize()) {
                if (crateItemStacks[1].getMaxStackSize() - crateItemStacks[1].stackSize <= stackSize) {
                    stackSize -= (crateItemStacks[1].getMaxStackSize() - crateItemStacks[1].stackSize);
                    crateItemStacks[1].stackSize = crateItemStacks[1].getMaxStackSize();
                } else {
                    crateItemStacks[1].stackSize += stackSize;
                    stackSize = 0;
                    currentStack = null;
                }
            }
        }

        for (int i = 0; i < upgrades.length; i++) {
            upgrades[i] = false;
            if (i == 0 || upgrades[i - 1]) {
                for (int j = 1; j < crateItemStacks.length; j++) {
                    if (crateItemStacks[j] != null && crateItemStacks[j].isItemEqual(new ItemStack(ModItems.CrateUppgrade, 1, i)))
                        upgrades[i] = true;
                }
            }
        }

        maxSize = 64 * 64;
        for (int i = 0; i < upgrades.length; i++) {
            if (upgrades[i]) {
                maxSize = 64 * 64 * (i + 2);
            }
        }

/**
        if (upgrades[0]) {
            if (stackSize > 64 * 64) {
                for (int j = 1; j < crateItemStacks.length; j++) {
                    if (crateItemStacks[j] != null && crateItemStacks[j].isItemEqual(new ItemStack(ModItems.CrateUppgrade, 1, 0)))
                        crateItemStacks[j] = null;
                }
            }
        }
*/
    }

    public int getStorageScaled(int i) {
        return this.stackSize * i / this.maxSize;
    }
}
