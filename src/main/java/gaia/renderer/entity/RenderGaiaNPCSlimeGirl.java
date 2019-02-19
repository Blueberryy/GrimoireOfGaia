package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCSlimeGirl;
import gaia.renderer.entity.layers.LayerAlpha;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaNPCSlimeGirl extends RenderLiving<EntityLiving> {
	private static final ResourceLocation hairSlimeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_slime_girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/slime_girl.png");

	public RenderGaiaNPCSlimeGirl(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaNPCSlimeGirl(), shadowSize);
		addLayer(new LayerAlpha(this, hairSlimeGirl));
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaNPCSlimeGirl getModel() {
		return (ModelGaiaNPCSlimeGirl) getMainModel();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
