package fr.opineppes.minecraft.ageevolution.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class BlockPosUtils {
	
	public static Vec3i getDistance(BlockPos pos1, BlockPos pos2)
	{
		int distanceX = Math.abs(pos1.getX() - pos2.getX());
		int distanceY = Math.abs(pos1.getY() - pos2.getY());
		int distanceZ = Math.abs(pos1.getZ() - pos2.getZ());
		
		return new Vec3i(distanceX, distanceY, distanceZ);
	}

}
