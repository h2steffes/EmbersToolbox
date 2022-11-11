package h2steffes.emberstoolbox.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import toolbox.Toolbox;

public class ItemBase extends Item {

    private String oredict = null;

    public ItemBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(h2steffes.emberstoolbox.Emberstoolbox.MODID + "." + name);
        setCreativeTab(Toolbox.partsTab);
    }

    public ItemBase(String name, String oredict) {
        this(name);
        this.oredict = oredict;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public void register(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);

        // Probably bad practice?
        if (!(this.oredict == null)) {
            OreDictionary.registerOre(this.oredict, this);
        }
    }

}
