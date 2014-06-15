package fr.mouarius.mwe.item;

import fr.mouarius.mwe.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemExperienceEssence extends ItemMWE{
    public ItemExperienceEssence(){
        this.setUnlocalizedName(Names.Item.experience_essence);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if(player.capabilities.isCreativeMode == false){
            player.addExperience(20);
            --itemStack.stackSize;
        }
        return itemStack;
    }
}
