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
    public static final String VERSION_NUMBER        = "1.5.1.r02";
    public static Block        blockHiddenDoorWood;
    public static Block        blockHiddenDoorIron;
    public static Item         itemHiddenDoorWood;
    public static Item         itemHiddenDoorIron;
    @BSProp
    public static int          hiddenDoorWoodBlockID = 1699;
    @BSProp
    public static int          hiddenDoorIronBlockID = 1698;
    //@BSProp
    public static int          hiddenTrapDoorBlockID = 1697;
    @BSProp
    public static int          hiddenDoorWoodItemID  = 16099;
    @BSProp
    public static int          hiddenDoorIronItemID  = 16098;
    //@BSProp
    public static int          hiddenTrapDoorItemID  = 16097;
    
    private static boolean     initialized           = false;
    
    public static void init()
    {
        if (!initialized)
        {
            BSPropRegistry.registerPropHandler(HiddenDoors.class);
            
            blockHiddenDoorWood = (new BlockHiddenDoor(hiddenDoorWoodBlockID, Material.wood)).setHardness(1.2F)
                    .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("hiddenWoodenDoor");
            itemHiddenDoorWood = (new ItemHiddenDoor(hiddenDoorWoodItemID, Material.wood)).setUnlocalizedName("itemHiddenDoorWood");
            
            blockHiddenDoorIron = (new BlockHiddenDoor(hiddenDoorIronBlockID, Material.iron)).setHardness(5.0F)
                    .setStepSound(Block.soundMetalFootstep).setUnlocalizedName("hiddenIronDoor");
            itemHiddenDoorIron = (new ItemHiddenDoor(hiddenDoorIronItemID, Material.iron)).setUnlocalizedName("itemHiddenDoorIron");
            
            ModLoader.registerBlock(blockHiddenDoorWood);
            ModLoader.registerBlock(blockHiddenDoorIron);
            ModLoader.addName(itemHiddenDoorWood, "Hidden Wooden Door");
            ModLoader.addName(itemHiddenDoorIron, "Hidden Iron Door");
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorWood), new Object[]
            {
                    "XXG", "XDG", "XXG", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorWood, Character.valueOf('G'), Block.leaves
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorWood), new Object[]
            {
                    "GXX", "GDX", "GXX", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorWood, Character.valueOf('G'), Block.leaves
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorWood), new Object[]
            {
                    "XXG", "XDG", "XXG", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorWood, Character.valueOf('G'), Block.vine
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorWood), new Object[]
            {
                    "GXX", "GDX", "GXX", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorWood, Character.valueOf('G'), Block.vine
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorIron), new Object[]
            {
                    "XXG", "XDG", "XXG", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorIron, Character.valueOf('G'), Block.leaves
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorIron), new Object[]
            {
                    "GXX", "GDX", "GXX", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorIron, Character.valueOf('G'), Block.leaves
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorIron), new Object[]
            {
                    "XXG", "XDG", "XXG", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorIron, Character.valueOf('G'), Block.vine
            });
            ModLoader.addRecipe(new ItemStack(itemHiddenDoorIron), new Object[]
            {
                    "GXX", "GDX", "GXX", Character.valueOf('X'), Block.bookShelf, Character.valueOf('D'), Item.doorIron, Character.valueOf('G'), Block.vine
            });
            
            initialized = true;
        }
    }
    
}
