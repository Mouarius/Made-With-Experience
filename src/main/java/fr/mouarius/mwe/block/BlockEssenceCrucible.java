package fr.mouarius.mwe.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.tileentity.EssenceCrucibleTileEntity;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEssenceCrucible extends BlockMWE {

    public BlockEssenceCrucible(){
        this.setBlockName(Names.Block.ESSENCE_CRUCIBLE);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        return new EssenceCrucibleTileEntity();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    }
}
