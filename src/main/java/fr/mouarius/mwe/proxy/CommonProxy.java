package fr.mouarius.mwe.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mouarius.mwe.client.tileentity.TileEntityExperienceExtractor;
import fr.mouarius.mwe.reference.Names;

public abstract class CommonProxy implements IProxy{

    @Override
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityExperienceExtractor.class, "tile." + Names.Block.EXPERIENCE_EXTRACTOR);
    }
}
