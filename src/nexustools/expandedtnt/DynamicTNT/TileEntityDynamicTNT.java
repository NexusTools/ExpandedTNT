package nexustools.expandedtnt.DynamicTNT;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDynamicTNT extends TileEntity {
	public static HashMap<ItemStack[], ItemStack> variants = new HashMap<ItemStack[], ItemStack>();

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}
}
