package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.model.ModelGaiaAnubis;
import gaia.model.ModelGaiaSuccubus;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaAnubis extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/anubis.png");
	private static final ResourceLocation textureMale = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/anubis_male.png");

	public RenderGaiaAnubis(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaAnubis(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaAnubis getModel() {
		return (ModelGaiaAnubis) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	private ResourceLocation getTexture(EntityGaiaAnubis entity) {
		if (!entity.isMale()) {
			return texture;
		} else {
			return textureMale;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaAnubis) entity);
	}
}
