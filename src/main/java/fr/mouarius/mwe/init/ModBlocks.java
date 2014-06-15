package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.block.BlockEssenceOre;
import fr.mouarius.mwe.block.BlockMWE;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.reference.Textures;
import net.minecraft.block.Block;

public class ModBlocks {
    public static Block essence_ore;
    public static void init()
    {
        essence_ore = new BlockEssenceOre();
        GameRegistry.registerBlock(essence_ore, Names.Block.essence_ore);
    }
}
