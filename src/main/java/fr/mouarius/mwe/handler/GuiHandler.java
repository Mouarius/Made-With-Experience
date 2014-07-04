package fr.mouarius.mwe.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import fr.mouarius.mwe.client.tileentity.TileEntityExperienceExtractor;
import fr.mouarius.mwe.reference.GuiIds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GuiIds.EXPERIENCE_EXTRACTOR){
            TileEntityExperienceExtractor experienceExtractor = (TileEntityExperienceExtractor) world.getTileEntity(x,y,z);

        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }
}
