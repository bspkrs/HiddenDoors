package bspkrs.hiddendoors;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import bspkrs.util.BSProp;
import bspkrs.util.BSPropRegistry;

public class HiddenDoors
{
    public static String   modDir            = "hiddendoors";
    public static int      iOff              = 256;
    public static Block    door;
    public static Item     itemDoor;
    @BSProp
    public static int      hiddenDoorBlockID = 1699;
    @BSProp
    public static int      hiddenDoorItemID  = 16099;
    
    private static boolean initialized       = false;
    
    public static void init()
    {
        if (!initialized)
        {
            BSPropRegistry.registerPropHandler(HiddenDoors.class);
            
            door = (new BlockHiddenDoor(hiddenDoorBlockID)).setHardness(1.2F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("hiddenDoor");
            itemDoor = (new ItemHiddenDoor(hiddenDoorItemID)).setUnlocalizedName("itemHiddenDoor");
            
            ModLoader.registerBlock(door);
            ModLoader.addName(itemDoor, "Hidden Door");
            ModLoader.addRecipe(new ItemStack(itemDoor), new Object[]
            {
                    "XX", "XX", "XX", Character.valueOf('X'), Block.bookShelf
            });
            
            initialized = true;
        }
    }
    
}
