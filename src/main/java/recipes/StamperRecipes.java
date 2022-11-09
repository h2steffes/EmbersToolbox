package recipes;

import api.materials.HeadMaterial;
import api.materials.Materials;
import h2steffes.emberstoolbox.item.ItemBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import teamroots.embers.recipe.ItemStampingRecipe;
import teamroots.embers.recipe.RecipeRegistry;
import toolbox.common.items.ModItems;
import toolbox.common.items.parts.ItemToolHead;
import toolbox.common.materials.ModMaterials;

//adapted from toolbox's TiCon compat
//https://github.com/cadaverous-eris/Adventurers-Toolbox/tree/master/src/main/java/toolbox/compat/tconstruct
public class StamperRecipes {

	private static final int ingotCost = 144;
	
	public static void init() {
		ItemStampingRecipe recipe;
		for (EnumType type : EnumType.VALUES) {
			if (!toolbox.common.Config.DISABLED_TOOLS.contains(type.getTool())) {
				int i = 0;
				for (HeadMaterial mat : Materials.head_registry.values()) {
					ItemStack head = new ItemStack(type.getItem(), 1, i);
					Fluid fluid = FluidRegistry.getFluid(mat.getName());
					if (fluid != null && !toolbox.common.Config.DISABLED_MATERIALS.contains(mat.getName()) && !mat.equals(ModMaterials.HEAD_STONE)) {
						recipe = new ItemStampingRecipe(Ingredient.EMPTY, new FluidStack(fluid, type.getCost()), Ingredient.fromItem(type.getStamp()), head);
						RecipeRegistry.stampingRecipes.add(recipe);
					}
					i++;
				}
			}
		}
	}

	public enum EnumType {

		PICKAXE_HEAD(ModItems.pickaxe_head, "pickaxe", ingotCost * 3, h2steffes.emberstoolbox.init.ModItems.STAMP_PICK_HEAD),
		AXE_HEAD(ModItems.axe_head, "axe", ingotCost * 3, h2steffes.emberstoolbox.init.ModItems.STAMP_AXE_HEAD),
		SHOVEL_HEAD(ModItems.shovel_head, "shovel", ingotCost * 1, h2steffes.emberstoolbox.init.ModItems.STAMP_SHOVEL_HEAD),
		HOE_HEAD(ModItems.hoe_head, "hoe", ingotCost * 2, h2steffes.emberstoolbox.init.ModItems.STAMP_KAMA_HEAD),
		HANDPICK_HEAD(ModItems.handpick_head, "handpick", ingotCost * 1, h2steffes.emberstoolbox.init.ModItems.STAMP_HAND_PICK_HEAD),
		HAMMER_HEAD(ModItems.hammer_head, "hammer", ingotCost * 7, h2steffes.emberstoolbox.init.ModItems.STAMP_HAMMER_HEAD),
		SWORD_BLADE(ModItems.sword_blade, "sword", ingotCost * 2, h2steffes.emberstoolbox.init.ModItems.STAMP_SWORD_BLADE),
		SWORD_CROSSGUARD(ModItems.sword_crossguard, "sword", ingotCost * 3, h2steffes.emberstoolbox.init.ModItems.STAMP_WIDE_GUARD),
		DAGGER_BLADE(ModItems.dagger_blade, "dagger", ingotCost * 1, h2steffes.emberstoolbox.init.ModItems.STAMP_KNIFE_BLADE),
		MACE_HEAD(ModItems.mace_head, "mace", ingotCost * 5, h2steffes.emberstoolbox.init.ModItems.STAMP_EXCAVATOR_HEAD);

		public final static EnumType[] VALUES = values();

		private final ItemToolHead item;
		private final String tool;
		private final int cost;
		private final ItemBase stamp;

		EnumType(ItemToolHead item, String tool, int cost, ItemBase stamp) {
			this.item = item;
			this.tool = tool;
			this.cost = cost;
			this.stamp = stamp;
		}

		int getMetadata() {
			return this.ordinal();
		}

		String getName() {
			return this.name().toLowerCase();
		}

		public ItemToolHead getItem() {
			return item;
		}

		public String getTool() {
			return tool;
		}

		public int getCost() {
			return cost;
		}
		public ItemBase getStamp() {
			return stamp;
		}

	}
	
}
