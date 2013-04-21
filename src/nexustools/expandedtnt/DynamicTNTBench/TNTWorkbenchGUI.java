package nexustools.expandedtnt.DynamicTNTBench;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class TNTWorkbenchGUI extends GuiContainer {

	public TNTWorkbenchGUI(InventoryPlayer inventoryPlayer, TileEntityTNTWorkbench tileEntity) {
		super(new TNTWorkbenchContainer(inventoryPlayer, tileEntity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRenderer.drawString("TNT Workbench", 8, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float x, int y, int z) {
		int texture = mc.renderEngine.getTexture("/nexustools/expandedtnt/images/tntworkbenchgui.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect((width - xSize) / 2, (height - ySize) / 2, 0, 0, xSize, ySize);
	}

}