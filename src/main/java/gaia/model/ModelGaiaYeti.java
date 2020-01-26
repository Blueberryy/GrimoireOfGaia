package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaYeti extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer mantle;
	private ModelRenderer bodyfront;
	private ModelRenderer bodyback;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer body1;
	private ModelRenderer body2;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;

	public ModelGaiaYeti() {
		textureWidth = 256;
		textureHeight = 128;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -9F, 8, 8, 8);
		head.setRotationPoint(0F, -7F, -4F);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer headaccessory = new ModelRenderer(this, 0, 40);
		headaccessory.addBox(-6F, -5F, -6F, 12, 8, 6);
		headaccessory.setRotationPoint(0F, -7F, 0F);
		setRotation(headaccessory, -0.2617994F, 0F, 0F);
		ModelRenderer horns = new ModelRenderer(this, 0, 16);
		horns.addBox(-4.5F, -6F, -9.5F, 9, 3, 9);
		horns.setRotationPoint(0F, -7F, -4F);
		setRotation(horns, 0F, 0F, 0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 28);
		headjaw.addBox(-6F, 0F, -8F, 12, 6, 6);
		headjaw.setRotationPoint(0F, -7F, 0F);
		setRotation(headjaw, 0F, 0F, 0F);
		mantle = new ModelRenderer(this, 0, 54);
		mantle.addBox(-9F, -5.5F, -3.5F, 18, 7, 9);
		mantle.setRotationPoint(0F, -7F, 0F);
		setRotation(mantle, -0.7853982F, 0F, 0F);
		bodyfront = new ModelRenderer(this, 54, 0);
		bodyfront.addBox(-7.5F, -2F, -8F, 15, 10, 5);
		bodyfront.setRotationPoint(0F, -7F, 0F);
		setRotation(bodyfront, 0.7853982F, 0F, 0F);
		bodyback = new ModelRenderer(this, 54, 15);
		bodyback.addBox(-8.5F, -3F, -3F, 17, 10, 8);
		bodyback.setRotationPoint(0F, -7F, 0F);
		setRotation(bodyback, 0.7853982F, 0F, 0F);
		rightarm = new ModelRenderer(this, 122, 0);
		rightarm.addBox(-5F, -1F, -3F, 5, 14, 5);
		rightarm.setRotationPoint(-8F, -6F, 1F);
		setRotation(rightarm, -0.2617994F, 0.1745329F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 122, 19);
		rightarmlower.addBox(-6F, 12F, -5.5F, 7, 12, 5);
		rightarmlower.setRotationPoint(-8F, -6F, 1F);
		setRotation(rightarmlower, -0.0872665F, 0.1745329F, 0F);
		ModelRenderer rightarmhand = new ModelRenderer(this, 122, 36);
		rightarmhand.addBox(-5.5F, 8F, 19F, 6, 4, 5);
		rightarmhand.setRotationPoint(-8F, -6F, 1F);
		setRotation(rightarmhand, -1.308997F, 0.1745329F, 0F);
		leftarm = new ModelRenderer(this, 122, 0);
		leftarm.addBox(0F, -1F, -3F, 5, 14, 5);
		leftarm.setRotationPoint(8F, -6F, 1F);
		setRotation(leftarm, -0.2617994F, -0.1745329F, 0F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 122, 19);
		leftarmlower.addBox(-1F, 12F, -5.5F, 7, 12, 5);
		leftarmlower.setRotationPoint(8F, -6F, 1F);
		setRotation(leftarmlower, -0.0872665F, -0.1745329F, 0F);
		ModelRenderer leftarmhand = new ModelRenderer(this, 122, 36);
		leftarmhand.addBox(-0.5F, 8F, 19F, 6, 4, 5);
		leftarmhand.setRotationPoint(8F, -6F, 1F);
		setRotation(leftarmhand, -1.308997F, -0.1745329F, 0F);
		body1 = new ModelRenderer(this, 54, 33);
		body1.addBox(-5.5F, 4F, -2F, 11, 11, 9);
		body1.setRotationPoint(0F, -7F, 0F);
		setRotation(body1, 0.2617994F, 0F, 0F);
		body2 = new ModelRenderer(this, 54, 53);
		body2.addBox(-3.5F, 12F, 2.5F, 7, 7, 7);
		body2.setRotationPoint(0F, -7F, 0F);
		setRotation(body2, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 104, 0);
		rightleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		rightleg.setRotationPoint(-3.5F, 9F, 6F);
		setRotation(rightleg, -0.2617994F, 0F, 0.0349066F);
		ModelRenderer rightleglower = new ModelRenderer(this, 104, 13);
		rightleglower.addBox(-2.5F, 5F, -3F, 5, 10, 4);
		rightleglower.setRotationPoint(-3.5F, 9F, 6F);
		setRotation(rightleglower, 0F, 0F, 0.0349066F);
		leftleg = new ModelRenderer(this, 104, 0);
		leftleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		leftleg.setRotationPoint(3.5F, 9F, 6F);
		setRotation(leftleg, -0.2617994F, 0F, -0.0349066F);
		ModelRenderer leftleglower = new ModelRenderer(this, 104, 13);
		leftleglower.addBox(-2.5F, 5F, -3F, 5, 10, 4);
		leftleglower.setRotationPoint(3.5F, 9F, 6F);
		setRotation(leftleglower, 0F, 0F, -0.0349066F);

		convertToChild(head, headaccessory);
		convertToChild(head, horns);
		convertToChild(head, headjaw);
		convertToChild(rightarm, rightarmlower);
		convertToChild(rightarm, rightarmhand);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, leftarmhand);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		mantle.render(scale);
		bodyfront.render(scale);
		bodyback.render(scale);
		body1.render(scale);
		body2.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		rightarm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F) - 0.2617994F;
		leftarm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F) - 0.2617994F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.2617994F;
		leftleg.rotateAngleX -= 0.2617994F;
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		// right arm
		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleY += (bodyfront.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX = (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodyfront.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}
}
