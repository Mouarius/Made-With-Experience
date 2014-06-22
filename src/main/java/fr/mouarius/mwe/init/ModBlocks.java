package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.block.BlockEssenceOre;
import fr.mouarius.mwe.block.BlockExperienceExtractor;
import fr.mouarius.mwe.block.BlockMWE;
import fr.mouarius.mwe.reference.Names;

public class ModBlocks {
    public static BlockMWE essence_ore;
    public static BlockMWE experience_extractor;
    public static void init()
    {
        essence_ore = new BlockEssenceOre();
        experience_extractor = new BlockExperienceExtractor();

        GameRegistry.registerBlock(essence_ore, Names.Block.ESSENCE_ORE);
        GameRegistry.registerBlock(experience_extractor, Names.Block.EXPERIENCE_EXTRACTOR);
    }
}
