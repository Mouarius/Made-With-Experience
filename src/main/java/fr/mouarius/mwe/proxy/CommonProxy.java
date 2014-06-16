package fr.mouarius.mwe.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.tileentity.EssenceCrucibleTileEntity;

public class CommonProxy{
    public void registerTileEntities(){
        GameRegistry.registerTileEntity(EssenceCrucibleTileEntity.class, "tile." + Names.Block.ESSENCE_CRUCIBLE);
    }
    public void registerRenderingThings(){

    }
}
