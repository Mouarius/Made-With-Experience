package fr.mouarius.mwe.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mouarius.mwe.client.tileentity.TileEntityExperienceExtractor;
import fr.mouarius.mwe.init.ModBlocks;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockExperienceExtractor extends BlockContainer {

    private final boolean isActive;
    private static boolean keepFurnaceInv;
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    private final Random random = new Random();

    public BlockExperienceExtractor(boolean isActive) {
        super(Material.rock);
        this.isActive = isActive;
        this.setBlockName(Names.Block.EXPERIENCE_EXTRACTOR_OFF);
    }

    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityExperienceExtractor();
    }

    public Item getItemDropped(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.experience_extractor_off);
    }

    @SideOnly(Side.CLIENT)
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.direction(world, x, y, z);
    }
    private void direction(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block direction = world.getBlock(x, y, z - 1);
            Block direction1 = world.getBlock(x, y, z + 1);
            Block direction2 = world.getBlock(x - 1, y, z);
            Block direction3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (direction.func_149730_j() && !direction1.func_149730_j())
            {
                b0 = 3;
            }

            if (direction1.func_149730_j() && !direction.func_149730_j())
            {
                b0 = 2;
            }

            if (direction2.func_149730_j() && !direction3.func_149730_j())
            {
                b0 = 5;
            }
            if (direction3.func_149730_j() && !direction2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }



    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemStack.hasDisplayName())
        {
            ((TileEntityExperienceExtractor)world.getTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
        }
    }


    public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
        int direction = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        keepFurnaceInv = true;

        if (burning) {
            world.setBlock(x, y, z, ModBlocks.experience_extractor_on);
        } else {
            world.setBlock(x, y, z, ModBlocks.experience_extractor_off);
        }

        keepFurnaceInv = false;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);

        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!keepFurnaceInv) {
            TileEntityExperienceExtractor tileEntityExperienceExtractor = (TileEntityExperienceExtractor) world.getTileEntity(x, y, z);

            if (tileEntityExperienceExtractor != null) {
                for (int i = 0; i < tileEntityExperienceExtractor.getSizeInventory(); ++i) {
                    ItemStack itemstack = tileEntityExperienceExtractor.getStackInSlot(i);

                    if (itemstack != null) {
                        float f = this.random.nextFloat() * 0.6F + 0.1F;
                        float f1 = this.random.nextFloat() * 0.6F + 0.1F;
                        float f2 = this.random.nextFloat() * 0.6F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j = this.random.nextInt(21) + 10;

                            if (j > itemstack.stackSize) {
                                j = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j;
                            EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
                            }

                            float f3 = 0.025F;
                            entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                            entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
                            entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
//        return side == 1 ? top : (side == 3 ? front : this.blockIcon);
        return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.front));

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Textures.EXPERIENCE_EXTRACTOR_SIDE);
        this.top = iconRegister.registerIcon(Textures.EXPERIENCE_EXTRACTOR_TOP);

        if (isActive){
            this.front = iconRegister.registerIcon(Textures.EXPERIENCE_EXTRACTOR_FRONT_ON);
        }else{
            this.front = iconRegister.registerIcon(Textures.EXPERIENCE_EXTRACTOR_FRONT_OFF);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESSOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(Blocks.furnace);
    }


}
