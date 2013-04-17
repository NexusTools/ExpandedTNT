package ExpandedTNT;

import java.util.logging.Logger;

import net.lepko.easycrafting.block.TileEntityEasyCrafting;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import ExpandedTNT.DynamicTNT.BlockDynamicTNT;
import ExpandedTNT.DynamicTNT.EntityDynamicTNTPrimed;
import ExpandedTNT.DynamicTNT.RenderDynamicTNT;
import ExpandedTNT.DynamicTNT.RenderDynamicTNTPrimed;
import ExpandedTNT.DynamicTNTBench.BlockTNTWorkbench;
import ExpandedTNT.DynamicTNTBench.TileEntityTNTWorkbench;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ExpandedTNT", name = "Expanded TNT", version = "0.9.9")
@NetworkMod(clientSideRequired = true)
public class ExpandedTNT {
	@Instance("ExpandedTNT")
	public static ExpandedTNT instance;
	public static Logger logInstance;
	public static Block tntWorkbench;
	public static int tntWorkbenchBlockID;
	
	public static Block dynamicTNT;
	public static int dynamicTNTBlockID;
	
	@PreInit
	public void preload(FMLPreInitializationEvent iEvent) {
		logInstance = Logger.getLogger("ExpandedTNT");
		Configuration conf = new Configuration(iEvent.getSuggestedConfigurationFile());
		conf.load();
		tntWorkbenchBlockID = conf.getBlock("tntWorkbenchBlockID", 407).getInt();
		dynamicTNTBlockID = conf.getBlock("dynamicTNTBlockID", 408).getInt();
		conf.save();
	}

	@Init
	public void load(FMLInitializationEvent iEvent) {
		MinecraftForgeClient.preloadTexture("/ExpandedTNT/images/tntsheet.png");
		
		tntWorkbench = new BlockTNTWorkbench(tntWorkbenchBlockID);
		GameRegistry.registerBlock(tntWorkbench.setBlockName("TNT Workbench"), "TNTWorkbench");
		GameRegistry.registerTileEntity(TileEntityTNTWorkbench.class, "TileEntityTNTWorkbench");
		NetworkRegistry.instance().registerGuiHandler(this, new ExpandedTNTGUIHandler());
		LanguageRegistry.addName(tntWorkbench, "TNT Workbench");
		
		dynamicTNT = new BlockDynamicTNT(dynamicTNTBlockID);
		GameRegistry.registerBlock(dynamicTNT.setBlockName("Dynamic TNT"), "DynamicTNT");
		LanguageRegistry.addName(dynamicTNT, "Dynamic TNT");
		RenderingRegistry.registerBlockHandler(new RenderDynamicTNT(RenderingRegistry.getNextAvailableRenderId()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamicTNTPrimed.class, new RenderDynamicTNTPrimed());
		EntityRegistry.registerModEntity(EntityDynamicTNTPrimed.class, "EntityDynamicTNTPrimed", 1, this, 160, 3, true);
	}
}
