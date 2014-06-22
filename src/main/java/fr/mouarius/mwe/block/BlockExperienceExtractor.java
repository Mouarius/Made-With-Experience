package fr.mouarius.mwe.block;

import fr.mouarius.mwe.MadeWithExperience;
import fr.mouarius.mwe.client.tileentity.ExperienceExtractorTileEntity;
import fr.mouarius.mwe.reference.Names;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockExperienceExtractor extends BlockContainer {


    protected BlockExperienceExtractor() {
        super(Material.rock);
        this.setBlockName(Names.Block.EXPERIENCE_EXTRACTOR)
                .setCreativeTab(MadeWithExperience.madeWithExperienceTab);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new ExperienceExtractorTileEntity();
    }
}
