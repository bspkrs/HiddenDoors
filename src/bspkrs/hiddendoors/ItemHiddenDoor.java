package bspkrs.hiddendoors;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemHiddenDoor extends Item
{
    private Material doorMaterial;
    
    public ItemHiddenDoor(int i, Material material)
    {
        super(i);
        this.doorMaterial = material;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l, float m, float n, float o)
    {
        if (l != 1)
        {
            return false;
        }
        else
        {
            ++j;
            Block block;
            
            if (this.doorMaterial == Material.wood)
            {
                block = HiddenDoors.blockHiddenDoorWood;
            }
            else
            {
                block = HiddenDoors.blockHiddenDoorIron;
            }
            
            if (entityplayer.canPlayerEdit(i, j, k, l, itemstack) && entityplayer.canPlayerEdit(i, j + 1, k, l, itemstack))
            {
                if (!block.canPlaceBlockAt(world, i, j, k))
                {
                    return false;
                }
                else
                {
                    int i1 = MathHelper.floor_double((entityplayer.rotationYaw + 180.0F) * 4.0F / 360.0F - 0.5D) & 3;
                    ItemDoor.placeDoorBlock(world, i, j, k, i1, block);
                    --itemstack.stackSize;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
}
