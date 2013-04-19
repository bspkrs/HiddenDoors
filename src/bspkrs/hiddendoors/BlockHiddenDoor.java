package bspkrs.hiddendoors;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockHiddenDoor extends BlockDoor
{
    public BlockHiddenDoor(int i, Material material)
    {
        super(i, material);
    }
    
    @Override
    public Icon getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int blockBelow = iblockaccess.getBlockId(i, j - 1, k);
        
        if (blockBelow == blockID)
        {
            blockBelow = iblockaccess.getBlockId(i, j - 2, k);
            if (blockBelow == Block.grass.blockID || blockBelow == Block.mycelium.blockID)
            {
                return Block.dirt.getBlockTexture(iblockaccess, i, j - 2, k, l);
            }
            if (iblockaccess.getBlockId(i, j - 2, k) > 0)
            {
                return Block.blocksList[iblockaccess.getBlockId(i, j - 2, k)].getIcon(6, iblockaccess.getBlockMetadata(i, j - 2, k));
            }
        }
        
        if (blockBelow == Block.grass.blockID || blockBelow == Block.mycelium.blockID)
        {
            return Block.dirt.getBlockTexture(iblockaccess, i, j - 1, k, l);
        }
        if (iblockaccess.getBlockId(i, j - 1, k) > 0)
        {
            return Block.blocksList[iblockaccess.getBlockId(i, j - 1, k)].getIcon(6, iblockaccess.getBlockMetadata(i, j - 1, k));
        }
        else
        {
            return null;
        }
    }
    
    /*@Override
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        
        if ((i1 & 8) != 0)
        {
            if (world.getBlockId(i, j - 1, k) != blockID)
            {
                world.setBlock(i, j, k, 0, 0, 3);
            }
            if (l > 0 && Block.blocksList[l].canProvidePower())
            {
                canPlaceBlockOnSide(world, i, j - 1, k, l);
            }
        }
        else
        {
            boolean flag = false;
            if (world.getBlockId(i, j + 1, k) != blockID)
            {
                world.setBlock(i, j, k, 0, 0, 3);
            }
            if (!world.isBlockNormalCube(i, j - 1, k))
            {
                world.setBlock(i, j, k, 0, 0, 3);
                flag = true;
                if (world.getBlockId(i, j + 1, k) == blockID)
                {
                    world.setBlock(i, j + 1, k, 0, 0, 3);
                }
            }
            if (flag)
            {
                if (!world.isRemote)
                {
                    dropBlockAsItem(world, i, j, k, i1, 0);
                }
            }
            else if (l > 0 && Block.blocksList[l].canProvidePower())
            {
                boolean flag1 = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k);
                onPoweredBlockChange(world, i, j, k, flag1);
            }
        }
    }*/
    
    @Override
    public int idDropped(int i, Random random, int j)
    {
        return (i & 8) != 0 ? 0 : (this.blockMaterial == Material.iron
                ? HiddenDoors.itemHiddenDoorIron.itemID
                : HiddenDoors.itemHiddenDoorWood.itemID);
    }
}
