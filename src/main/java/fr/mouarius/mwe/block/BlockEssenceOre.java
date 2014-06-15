package fr.mouarius.mwe.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mouarius.mwe.MadeWithExperience;
import fr.mouarius.mwe.client.DamageAskExperience;
import fr.mouarius.mwe.client.particle.EntityXPDustFX;
import fr.mouarius.mwe.helper.RegisterHelper;
import fr.mouarius.mwe.init.ModBlocks;
import fr.mouarius.mwe.init.ModItems;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;


public class BlockEssenceOre extends BlockMWE{

    public BlockEssenceOre()
    {
        this.setHardness(10.0F);
        this.setHarvestLevel("pickaxe", 3);
        this.setBlockName(Names.Block.essence_ore);
        this.setTickRandomly(true);
    }

    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
        return 20 + rand.nextInt(50);
    }
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return ModItems.experience_essence;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p6, float p7, float p8, float p9)
    {
        player.addExperience(20);
        player.attackEntityFrom(DamageAskExperience.damageAskExperience, 2.0F);
        return true;
    }

    @SideOnly(Side.CLIENT)
public void randomDisplayTick(World world, int x, int y, int z, Random random)
{

    double d0 = 0.0625D;

    for (int l = 0; l < 6; ++l)
    {
        double d1 = (double) ((float) x + random.nextFloat());
        double d2 = (double) ((float) y + random.nextFloat());
        double d3 = (double) ((float) z + random.nextFloat());

        if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube())
        {
            d2 = (double) (y + 1) + d0;
        }

        if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube())
        {
            d2 = (double) (y + 0) - d0;
        }

        if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube())
        {
            d3 = (double) (z + 1) + d0;
        }

        if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube())
        {
            d3 = (double) (z + 0) - d0;
        }

        if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube())
        {
            d1 = (double) (x + 1) + d0;
        }

        if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube())
        {
            d1 = (double) (x + 0) - d0;
        }

        if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1))
        {
            EntityXPDustFX.spawnXPDust(world, d1, d2, d3);
        }
    }
}
}