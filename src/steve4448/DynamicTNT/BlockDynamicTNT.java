package steve4448.DynamicTNT;

import java.util.List;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import steve4448.ExpandedTNT;

public class BlockDynamicTNT extends BlockContainer {
	
	
	public BlockDynamicTNT(int par1) {
		super(par1, Material.tnt);
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
    	return "/steve4448/images/tntsheet.png";
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityDynamicTNT();
	}
	
	public static ItemStack createNewVariant(InventoryCrafting craftMatrix) {
		if(craftMatrix == null) //Redundant checks everywhere.
			return null;
		ItemStack[] craftItems = new ItemStack[craftMatrix.getSizeInventory() - 1];
		
		for(int i = 1; i < craftMatrix.getSizeInventory() - 1; i++) {
			craftItems[i] = craftMatrix.getStackInSlot(i);
		}
		
		//Does this dynamic creation already exist? Check:
		ItemStack[] existantStack = null;
		for(ItemStack[] c : TileEntityDynamicTNT.variants.keySet()) {
			for(int i = 0; i < craftItems.length; i++) {
				if(c[i] == null || craftItems[i] == null && !(c[i] == null && craftItems[i] == null))
					continue;
				
				if((c[i] == null && craftItems[i] == null) || c[i].isItemEqual(craftItems[i])) {
					ExpandedTNT.logInstance.log(Level.INFO, "Found existant stack.");
					existantStack = c;
					break;
				}
			}
		}
		if(existantStack != null)
			return TileEntityDynamicTNT.variants.get(existantStack).copy();
		
		//Nope, create:
		ItemStack returnedItemStack = null;
		
		if(craftMatrix.getStackInSlot(4) != null && craftMatrix.getStackInSlot(4).itemID == new ItemStack(Block.tnt).itemID) {
			returnedItemStack = new ItemStack(ExpandedTNT.dynamicTNT);
			ExpandedTNT.logInstance.log(Level.INFO, "Creating a new item stack.");
			TileEntityDynamicTNT.variants.put(craftItems, returnedItemStack);
		}
		
		return returnedItemStack;
	}
}
