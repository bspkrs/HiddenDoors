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
        disableStats();
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
    
    @Override
    public int idDropped(int i, Random random, int j)
    {
        return (i & 8) != 0 ? 0 : (blockMaterial == Material.iron
                ? HiddenDoors.itemHiddenDoorIron.itemID
                : HiddenDoors.itemHiddenDoorWood.itemID);
    }
}
