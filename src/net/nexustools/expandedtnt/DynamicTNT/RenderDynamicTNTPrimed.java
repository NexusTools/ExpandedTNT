package net.nexustools.expandedtnt.DynamicTNT;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.nexustools.expandedtnt.ExpandedTNT;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDynamicTNTPrimed extends Render {
	private RenderBlocks blockRenderer = new RenderBlocks();

	public RenderDynamicTNTPrimed() {
		shadowSize = 0.5F;
	}

	@Override
	public void doRender(Entity e, double x, double y, double z, float par8, float par9) {
		EntityDynamicTNTPrimed entityDynamicTNT = (EntityDynamicTNTPrimed) e;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		float var10;

		if(entityDynamicTNT.fuse - par9 + 1.0F < 10.0F) {
			var10 = 1.0F - (entityDynamicTNT.fuse - par9 + 1.0F) / 10.0F;

			if(var10 < 0.0F)
				var10 = 0.0F;

			if(var10 > 1.0F)
				var10 = 1.0F;

			var10 *= var10;
			var10 *= var10;
			float var11 = 1.0F + var10 * 0.3F;
			GL11.glScalef(var11, var11, var11);
		}

		var10 = (1.0F - (entityDynamicTNT.fuse - par9 + 1.0F) / 100.0F) * 0.8F;
		loadTexture("/nexustools/expandedtnt/images/tntsheet.png"); // TODO: Here
		blockRenderer.renderBlockAsItem(ExpandedTNT.dynamicTNT, 0, entityDynamicTNT.getBrightness(par9));

		if(entityDynamicTNT.fuse / 5 % 2 == 0) {
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var10);
			blockRenderer.renderBlockAsItem(ExpandedTNT.dynamicTNT, 0, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		GL11.glPopMatrix();
	}
}
