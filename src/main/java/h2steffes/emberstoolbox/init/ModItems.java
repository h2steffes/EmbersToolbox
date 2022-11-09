package h2steffes.emberstoolbox.init;

import h2steffes.emberstoolbox.item.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder("emberstic:stamp_axe_head")
    public static final ItemBase STAMP_AXE_HEAD = new ItemBase("stamp_axe_head");

    @GameRegistry.ObjectHolder("emberstic:stamp_excavator_head")
    public static final ItemBase STAMP_EXCAVATOR_HEAD = new ItemBase("stamp_excavator_head");

    @GameRegistry.ObjectHolder("emberstic:stamp_hammer_head")
    public static final ItemBase STAMP_HAMMER_HEAD = new ItemBase("stamp_hammer_head");

    @GameRegistry.ObjectHolder("emberstic:stamp_kama_head")
    public static final ItemBase STAMP_KAMA_HEAD = new ItemBase("stamp_kama_head");

    @GameRegistry.ObjectHolder("emberstic:stamp_knife_blade")
    public static final ItemBase STAMP_KNIFE_BLADE = new ItemBase("stamp_knife_blade");

    @GameRegistry.ObjectHolder("emberstic:stamp_pick_head")
    public static final ItemBase STAMP_PICK_HEAD = new ItemBase("stamp_pick_head");

    @GameRegistry.ObjectHolder("emberstic:stamp_shovel_head")
    public static final ItemBase STAMP_SHOVEL_HEAD = new ItemBase("stamp_shovel_head");

    @GameRegistry.ObjectHolder("emberstic:stamp_sword_blade")
    public static final ItemBase STAMP_SWORD_BLADE = new ItemBase("stamp_sword_blade");

    @GameRegistry.ObjectHolder("emberstic:stamp_wide_guard")
    public static final ItemBase STAMP_WIDE_GUARD = new ItemBase("stamp_wide_guard");

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        STAMP_AXE_HEAD.initModel();
        STAMP_EXCAVATOR_HEAD.initModel();
        STAMP_HAMMER_HEAD.initModel();
        STAMP_KAMA_HEAD.initModel();
        STAMP_KNIFE_BLADE.initModel();
        STAMP_PICK_HEAD.initModel();
        STAMP_SHOVEL_HEAD.initModel();
        STAMP_SWORD_BLADE.initModel();
        STAMP_WIDE_GUARD.initModel();
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        STAMP_AXE_HEAD.register(event);
        STAMP_EXCAVATOR_HEAD.register(event);
        STAMP_HAMMER_HEAD.register(event);
        STAMP_KAMA_HEAD.register(event);
        STAMP_KNIFE_BLADE.register(event);
        STAMP_PICK_HEAD.register(event);
        STAMP_SHOVEL_HEAD.register(event);
        STAMP_SWORD_BLADE.register(event);
        STAMP_WIDE_GUARD.register(event);
    }

}
