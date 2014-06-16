package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.item.ItemExperienceEssence;
import fr.mouarius.mwe.item.ItemMWE;
import fr.mouarius.mwe.reference.Names;

public class ModItems {

    public static ItemMWE experience_essence = new ItemExperienceEssence();

    public static void init(){

        GameRegistry.registerItem(experience_essence, Names.Item.EXPERIENCE_ESSENCE);
    }

}
