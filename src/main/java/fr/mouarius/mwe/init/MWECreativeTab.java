package fr.mouarius.mwe.init;

import net.minecraft.creativetab.CreativeTabs;
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
public class MWECreativeTab extends CreativeTabs {
    public MWECreativeTab(String lable) {
        super(lable);
    }
    @Override
    public Item getTabIconItem() {
        return ModItems.experience_essence;
    }
}
