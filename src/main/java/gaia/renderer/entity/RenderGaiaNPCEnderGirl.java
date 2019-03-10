package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCEnderGirl;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCEnderGirl extends RenderLiving<EntityLiving> {
	private static final ResourceLocation endergirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_girl.png");

	public RenderGaiaNPCEnderGirl(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaNPCEnderGirl(), shadowSize);
		addLayer(new LayerGlowing(this, endergirlEyesTexture));
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaNPCEnderGirl getModel() {
		return (ModelGaiaNPCEnderGirl) getMainModel();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
