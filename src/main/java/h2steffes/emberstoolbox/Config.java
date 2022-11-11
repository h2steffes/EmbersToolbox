package h2steffes.emberstoolbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.Level;
import net.minecraftforge.common.config.Configuration;
import toolbox.common.CommonProxy;

public class Config {

	private static final String CATEGORY_CRAFTING = "all.crafting";
	
	private final static List<String> PROPERTY_ORDER_CRAFTING = new ArrayList<>();
	
	public static boolean REMOVE_TOOL_HEAD_RECIPES = true;
	public static List<String> MATERIALS_TO_KEEP_RECIPES = new ArrayList<>();

	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initCraftingConfig(cfg);
		} catch (Exception e1) {
			Emberstoolbox.logger.log(Level.ERROR, "Problem loading config file!", e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initCraftingConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_CRAFTING, "Crafting Recipe Options");
		
		REMOVE_TOOL_HEAD_RECIPES = cfg.getBoolean("Remove Metal Tool Head Recipes", CATEGORY_CRAFTING, REMOVE_TOOL_HEAD_RECIPES, "This option removes the crafting recipes for any materials that get added as stamping recipes\n");
		MATERIALS_TO_KEEP_RECIPES = Arrays.asList(cfg.getStringList("Recipe Removal Exceptions", CATEGORY_CRAFTING, new String[] {"copper"}, "Materials to exclude from the recipe removal\n"));
		
		PROPERTY_ORDER_CRAFTING.add("Remove Metal Tool Head Recipes");
		PROPERTY_ORDER_CRAFTING.add("Recipe Removal Exceptions");
		
		cfg.setCategoryPropertyOrder(CATEGORY_CRAFTING, PROPERTY_ORDER_CRAFTING);
	}
}
