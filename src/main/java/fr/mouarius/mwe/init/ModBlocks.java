package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.block.BlockEssenceOre;
import fr.mouarius.mwe.block.BlockMWE;
import fr.mouarius.mwe.reference.Names;

public class ModBlocks {
    public static BlockMWE essence_ore;
    public static BlockMWE essence_crucible;
    public static void init()
    {
        essence_ore = new BlockEssenceOre();

        GameRegistry.registerBlock(essence_ore, Names.Block.ESSENCE_ORE);
    }
}
