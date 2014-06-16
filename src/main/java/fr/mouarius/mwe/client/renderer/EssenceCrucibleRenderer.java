package fr.mouarius.mwe.client.renderer;

import fr.mouarius.mwe.client.model.ModelEssenceCrucible;
import fr.mouarius.mwe.reference.Reference;
import fr.mouarius.mwe.reference.Textures;
import fr.mouarius.mwe.tileentity.EssenceCrucibleTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EssenceCrucibleRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, Textures.ESSENCE_CRUCIBLE);
    private ModelEssenceCrucible model;

    public EssenceCrucibleRenderer(){
        this.model = new ModelEssenceCrucible();
    }

    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }    @Override
    public void renderTileEntityAt(TileEntity entity, double dx, double dy, double dz, float scale) {
        renderEssenceCrucibleModelAt((EssenceCrucibleTileEntity)entity, dx, dy, dz, scale);

    }
    public void renderEssenceCrucibleModelAt(EssenceCrucibleTileEntity tileentity1, double d, double d1, double d2, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
        this.bindTexture(texture);
        GL11.glPushMatrix();
        model.renderModel(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
