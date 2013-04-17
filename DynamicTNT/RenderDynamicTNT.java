package ExpandedTNT.DynamicTNT;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

import ExpandedTNT.ExpandedTNT;

public class RenderDynamicTNT implements ISimpleBlockRenderingHandler {
	public int rendererId; //Rendererererererererererer.
	
	public RenderDynamicTNT(int rendererId) {
		this.rendererId = rendererId;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		RenderingRegistry.instance().renderInventoryBlock(renderer, block, metadata, modelID);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return RenderingRegistry.instance().renderWorldBlock(renderer, world, x, y, z, block, modelId);
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return rendererId;
	}
}
