package ExpandedTNT.DynamicTNT;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import ExpandedTNT.ExpandedTNT;

public class BlockDynamicTNT extends BlockContainer {
	public BlockDynamicTNT(int par1) {
		super(par1, Material.tnt);
	}
	
	public static ItemStack createNewVariant(InventoryCrafting craftMatrix) {
		if(craftMatrix == null) //Redundant checks everywhere.
			return null;
		if(TileEntityDynamicTNT.variants.containsKey(craftMatrix))
			return TileEntityDynamicTNT.variants.get(craftMatrix);
		
		ItemStack returnedItemStack = null;
		
		if(craftMatrix.getStackInSlot(4) != null && craftMatrix.getStackInSlot(4).itemID == new ItemStack(Block.tnt).itemID) {
			returnedItemStack = new ItemStack(ExpandedTNT.dynamicTNT);
			TileEntityDynamicTNT.variants.put(craftMatrix, returnedItemStack);
		}
		
		return returnedItemStack;
	}
	
	public int getBlockTextureFromSide(int par1) {
		switch(par1) {
		case 0:
			return 17;
		case 1:
			return 16;
		}
		return 2;
    }
	
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return true;
    }
    
    @Override
    public String getTextureFile() {
    	return "/ExpandedTNT/images/tntsheet.png";
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityDynamicTNT();
	}
}
