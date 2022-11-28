package h2steffes.emberstoolbox;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Emberstoolbox.MODID)
public class EmberstoolboxConfig{
	
	public static CraftingSettings craftingSettings = new CraftingSettings();
	
	public static class CraftingSettings{
		@Name("Remove Metal Tool Head Crafting")
		@Comment("This option removes the crafting recipes for any materials that get added as stamping recipes")
		@RequiresMcRestart
		public boolean removeCrafting = true;
		
		@Name("Crafting Removal Exceptions")
		@Comment("Materials to exclude from the above recipe removal")
		@RequiresMcRestart
		public String[] removalExceptions = {"copper", "bronze"};
	}
	
	@Mod.EventBusSubscriber(modid = Emberstoolbox.MODID)
    private static class EventHandler{
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Emberstoolbox.MODID)) {
                ConfigManager.sync(Emberstoolbox.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
