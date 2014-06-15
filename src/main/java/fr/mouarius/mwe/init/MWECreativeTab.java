package fr.mouarius.mwe.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MWECreativeTab extends CreativeTabs {
    public MWECreativeTab(String lable) {
        super(lable);
    }
    @Override
    public Item getTabIconItem() {
        return ModItems.experience_essence;
    }
}
