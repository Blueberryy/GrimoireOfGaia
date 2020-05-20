package gaia.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import gaia.entity.hostile.GaiaCobblestoneGolemEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaCobblestoneGolem<T extends GaiaCobblestoneGolemEntity> extends ModelGaia<T> {
	private ModelRenderer head;
	private ModelRenderer back;
	private ModelRenderer rightshoulder;
	private ModelRenderer leftshoulder;
	private ModelRenderer body;
	private ModelRenderer bodymid;
	private ModelRenderer bodylower;
	private ModelRenderer rightlegupper;
	private ModelRenderer leftlegupper;

	public ModelGaiaCobblestoneGolem() {
		textureWidth = 256;
		textureHeight = 128;

		ModelRenderer crown = new ModelRenderer(this, 32, 0);
		crown.addBox(-2.0F, -10.0F, -5.0F, 4, 4, 1);
		crown.setRotationPoint(0.0F, -1.0F, -2.0F);
		crown.setTextureSize(64, 32);
		setRotation(crown, 0.2617994F, 0.0F, 0.0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		head.setRotationPoint(0.0F, -1.0F, -2.0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.2617994F, 0.0F, 0.0F);
		ModelRenderer nose = new ModelRenderer(this, 32, 5);
		nose.addBox(-1.0F, -5.0F, -5.0F, 2, 3, 1);
		nose.setRotationPoint(0.0F, -1.0F, -2.0F);
		nose.setTextureSize(64, 32);
		setRotation(nose, 0.2617994F, 0.0F, 0.0F);
		ModelRenderer mouth = new ModelRenderer(this, 32, 9);
		mouth.addBox(-2.0F, -1.0F, -5.0F, 4, 2, 2);
		mouth.setRotationPoint(0.0F, -1.0F, -2.0F);
		mouth.setTextureSize(64, 32);
		setRotation(mouth, 0.2617994F, 0.0F, 0.0F);
		back = new ModelRenderer(this, 0, 16);
		back.addBox(-6.0F, -3.0F, -0.5F, 12, 5, 5);
		back.setRotationPoint(0.0F, -6.0F, 0.0F);
		back.setTextureSize(64, 32);
		setRotation(back, 0.9599311F, 0.0F, 0.0F);
		rightshoulder = new ModelRenderer(this, 45, 0);
		rightshoulder.addBox(-7.0F, -3.5F, -3.5F, 9, 8, 9);
		rightshoulder.setRotationPoint(-7.0F, -5.0F, 0.0F);
		rightshoulder.setTextureSize(64, 32);
		setRotation(rightshoulder, 0.1745329F, 0.0F, -0.2617994F);
		ModelRenderer rightarmupper = new ModelRenderer(this, 45, 17);
		rightarmupper.addBox(-4.0F, -1.0F, -2.0F, 5, 11, 5);
		rightarmupper.setRotationPoint(-7.0F, -5.0F, 0.0F);
		rightarmupper.setTextureSize(64, 32);
		setRotation(rightarmupper, -0.0872665F, 0.0F, 0.1745329F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 45, 33);
		rightarmlower.addBox(-4.0F, 9.0F, 2.0F, 5, 11, 5);
		rightarmlower.setRotationPoint(-7.0F, -5.0F, 0.0F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, -0.5235988F, 0.0F, 0.1745329F);
		ModelRenderer righthand = new ModelRenderer(this, 45, 49);
		righthand.addBox(-5.0F, 12.0F, 1.0F, 7, 9, 7);
		righthand.setRotationPoint(-7.0F, -5.0F, 0.0F);
		righthand.setTextureSize(64, 32);
		setRotation(righthand, -0.5235988F, 0.0F, 0.1745329F);
		leftshoulder = new ModelRenderer(this, 81, 0);
		leftshoulder.addBox(-2.0F, -3.5F, -3.5F, 9, 8, 9);
		leftshoulder.setRotationPoint(7.0F, -5.0F, 0.0F);
		leftshoulder.setTextureSize(64, 32);
		setRotation(leftshoulder, 0.1745329F, 0.0F, 0.2617994F);
		ModelRenderer leftarmupper = new ModelRenderer(this, 45, 17);
		leftarmupper.addBox(-1.0F, -1.0F, -2.0F, 5, 11, 5);
		leftarmupper.setRotationPoint(7.0F, -5.0F, 0.0F);
		leftarmupper.setTextureSize(64, 32);
		setRotation(leftarmupper, -0.0872665F, 0.0F, -0.1745329F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 45, 33);
		leftarmlower.addBox(-1.0F, 9.0F, 2.0F, 5, 11, 5);
		leftarmlower.setRotationPoint(7.0F, -5.0F, 0.0F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, -0.5235988F, 0.0F, -0.1745329F);
		ModelRenderer lefthand = new ModelRenderer(this, 73, 49);
		lefthand.addBox(-2.0F, 12.0F, 1.0F, 7, 9, 7);
		lefthand.setRotationPoint(7.0F, -5.0F, 0.0F);
		lefthand.setTextureSize(64, 32);
		setRotation(lefthand, -0.5235988F, 0.0F, -0.1745329F);
		body = new ModelRenderer(this, 0, 26);
		body.addBox(-7.0F, -2.0F, -3.0F, 14, 11, 8);
		body.setRotationPoint(0.0F, -6.0F, 0.0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0.2617994F, 0.0F, 0.0F);
		bodymid = new ModelRenderer(this, 0, 61);
		bodymid.addBox(-6.5F, 14.0F, 1.0F, 13, 7, 7);
		bodymid.setRotationPoint(0.0F, -7.0F, 0.0F);
		bodymid.setTextureSize(64, 32);
		setRotation(bodymid, 0.0F, 0.0F, 0.0F);
		bodylower = new ModelRenderer(this, 0, 45);
		bodylower.addBox(-6.0F, 7.0F, -1.0F, 12, 10, 6);
		bodylower.setRotationPoint(0.0F, -7.0F, 0.0F);
		bodylower.setTextureSize(64, 32);
		setRotation(bodylower, 0.1745329F, 0.0F, 0.0F);
		rightlegupper = new ModelRenderer(this, 45, 65);
		rightlegupper.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4);
		rightlegupper.setRotationPoint(-3.0F, 9.0F, 4.0F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, -0.2617994F, 0.0F, 0.0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 45, 79);
		rightleglower.addBox(-2.5F, 5.0F, 0.0F, 5, 10, 5);
		rightleglower.setRotationPoint(-3.0F, 9.0F, 4.0F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, -0.2617994F, 0.0F, 0.0F);
		leftlegupper = new ModelRenderer(this, 45, 65);
		leftlegupper.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4);
		leftlegupper.setRotationPoint(3.0F, 9.0F, 4.0F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, -0.2617994F, 0.0F, 0.0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 45, 79);
		leftleglower.addBox(-2.5F, 5.0F, 0.0F, 5, 10, 5);
		leftleglower.setRotationPoint(3.0F, 9.0F, 4.0F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, -0.2617994F, 0.0F, 0.0F);

		convertToChild(head, crown);
		convertToChild(head, nose);
		convertToChild(head, mouth);
		convertToChild(rightshoulder, rightarmupper);
		convertToChild(rightshoulder, rightarmlower);
		convertToChild(rightshoulder, righthand);
		convertToChild(leftshoulder, leftarmupper);
		convertToChild(leftshoulder, leftarmlower);
		convertToChild(leftshoulder, lefthand);
		convertToChild(rightlegupper, rightleglower);
		convertToChild(leftlegupper, leftleglower);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		back.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightshoulder.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftshoulder.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bodymid.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bodylower.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightlegupper.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftlegupper.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = (headPitch / 57.295776F) + 0.2617994F;

		// arms
		rightshoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftshoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightshoulder.rotateAngleZ = 0.0F;
		leftshoulder.rotateAngleZ = 0.0F;

		rightshoulder.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) - 0.2617994F;
		rightshoulder.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftshoulder.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) - 0.2617994F;
		leftshoulder.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// legs
		rightlegupper.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		rightlegupper.rotateAngleX -= 0.1745329F;
		leftlegupper.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		leftlegupper.rotateAngleX -= 0.1745329F;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		int i = entityIn.getAttackTimer();

		if (i > 0) {
			rightshoulder.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTickTime, 10.0F);
			leftshoulder.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTickTime, 10.0F);
		} else {
			rightshoulder.rotateAngleX = 0F;
			leftshoulder.rotateAngleX = 0F;
		}
	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}
}
