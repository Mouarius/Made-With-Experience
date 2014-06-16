package fr.mouarius.mwe.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import fr.mouarius.mwe.client.renderer.EssenceCrucibleRenderer;
import fr.mouarius.mwe.tileentity.EssenceCrucibleTileEntity;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderingThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(EssenceCrucibleTileEntity.class, new EssenceCrucibleRenderer());
    }
}
