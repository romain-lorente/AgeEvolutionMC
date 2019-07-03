package fr.opineppes.minecraft.ageevolution.blocks;

import fr.opineppes.minecraft.ageevolution.utils.HorizontalAxis;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public interface BunkerDoorStructure {

	Direction getPrevDirection(BlockState blockState);
	Direction getNextDirection(BlockState blockState);
	HorizontalAxis getAxis(BlockState blockState);
}
