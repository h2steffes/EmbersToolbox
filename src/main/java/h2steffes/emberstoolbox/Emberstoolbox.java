package h2steffes.emberstoolbox;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import h2steffes.emberstoolbox.proxy.CommonProxy;

@Mod(modid = h2steffes.emberstoolbox.Emberstoolbox.MODID, name = h2steffes.emberstoolbox.Emberstoolbox.MODNAME, version = h2steffes.emberstoolbox.Emberstoolbox.MODVERSION, useMetadata = true, dependencies = "required-after:embers;required-after:toolbox;")
public class Emberstoolbox {

    public static final String MODID = "emberstoolbox";
    public static final String MODNAME = "Embers Toolbox";
    public static final String MODVERSION= "0.1.0";

    @SidedProxy(clientSide = "h2steffes.emberstoolbox.proxy.ClientProxy", serverSide = "h2steffes.emberstoolbox.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static h2steffes.emberstoolbox.Emberstoolbox instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
