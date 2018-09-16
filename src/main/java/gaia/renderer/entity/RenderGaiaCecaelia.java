package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaCecaelia;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaCecaelia extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/cecaelia.png");

	public RenderGaiaCecaelia(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaCecaelia(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaCecaelia getModel() {
		return (ModelGaiaCecaelia) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
