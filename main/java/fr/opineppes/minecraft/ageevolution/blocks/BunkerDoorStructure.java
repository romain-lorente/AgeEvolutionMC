package fr.opineppes.minecraft.ageevolution.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public interface BunkerDoorStructure {

	Direction getPrevDirection(BlockState blockState);
	Direction getNextDirection(BlockState blockState);
	Orientation getOrientation(BlockState blockState);
	
	public static enum Orientation
	{
		X,
		Z;
	}
}
