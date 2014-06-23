package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.block.BlockEssenceOre;
import fr.mouarius.mwe.block.BlockExperienceExtractor;
import fr.mouarius.mwe.block.BlockMWE;
import fr.mouarius.mwe.reference.Names;
import net.minecraft.block.BlockContainer;

public class ModBlocks {
    public static BlockMWE essence_ore;
    public static BlockContainer experience_extractor_off;
    public static BlockContainer experience_extractor_on;

    public static void init()
    {
        essence_ore = new BlockEssenceOre();
        experience_extractor_off = new BlockExperienceExtractor(false);
        experience_extractor_on = new BlockExperienceExtractor(true);

        GameRegistry.registerBlock(essence_ore, Names.Block.ESSENCE_ORE);
        GameRegistry.registerBlock(experience_extractor_off, Names.Block.EXPERIENCE_EXTRACTOR_OFF);
        GameRegistry.registerBlock(experience_extractor_on, Names.Block.EXPERIENCE_EXTRACTOR_ON);

    }
}
