package com.fogo01.ezcraft.tileEntity;

import com.fogo01.ezcraft.block.BlockBlastfurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlastFurnace extends TileEntity implements ISidedInventory {
    private String localizedName;

    private static final int[] slots_top = new int[]{0, 1};
    private static final int[] slots_bottom = new int[]{3, 2};
    private static final int[] slots_side = new int[]{2};

    private ItemStack[] slots = new ItemStack[4];

    public int furnaceSpeed = 150;
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;

    public void setGuiDisplayName(String displayName) {
        this.localizedName = displayName;
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "Container.BlastFurnace";
    }

    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord+ 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return i == 3 ? false : (i == 2 ? isItemFuel(itemStack) : true);
    }

    private static boolean isItemFuel (ItemStack itemStack) {
        return getItemBurntime(itemStack) > 0;
    }

    private static int getItemBurntime(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }else{
            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if(block == Blocks.sapling) return 100;
                if(block == Blocks.coal_block) return 16000;
            }

            if(item == Items.coal) return 1600;
            if(item == Items.stick) return 100;
            if(item == Items.lava_bucket) return 20000;
            if(item == Items.blaze_rod) return 2400;
        }

        return GameRegistry.getFuelValue(itemStack);
    }

    public int getSizeInventory () {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.slots[var1];
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if (this.slots[var1] != null) {
            ItemStack itemStack;
            if (this.slots[var1].stackSize <= var2) {
                itemStack  = this.slots[var1];
                this.slots[var1] = null;
                return itemStack;
            }else{
                itemStack = slots[var1].splitStack(var2);
                if (this.slots[var1].stackSize == 0) {
                    this.slots[var1] = null;
                }
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.slots[i] != null) {
            ItemStack itemStack = this.slots[i];
            this.slots[i] = null;
            return itemStack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.slots[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @Override
    public void updateEntity() {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

        if (this.isBurning()) {
            this.burnTime--;
        }
        if (!this.worldObj.isRemote) {
            if (this.burnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.burnTime = getItemBurntime(this.slots[2]);
                if (this.isBurning()) {
                    flag1 = true;
                    if (this.slots[2] != null) {
                        this.slots[2].stackSize--;
                        if (this.slots[2].stackSize == 0) {
                            this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt()) {
                this.burnTime++;
                if (this.cookTime == this.furnaceSpeed) {
                    this.cookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            }else{
                this.cookTime = 0;
            }
            if (flag != this.isBurning()) {
                flag1 = true;
                BlockBlastfurnace.updateBlastfurnaceBlockState(this.burnTime > 0, this.worldObj, this.xCoord, yCoord, zCoord);
            }
        }
        if (flag1) {
            this.markDirty();
        }
    }

    public boolean canSmelt() {
        if (this.slots[0] == null || this.slots[1] == null) {
            return false;
        } else {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
            ItemStack itemStack1 = FurnaceRecipes.smelting().getSmeltingResult(this.slots[1]);

            if (itemStack == null) return false;
            if (this.slots[3] == null) return true;
            if (this.slots[3].isItemEqual(itemStack)) return false;

            int result = this.slots[3].stackSize + itemStack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemStack.getMaxStackSize());

        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
            ItemStack itemStack1 = FurnaceRecipes.smelting().getSmeltingResult(this.slots[1]);

            if (this.slots[3] == null) {
                this.slots[3] = itemStack.copy();
            } else if (this.slots[3].isItemEqual(itemStack)) {
                this.slots[3].stackSize += itemStack.stackSize;
            }

            this.slots[0].stackSize--;
            this.slots[1].stackSize--;

            if (this.slots[0].stackSize <= 0) {
                this.slots[0] = null;
            }
            if (this.slots[1].stackSize <= 0) {
                this.slots[1] = null;
            }
        }
    }


    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int j) {
        return this.isItemValidForSlot(i, itemStack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int j) {
        return j !=0 || i != 1 || i != 2 || itemStack.getItem() == Items.bucket;
    }
}
