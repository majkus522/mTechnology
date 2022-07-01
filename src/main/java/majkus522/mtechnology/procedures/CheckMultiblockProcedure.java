package majkus522.mtechnology.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckMultiblockProcedure
{
	public static boolean execute(LevelAccessor world, double x, double y, double z, Block[][][] multiblock, BlockPos offset) 
	{
		for (int posY = 0; posY < multiblock.length; posY++) 
		{
			for (int posZ = 0; posZ < multiblock[posY].length; posZ++) 
			{
				for (int posX = 0; posX < multiblock[posY][posZ].length; posX++) 
				{
					if (world.getBlockState(new BlockPos(x + posX + offset.getX(), y + posY + offset.getY(), z + posZ + offset.getZ())) != multiblock[posY][posZ][posX].defaultBlockState())
						return false;
				}
			}
		}
		return true;
	}
}
