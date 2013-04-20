package nexustools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nexustools.DynamicTNTBench.TNTWorkbenchContainer;
import nexustools.DynamicTNTBench.TNTWorkbenchGUI;
import nexustools.DynamicTNTBench.TileEntityTNTWorkbench;
import cpw.mods.fml.common.network.IGuiHandler;

public class ExpandedTNTGUIHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityTNTWorkbench)
			return new TNTWorkbenchContainer(player.inventory, (TileEntityTNTWorkbench) tileEntity);
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityTNTWorkbench)
			return new TNTWorkbenchGUI(player.inventory, (TileEntityTNTWorkbench) tileEntity);
		return null;

	}
}
