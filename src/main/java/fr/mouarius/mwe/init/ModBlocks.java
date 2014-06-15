package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.block.BlockEssenceOre;
import fr.mouarius.mwe.block.BlockMWE;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.reference.Textures;
import net.minecraft.block.Block;

/**
 * Made With Experience
 * Minecraft mod
 *
 * @author Mouarius
 * @license GNU Lesser General Public License v2
 * (http://www.gnu.org/licenses/lgpl.html)
 * @copyright Copyright (C) 2014  Mouarius
 */
public class ModBlocks {
    public static Block essence_ore;
    public static void init()
    {
        essence_ore = new BlockEssenceOre();
        GameRegistry.registerBlock(essence_ore, Names.Block.essence_ore);
    }
}
