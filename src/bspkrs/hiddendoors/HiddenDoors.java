package bspkrs.hiddendoors;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import bspkrs.util.BSProp;
import bspkrs.util.BSPropRegistry;

public class HiddenDoors
{
    public static final String VERSION_NUMBER    = "1.5.1.r02";
    public static String       modDir            = "hiddendoors";
    public static int          iOff              = 256;
    public static Block        blockHiddenDoorWood;
    public static Block        blockHiddenDoorIron;
    public static Item         itemHiddenDoorWood;
    public static Item         itemHiddenDoorIron;
    @BSProp
    public static int          hiddenDoorBlockID = 1699;
    @BSProp
    public static int          hiddenDoorItemID  = 16099;
    
    private static boolean     initialized       = false;
    
    public static void init()
    {
        if (!initialized)
        {
            BSPropRegistry.registerPropHandler(HiddenDoors.class);
            
            blockHiddenDoorWood = (new BlockHiddenDoor(hiddenDoorBlockID, Material.wood)).setHardness(1.2F)
                    .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("hiddenWoodenDoor");
            itemHiddenDoorWood = (new ItemHiddenDoor(hiddenDoorItemID, Material.wood)).setUnlocalizedName("itemHiddenDoorWood");
            
            blockHiddenDoorIron = (new BlockHiddenDoor(hiddenDoorBlockID + 1, Material.iron)).setHardness(1.2F)
                    .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("hiddenIronDoor");
            itemHiddenDoorIron = (new ItemHiddenDoor(hiddenDoorItemID + 1, Material.iron)).setUnlocalizedName("itemHiddenDoorIron");
            
            ModLoader.registerBlock(blockHiddenDoorWood);
            ModLoader.registerBlock(blockHiddenDoorIron);
            ModLoader.addName(itemHiddenDoorWood, "Hidden Wood Door");
            ModLoader.addName(itemHiddenDoorIron, "Hidden Iron Door");
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorWood), new Object[]
            {
                    "XXX", "XDX", "XXX", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Block.doorWood
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorIron), new Object[]
            {
                    "XXX", "XDX", "XXX", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Block.doorIron
            });
            
            initialized = true;
        }
    }
    
}
