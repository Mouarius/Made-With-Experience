package fr.mouarius.mwe.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.item.ItemMWE;
import fr.mouarius.mwe.reference.Names;
import net.minecraft.item.Item;

public class ModItems {

    public static Item experience_essence = new ItemMWE().setUnlocalizedName(Names.Item.experience_essence);

    public static void init(){

        GameRegistry.registerItem(experience_essence, Names.Item.experience_essence);
    }

}
