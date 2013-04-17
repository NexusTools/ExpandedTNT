package ExpandedTNT.DynamicTNTBench;

import ExpandedTNT.ExpandedTNT;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTNTWorkbench extends BlockContainer {
	public BlockTNTWorkbench(int par1) {
		super(par1, Material.wood);
		this.blockIndexInTexture = 59;
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	/**
	 * Returns the block texture based on the side being looked at. Args: side
	 */
	public int getBlockTextureFromSide(int par1) {
		return par1 == 1 ? this.blockIndexInTexture - 16
				: (par1 == 0 ? Block.planks.getBlockTextureFromSide(0)
						: (par1 != 2 && par1 != 4 ? this.blockIndexInTexture
								: this.blockIndexInTexture + 1));
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9) {
		//if (!world.isRemote) {
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if (tileEntity == null || player.isSneaking())
				return false;
			player.openGui(ExpandedTNT.instance, 0, world, x, y, z);
		//}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTNTWorkbench();
	}
}
