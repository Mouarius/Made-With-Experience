package fr.mouarius.mwe.client.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityExperienceExtractor extends TileEntity implements ISidedInventory {
    private ItemStack[] extractorItemStacks = new ItemStack[3];
    private String extractorName;
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};

    public int extractorBurnTime;
    public int extractorExtractTime;

    public int currentItemBurnTime;


    public int getSizeInventory()
    {
        return extractorItemStacks.length;
    }

    public ItemStack getStackInSlot(int slot)
    {
        return this.extractorItemStacks[slot];
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return false;
    }

    public ItemStack decrStackSize(int slot, int amount){
        if(this.extractorItemStacks[slot] != null){
            ItemStack itemStack;

            if(this.extractorItemStacks[slot].stackSize <= amount){
                itemStack = this.extractorItemStacks[slot];
                this.extractorItemStacks = null;
                return itemStack;
            }
            else
            {
                itemStack = this.extractorItemStacks[slot].splitStack(amount);

                if (this.extractorItemStacks[slot].stackSize == 0)
                {
                    this.extractorItemStacks[slot] = null;
                }

                return itemStack;
            }
        }
        else{
            return null;
        }
    }
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.extractorItemStacks[slot] != null)
        {
            ItemStack itemstack = this.extractorItemStacks[slot];
            this.extractorItemStacks[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.extractorItemStacks[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    public String getInvName()
    {
        return this.hasCustomInventoryName() ? this.extractorName : "container.furnace";
    }

    public boolean hasCustomInventoryName()
    {
        return this.extractorName != null && this.extractorName.length() > 0;
    }

    public void setGuiDisplayName(String par1Str)
    {
        this.extractorName = par1Str;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.extractorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.extractorItemStacks.length)
            {
                this.extractorItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.extractorBurnTime = p_145839_1_.getShort("BurnTime");
        this.extractorExtractTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.extractorItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.extractorName = p_145839_1_.getString("CustomName");
        }
    }
    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.extractorBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.extractorExtractTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.extractorItemStacks.length; ++i)
        {
            if (this.extractorItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.extractorItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.extractorName);
        }
    }
    @SideOnly(Side.CLIENT)
    public int gerExtractProgressScale(int p_145953_1_)
    {
        return this.extractorExtractTime * p_145953_1_ / 200;
    }
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.extractorBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }
    public boolean isExtracting()
    {
        return this.extractorExtractTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.extractorBurnTime > 0;
        boolean flag1 = false;

        if (this.extractorBurnTime > 0)
        {
            --this.extractorBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.extractorBurnTime == 0 && this.canExtract())
            {
                this.currentItemBurnTime = this.extractorBurnTime = getItemBurnTime(this.extractorItemStacks[1]);

                if (this.extractorBurnTime > 0)
                {
                    flag1 = true;

                    if (this.extractorItemStacks[1] != null)
                    {
                        --this.extractorItemStacks[1].stackSize;

                        if (this.extractorItemStacks[1].stackSize == 0)
                        {
                            this.extractorItemStacks[1] = extractorItemStacks[1].getItem().getContainerItem(extractorItemStacks[1]);
                        }
                    }
                }
            }

            if (this.isExtracting() && this.canExtract())
            {
                ++this.extractorExtractTime;

                if (this.extractorExtractTime == 200)
                {
                    this.extractorExtractTime = 0;
                    this.extractItem();
                    flag1 = true;
                }
            }
            else
            {
                this.extractorExtractTime = 0;
            }

            if (flag != this.extractorBurnTime > 0)
            {
                flag1 = true;
                BlockFurnace.updateFurnaceBlockState(this.extractorBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }
    private boolean canExtract()
    {
        if (this.extractorItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.extractorItemStacks[0]);
            if (itemstack == null) return false;
            if (this.extractorItemStacks[2] == null) return true;
            if (!this.extractorItemStacks[2].isItemEqual(itemstack)) return false;
            int result = extractorItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.extractorItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    public void extractItem()
    {
        if (this.canExtract())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.extractorItemStacks[0]);

            if (this.extractorItemStacks[2] == null)
            {
                this.extractorItemStacks[2] = itemstack.copy();
            }
            else if (this.extractorItemStacks[2].getItem() == itemstack.getItem())
            {
                this.extractorItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.extractorItemStacks[0].stackSize;

            if (this.extractorItemStacks[0].stackSize <= 0)
            {
                this.extractorItemStacks[0] = null;
            }
        }
    }
    public static int getItemBurnTime(ItemStack itemStack)
    {
        if (itemStack == null)
        {
            return 0;
        }
        else
        {
            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemStack);
        }
    }

    public static boolean isItemFuel(ItemStack itemStack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(itemStack) > 0;
    }



    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        return this.isItemValidForSlot(slot, itemStack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return side != 0 || slot != 1 || itemStack.getItem() == Items.bucket;
    }
}
