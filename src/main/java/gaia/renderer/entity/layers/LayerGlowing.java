package gaia.renderer.entity.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @see LayerSpiderEyes
 */
@OnlyIn(Dist.CLIENT)
public class LayerGlowing implements LayerRenderer<EntityLiving> {
	private final ResourceLocation glowingTexture;
	private final RenderLiving<EntityLiving> livingEntityRenderer;

	public LayerGlowing(RenderLiving<EntityLiving> livingEntityRendererIn, ResourceLocation textureIn) {
		livingEntityRenderer = livingEntityRendererIn;
		glowingTexture = textureIn;
	}

	@Override
	public void render(EntityLiving entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		livingEntityRenderer.bindTexture(glowingTexture);

		GlStateManager.enableBlend();
		GlStateManager.blendFunc(1, 1);
		GlStateManager.disableLighting();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

		if (entitylivingbaseIn.isInvisible()) {
			GlStateManager.depthMask(false);
		} else {
			GlStateManager.depthMask(true);
		}

//		int i = 61680;
//		int j = i % 65536;
//		int k = i / 65536;

//		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
		GlStateManager.enableLighting();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

		livingEntityRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		livingEntityRenderer.setLightmap(entitylivingbaseIn);

		GlStateManager.depthMask(true);
		GlStateManager.disableBlend();
		GlStateManager.enableAlphaTest();
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
