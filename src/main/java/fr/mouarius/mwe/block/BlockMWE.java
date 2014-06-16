package fr.mouarius.mwe.block;

        import cpw.mods.fml.relauncher.Side;
        import cpw.mods.fml.relauncher.SideOnly;
        import fr.mouarius.mwe.MadeWithExperience;
        import fr.mouarius.mwe.reference.Textures;
        import net.minecraft.block.Block;
        import net.minecraft.block.material.Material;
        import net.minecraft.client.renderer.texture.IIconRegister;


public class BlockMWE extends Block {


    protected BlockMWE() {
        super(Material.rock);
        this.setCreativeTab(MadeWithExperience.madeWithExperienceTab);
    }
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESSOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
