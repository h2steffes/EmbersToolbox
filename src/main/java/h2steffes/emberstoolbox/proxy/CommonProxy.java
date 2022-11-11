package h2steffes.emberstoolbox.proxy;

import java.io.File;

import h2steffes.emberstoolbox.Config;
import h2steffes.emberstoolbox.init.ModItems;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import recipes.StamperRecipes;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	public static Configuration config;
	
    public void preInit(FMLPreInitializationEvent event) {
    	File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "embers_toolbox.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent event) {
    	StamperRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
    	if (config.hasChanged()) {
			config.save();
		}
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.registerItems(event);
    }
}

