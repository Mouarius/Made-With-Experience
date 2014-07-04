package fr.mouarius.mwe;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.mouarius.mwe.handler.ConfigurationHandler;
import fr.mouarius.mwe.init.MWECreativeTab;
import fr.mouarius.mwe.init.ModBlocks;
import fr.mouarius.mwe.init.ModItems;
import fr.mouarius.mwe.proxy.IProxy;
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

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_LOCATION)
public class MadeWithExperience {

    @Mod.Instance(Reference.MOD_ID)
    public static MadeWithExperience instance;
    
    public static CreativeTabs madeWithExperienceTab = new MWECreativeTab("made_with_experience");


    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOCATION, serverSide = Reference.SERVER_PROXY_LOCATION)
    public static IProxy proxy;


    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        proxy.registerTileEntities();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){

    }
}
