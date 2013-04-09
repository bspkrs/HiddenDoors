package net.minecraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHiddenDoor extends BlockDoor
{
    public BlockHiddenDoor(int i)
    {
        super(i, Material.wood);
        blockIndexInTexture = 0;
    }
    
    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if (iblockaccess.getBlockId(i, j - 1, k) == blockID)
        {
            if (iblockaccess.getBlockId(i, j - 2, k) == Block.grass.blockID)
            {
                return Block.dirt.blockIndexInTexture;
            }
            if (iblockaccess.getBlockId(i, j - 2, k) > 0)
            {
                return Block.blocksList[iblockaccess.getBlockId(i, j - 2, k)].getBlockTextureFromSideAndMetadata(6, iblockaccess.getBlockMetadata(i, j - 2, k));
            }
        }
        if (iblockaccess.getBlockId(i, j - 1, k) == Block.grass.blockID)
        {
            return Block.dirt.blockIndexInTexture;
        }
        if (iblockaccess.getBlockId(i, j - 1, k) > 0)
        {
            return Block.blocksList[iblockaccess.getBlockId(i, j - 1, k)].getBlockTextureFromSideAndMetadata(6, iblockaccess.getBlockMetadata(i, j - 1, k));
        }
        else
        {
            return 0;
        }
    }
    
    @Override
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if ((i1 & 8) != 0)
        {
            if (world.getBlockId(i, j - 1, k) != blockID)
            {
                world.setBlockWithNotify(i, j, k, 0);
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
                world.setBlockWithNotify(i, j, k, 0);
            }
            if (!world.isBlockNormalCube(i, j - 1, k))
            {
                world.setBlockWithNotify(i, j, k, 0);
                flag = true;
                if (world.getBlockId(i, j + 1, k) == blockID)
                {
                    world.setBlockWithNotify(i, j + 1, k, 0);
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
    }
    
    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return blockIndexInTexture;
    }
    
    @Override
    public int idDropped(int i, Random random, int j)
    {
        return mod_HiddenDoors.itemDoor.itemID;
    }
}
