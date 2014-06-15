package fr.mouarius.mwe.client.particle;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

/**
 * Made With Experience
 * Minecraft mod
 *
 * @author Mouarius
 * @license GNU Lesser General Public License v2
 * (http://www.gnu.org/licenses/lgpl.html)
 * @copyright Copyright (C) 2014  Mouarius
 */
@SideOnly(Side.CLIENT)
public class EntityXPDustFX extends EntityFX {
    float XPDustParticleScale;

    @SideOnly(Side.CLIENT)
    public static void spawnXPDust(World world, double x, double y, double z){
        EntityXPDustFX fx = new EntityXPDustFX(Minecraft.getMinecraft().theWorld,x,y,z,0.0F,0.0F,0.0F);
        FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX) fx);
    }
    public EntityXPDustFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10)
    {
        this(par1World, par2, par4, par6, 1.0F, par8, par9, par10);
    }

    public EntityXPDustFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, float par11)
    {

        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;

        if (par9 == 0.0F)
        {
            par9 = 1.0F;
        }
        float red = 184.0F/255.0F;
        float green = 250.0F/255.0F;
        float blue = 56.0F/255.0F;
        float f4 = (float)Math.random() * 0.4F + 0.6F;
        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
        this.particleScale *= 0.75F;
        this.particleScale *= par8;
        this.XPDustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * par8);
        this.noClip = false;
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        float f6 = ((float)this.particleAge + par2) / (float)this.particleMaxAge * 32.0F;

        if (f6 < 0.0F)
        {
            f6 = 0.0F;
        }

        if (f6 > 1.0F)
        {
            f6 = 1.0F;
        }

        this.particleScale = this.XPDustParticleScale * f6;
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}
