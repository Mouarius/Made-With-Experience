package fr.mouarius.mwe.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mouarius.mwe.MadeWithExperience;
import fr.mouarius.mwe.helper.RegisterHelper;
import fr.mouarius.mwe.reference.Names;
import fr.mouarius.mwe.reference.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.omg.CosNaming.NameHelper;

public class ItemMWE extends Item {

    public ItemMWE(){
        super();
        this.setCreativeTab(MadeWithExperience.madeWithExperienceTab);
    }
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }

}
