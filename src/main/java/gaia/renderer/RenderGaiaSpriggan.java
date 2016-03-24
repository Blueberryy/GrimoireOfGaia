package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.model.ModelGaiaSpriggan;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSpriggan extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Spriggan.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaSpriggan(float shadowSize) {
        super(rend, new ModelGaiaSpriggan(), shadowSize);
        this.addLayer(new held_rightarm(this, ModelGaiaSpriggan.rightarm));
	}
	
	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
