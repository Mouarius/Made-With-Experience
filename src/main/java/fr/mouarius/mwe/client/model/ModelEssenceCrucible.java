// Date: 01/06/2014 21:15:36
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package fr.mouarius.mwe.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEssenceCrucible extends ModelBase
{
  //fields
    ModelRenderer Fond;
    ModelRenderer Pied_1;
    ModelRenderer Pied_2;
    ModelRenderer Pied_3;
    ModelRenderer Pied_4;
    ModelRenderer Front;
    ModelRenderer Back;
    ModelRenderer Left;
    ModelRenderer Right;
  
  public ModelEssenceCrucible()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Fond = new ModelRenderer(this, 0, 0);
      Fond.addBox(0F, 0F, 0F, 16, 1, 16);
      Fond.setRotationPoint(-8F, 20F, -8F);
      Fond.setTextureSize(64, 64);
      Fond.mirror = true;
      setRotation(Fond, 0F, 0F, 0F);
      Pied_1 = new ModelRenderer(this, 0, 16);
      Pied_1.addBox(0F, 0F, 0F, 1, 3, 1);
      Pied_1.setRotationPoint(7F, 21F, -8F);
      Pied_1.setTextureSize(64, 64);
      Pied_1.mirror = true;
      setRotation(Pied_1, 0F, 0F, 0F);
      Pied_2 = new ModelRenderer(this, 0, 16);
      Pied_2.addBox(0F, 0F, 0F, 1, 3, 1);
      Pied_2.setRotationPoint(7F, 21F, 7F);
      Pied_2.setTextureSize(64, 64);
      Pied_2.mirror = true;
      setRotation(Pied_2, 0F, 0F, 0F);
      Pied_3 = new ModelRenderer(this, 0, 16);
      Pied_3.addBox(0F, 0F, 0F, 1, 3, 1);
      Pied_3.setRotationPoint(-8F, 21F, 7F);
      Pied_3.setTextureSize(64, 64);
      Pied_3.mirror = true;
      setRotation(Pied_3, 0F, 0F, 0F);
      Pied_4 = new ModelRenderer(this, 0, 16);
      Pied_4.addBox(0F, 0F, 0F, 1, 3, 1);
      Pied_4.setRotationPoint(-8F, 21F, -8F);
      Pied_4.setTextureSize(64, 64);
      Pied_4.mirror = true;
      setRotation(Pied_4, 0F, 0F, 0F);
      Front = new ModelRenderer(this, 0, 50);
      Front.addBox(0F, 0F, 0F, 16, 13, 1);
      Front.setRotationPoint(-8F, 8F, -8F);
      Front.setTextureSize(64, 64);
      Front.mirror = true;
      setRotation(Front, 0F, 0F, 0F);
      Back = new ModelRenderer(this, 0, 50);
      Back.addBox(0F, 0F, 0F, 16, 13, 1);
      Back.setRotationPoint(-8F, 8F, 7F);
      Back.setTextureSize(64, 64);
      Back.mirror = true;
      setRotation(Back, 0F, 0F, 0F);
      Left = new ModelRenderer(this, 0, 35);
      Left.addBox(0F, 0F, 0F, 1, 12, 16);
      Left.setRotationPoint(7F, 8F, -8F);
      Left.setTextureSize(64, 64);
      Left.mirror = true;
      setRotation(Left, 0F, 0F, 0F);
      Right = new ModelRenderer(this, 0, 35);
      Right.addBox(0F, 0F, 0F, 1, 13, 16);
      Right.setRotationPoint(-8F, 8F, -8F);
      Right.setTextureSize(64, 64);
      Right.mirror = true;
      setRotation(Right, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Fond.render(f5);
    Pied_1.render(f5);
    Pied_2.render(f5);
    Pied_3.render(f5);
    Pied_4.render(f5);
    Front.render(f5);
    Back.render(f5);
    Left.render(f5);
    Right.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
    public void renderModel(float f1)
    {
        Fond.render(f1);
        Pied_1.render(f1);
        Pied_2.render(f1);
        Pied_3.render(f1);
        Pied_4.render(f1);
        Front.render(f1);
        Back.render(f1);
        Left.render(f1);
        Right.render(f1);
    }

}
