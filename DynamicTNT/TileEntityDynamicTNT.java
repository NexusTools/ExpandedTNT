package ExpandedTNT.DynamicTNT;

import java.util.HashMap;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDynamicTNT extends TileEntity {
	public static HashMap<InventoryCrafting, ItemStack> variants = new HashMap<InventoryCrafting, ItemStack>();
}
