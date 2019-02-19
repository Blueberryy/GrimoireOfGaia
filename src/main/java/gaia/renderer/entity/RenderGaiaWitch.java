package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaWitch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaWitch extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/witch.png");

	public RenderGaiaWitch(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaWitch(), shadowSize);
		addLayer(LayerGaiaWitchHeldItem.right(this, getModel().getAnchor()));
	}

	private ModelGaiaWitch getModel() {
		return (ModelGaiaWitch) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GlStateManager.translatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}

	@OnlyIn(Dist.CLIENT)
	public static class LayerGaiaWitchHeldItem implements LayerRenderer<EntityLivingBase> {

		ModelRenderer limb;
		EntityEquipmentSlot slot;

		private final RenderLiving<EntityLiving> livingEntityRenderer;

		/**
		 * Could probably had done another if( instanceof )check instead of another class but I'm naive about performance so, here's another class.
		 **/
		LayerGaiaWitchHeldItem(RenderLiving<EntityLiving> livingEntityRendererIn, ModelRenderer limb, EntityEquipmentSlot slot) {
			livingEntityRenderer = livingEntityRendererIn;
			this.limb = limb;
			this.slot = slot;
		}

		public static LayerGaiaWitchHeldItem right(RenderLiving<EntityLiving> livingEntityRendererIn, ModelRenderer limb) {
			return new LayerGaiaWitchHeldItem(livingEntityRendererIn, limb, EntityEquipmentSlot.MAINHAND);
		}

		public void render(EntityLivingBase living, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
				float netHeadYaw, float headPitch, float scale) {
			ItemStack stack = living.getItemStackFromSlot(slot);

			if (!stack.isEmpty()) {
				GlStateManager.pushMatrix();

				if (livingEntityRenderer.getMainModel().isChild) {
					GlStateManager.translatef(0.0F, 0.625F, 0.0F);
					GlStateManager.rotatef(-20.0F, -1.0F, 0.0F, 0.0F);
					GlStateManager.scalef(0.5F, 0.5F, 0.5F);
				}
				if (slot == EntityEquipmentSlot.MAINHAND) {
					renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
				}
				if (slot == EntityEquipmentSlot.OFFHAND) {
					renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
				} else {
					renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
				}
				GlStateManager.popMatrix();
			}
		}

		void renderHeldItem(EntityLivingBase living, ItemStack stack, ItemCameraTransforms.TransformType camera, EnumHandSide handSide) {
			if (!stack.isEmpty()) {
				GlStateManager.pushMatrix();

				if (living.isSneaking()) {
					GlStateManager.translatef(0.0F, 0.2F, 0.0F);
				}
				limb.postRender(0.0625F);
				GlStateManager.rotatef(-40.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.translatef(0F, 0.1F, 0.15F);

				GlStateManager.rotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
				boolean flag = handSide == EnumHandSide.LEFT;
				GlStateManager.translatef((float) (flag
						? -1
						: 1) / 16.0F, 0.125F, -0.625F);
				Minecraft.getInstance()
						.getFirstPersonRenderer().renderItemSide(living, stack, camera, flag);
				GlStateManager.popMatrix();
			}
		}

		public boolean shouldCombineTextures() {
			return false;
		}
	}
}
