package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.item.ItemMWE;
import fr.mouarius.mwe.reference.Names;
import net.minecraft.item.Item;

/**
 * Made With Experience
 * Minecraft mod
 *
 * @author Mouarius
 * @license GNU Lesser General Public License v2
 * (http://www.gnu.org/licenses/lgpl.html)
 * @copyright Copyright (C) 2014  Mouarius
 */
public class ModItems {

    public static Item experience_essence = new ItemMWE().setUnlocalizedName(Names.Item.experience_essence);

    public static void init(){

        GameRegistry.registerItem(experience_essence, Names.Item.experience_essence);
    }

}
