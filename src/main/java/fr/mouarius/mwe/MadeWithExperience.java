package fr.mouarius.mwe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.mouarius.mwe.init.MWECreativeTab;
import fr.mouarius.mwe.init.ModBlocks;
import fr.mouarius.mwe.init.ModItems;
import fr.mouarius.mwe.proxy.CommonProxy;
import fr.mouarius.mwe.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Made With Experience
 * Minecraft mod
 *
 * @author Mouarius
 * @license GNU General Public License v3
 *          (http://www.gnu.org/licenses/gpl.html)
 * @copyright Copyright (C) 2014  Mouarius
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MadeWithExperience {

    @Mod.Instance
    
    public static CreativeTabs madeWithExperienceTab = new MWECreativeTab("made_with_experience");


    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOCATION, serverSide = Reference.SERVER_PROXY_LOCATION)
    public static CommonProxy proxy;

    @Mod.Instance(Reference.MOD_ID)
    MadeWithExperience mwe;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ModItems.init();
        ModBlocks.init();
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        proxy.registerTileEntities();
        proxy.registerRenderingThings();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){

    }
}
