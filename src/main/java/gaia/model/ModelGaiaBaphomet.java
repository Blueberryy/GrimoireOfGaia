package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBaphomet extends ModelBase {
	ModelRenderer head;
    ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer righthairclip;
	ModelRenderer lefthairclip;
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer righthorn;
	ModelRenderer lefthorn;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer mantle;
	ModelRenderer mantlefront;
	ModelRenderer cloak1;
	ModelRenderer cloak2;
	ModelRenderer cloak3;
	ModelRenderer righthand;
	ModelRenderer lefthand;
	ModelRenderer waist;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;

	public ModelGaiaBaphomet() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 2F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 2F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, -0.5F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.righthairclip = new ModelRenderer(this, 36, 14);
		this.righthairclip.addBox(-5.5F, -5F, 2.533333F, 3, 5, 3);
		this.righthairclip.setRotationPoint(0F, 1F, 0F);
		this.righthairclip.setTextureSize(64, 32);
		this.setRotation(righthairclip, 0.1745329F, 0F, 0.1745329F);
		this.lefthairclip = new ModelRenderer(this, 48, 14);
		this.lefthairclip.addBox(2.5F, -5F, 2.5F, 3, 5, 3);
		this.lefthairclip.setRotationPoint(0F, 1F, 0F);
		this.lefthairclip.setTextureSize(64, 32);
		this.setRotation(lefthairclip, 0.1745329F, 0F, -0.1745329F);
		this.righthair = new ModelRenderer(this, 36, 22);
		this.righthair.addBox(-5F, -4.5F, 3F, 2, 10, 2);
		this.righthair.setRotationPoint(0F, 1F, 0F);
		this.righthair.setTextureSize(64, 32);
		this.setRotation(righthair, 0.1745329F, 0F, 0.1745329F);
		this.lefthair = new ModelRenderer(this, 36, 22);
		this.lefthair.addBox(3F, -4.5F, 3F, 2, 10, 2);
		this.lefthair.setRotationPoint(0F, 1F, 0F);
		this.lefthair.setTextureSize(64, 32);
		this.setRotation(lefthair, 0.1745329F, 0F, -0.1745329F);
		this.righthorn = new ModelRenderer(this, 36, 34);
		this.righthorn.addBox(-3F, -9F, 0F, 2, 6, 6);
		this.righthorn.setRotationPoint(0F, 1F, 0F);
		this.righthorn.setTextureSize(64, 32);
		this.setRotation(righthorn, 0F, 0F, 0F);
		this.lefthorn = new ModelRenderer(this, 36, 34);
		this.lefthorn.addBox(1F, -9F, 0F, 2, 6, 6);
		this.lefthorn.setRotationPoint(0F, 1F, 0F);
		this.lefthorn.setTextureSize(64, 32);
		this.setRotation(lefthorn, 0F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 42);
		this.rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, -0.5235988F, 0F);
		this.leftear = new ModelRenderer(this, 36, 42);
		this.leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, 0.5235988F, 0F);
		this.mantle = new ModelRenderer(this, 64, 0);
		this.mantle.addBox(-5F, 0F, -0.5F, 10, 3, 3);
		this.mantle.setRotationPoint(0F, 1F, 0F);
		this.mantle.setTextureSize(64, 32);
		this.setRotation(mantle, 0F, 0F, 0F);
		this.mantlefront = new ModelRenderer(this, 64, 6);
		this.mantlefront.addBox(-4F, 0F, -2F, 8, 3, 3);
		this.mantlefront.setRotationPoint(0F, 1F, 0F);
		this.mantlefront.setTextureSize(64, 32);
		this.setRotation(mantlefront, 0F, 0F, 0F);
		this.cloak1 = new ModelRenderer(this, 64, 12);
		this.cloak1.addBox(-4.5F, 1F, -0.5F, 9, 4, 3);
		this.cloak1.setRotationPoint(0F, 1F, 0F);
		this.cloak1.setTextureSize(64, 32);
		this.setRotation(cloak1, 0.2617994F, 0F, 0F);
		this.cloak2 = new ModelRenderer(this, 64, 19);
		this.cloak2.addBox(-5F, 4.5F, 0.5F, 10, 6, 3);
		this.cloak2.setRotationPoint(0F, 1F, 0F);
		this.cloak2.setTextureSize(64, 32);
		this.setRotation(cloak2, 0.1745329F, 0F, 0F);
		this.cloak3 = new ModelRenderer(this, 64, 28);
		this.cloak3.addBox(-5.5F, 10F, 2F, 11, 8, 3);
		this.cloak3.setRotationPoint(0F, 1F, 0F);
		this.cloak3.setTextureSize(64, 32);
		this.setRotation(cloak3, 0.0872665F, 0F, 0F);
		this.righthand = new ModelRenderer(this, 64, 39);
		this.righthand.addBox(-2.5F, 6F, -1.5F, 3, 5, 3);
		this.righthand.setRotationPoint(-2.5F, 2.5F, 0F);
		this.righthand.setTextureSize(64, 32);
		this.setRotation(righthand, 0F, 0F, 0.1745329F);
		this.lefthand = new ModelRenderer(this, 76, 39);
		this.lefthand.addBox(-0.5F, 6F, -1.5F, 3, 5, 3);
		this.lefthand.setRotationPoint(2.5F, 2.5F, 0F);
		this.lefthand.setTextureSize(64, 32);
		this.setRotation(lefthand, 0F, 0F, -0.1745329F);
		this.waist = new ModelRenderer(this, 64, 47);
		this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 92, 0);
		this.rightfoot.addBox(-2F, 5F, -1.5F, 4, 8, 4);
		this.rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(rightfoot, 0F, 0F, 0F);
		this.leftfoot = new ModelRenderer(this, 108, 0);
		this.leftfoot.addBox(-2F, 5F, -1.5F, 4, 8, 4);
		this.leftfoot.setRotationPoint(2F, 11F, -0.5F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(leftfoot, 0F, 0F, 0F);
		
		this.convertToChild(head, righthorn);
		this.convertToChild(head, lefthorn);
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, righthand);
		this.convertToChild(leftarm, lefthand);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.neck.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
		this.righthairclip.render(par7);
		this.lefthairclip.render(par7);
		this.righthair.render(par7);
		this.lefthair.render(par7);
//		this.righthorn.render(par7);
//		this.lefthorn.render(par7);
//		this.rightear.render(par7);
//		this.leftear.render(par7);
		this.mantle.render(par7);
		this.mantlefront.render(par7);
		this.cloak1.render(par7);
		this.cloak2.render(par7);
		this.cloak3.render(par7);
//		this.righthand.render(par7);
//		this.lefthand.render(par7);
		this.waist.render(par7);
		this.rightfoot.render(par7);
		this.leftfoot.render(par7);

		if (entity.ticksExisted % 60 == 0 && par3 <= 0.1F) {
			this.headeyes.render(par7);
		} 
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.righthairclip.rotateAngleY = this.head.rotateAngleY;
		this.lefthairclip.rotateAngleY = this.head.rotateAngleY;
		this.righthair.rotateAngleY = this.head.rotateAngleY;
		this.lefthair.rotateAngleY = this.head.rotateAngleY;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;

		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        float f6;
        float f7;

        if (this.swingProgress > -9990.0F) {
            f6 = this.swingProgress;
            f6 = 1.0F - this.swingProgress;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
        
        //body
		this.cloak1.rotateAngleZ = MathHelper.cos(par1 * 0.6162F) * 0.1F * par2;
		this.cloak2.rotateAngleZ = MathHelper.cos(par1 * 0.6262F) * 0.1F * par2;
		this.cloak3.rotateAngleZ = MathHelper.cos(par1 * 0.6362F) * 0.1F * par2;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX;
	}
	
	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		parParent.addChild(parChild);
	}
}
