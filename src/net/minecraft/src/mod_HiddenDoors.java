package net.minecraft.src;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class mod_HiddenDoors extends BaseMod
{
    public static String modDir;
    private static Props props;
    public static int    iOff;
    public static Block  door;
    public static Item   itemDoor;
    
    public mod_HiddenDoors()
    {}
    
    @Override
    public String getName()
    {
        return "HiddenDoors";
    }
    
    @Override
    public String getVersion()
    {
        return "ML 1.5.1.r01";
    }
    
    private static String getAppdata()
    {
        return Minecraft.getMinecraftDir().getPath();
    }
    
    @Override
    public void load()
    {
        ModLoader.registerBlock(door);
        ModLoader.addName(itemDoor, "Hidden Door");
        ModLoader.addRecipe(new ItemStack(itemDoor), new Object[]
        {
                "XX", "XX", "XX", Character.valueOf('X'), Block.bookShelf
        });
    }
    
    public static void prepareProps()
    {
        props.getInt("blockHiddenDoor", 255);
        props.getInt("itemHiddenDoor", 1600);
    }
    
    static
    {
        modDir = "/TehKrush/";
        props = new Props((new File((new StringBuilder()).append(getAppdata()).append("/config/").append("mod_HiddenDoors.cfg").toString())).getPath());
        iOff = 256;
        prepareProps();
        door = (new BlockHiddenDoor(props.getInt("blockHiddenDoor"))).setHardness(1.2F).setStepSound(Block.soundWoodFootstep).setBlockName("hiddenDoor");
        itemDoor = (new ItemHiddenDoor(props.getInt("itemHiddenDoor") - iOff)).setIconIndex(ModLoader.addOverride("/gui/items.png", (new StringBuilder()).append(modDir).append("itemHiddenDoor.png").toString())).setItemName("hiddenDoorItem");
        props.save();
    }
}
