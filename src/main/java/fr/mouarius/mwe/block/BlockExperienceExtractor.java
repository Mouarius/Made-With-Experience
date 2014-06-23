package fr.mouarius.mwe.block;

import fr.mouarius.mwe.MadeWithExperience;
import fr.mouarius.mwe.client.tileentity.ExperienceExtractorTileEntity;
import fr.mouarius.mwe.init.ModBlocks;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.reference.Textures;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockExperienceExtractor extends BlockContainer {

    private boolean isActive;

    public BlockExperienceExtractor(boolean isActive) {
        super(Material.rock);
        this.isActive = isActive;
        this.setBlockName(Names.Block.EXPERIENCE_EXTRACTOR_OFF)
                .setCreativeTab(MadeWithExperience.madeWithExperienceTab);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new ExperienceExtractorTileEntity();
    }

    public Item getItemDropped(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.experience_extractor_off);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if(world.isRemote){
            return true;
        }
        else{
//            ExperienceExtractorTileEntity tileEntity = (ExperienceExtractorTileEntity)world.getTileEntity(x,y,z);
//            if (tileEntity != null)
//            {
//                player.openGui(MadeWithExperience.instance, 1, world, x, y, z);
//            }
            player.addChatComponentMessage(new ChatComponentText("Essai"));
            return true;
        }
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESSOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


}
