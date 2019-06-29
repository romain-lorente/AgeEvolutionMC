package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorClosedShapes;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BunkerDoorSideActive extends BunkerDoorSideDeco implements BunkerDoor, BlockEntityProvider {

	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_CLOSED;
	
	public BunkerDoorSideActive(Settings block$Settings_1) {
		super(block$Settings_1);
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		BlockEntity entity = blockView_1.getBlockEntity(blockPos_1);
		if(entity instanceof BunkerDoorBlockEntity)
		{
			BunkerDoorBlockEntity door = (BunkerDoorBlockEntity) entity;
			
			if(door.isClosed())
				return BOUNDING_SHAPES_CLOSED.get(blockState_1.get(FACING));
		}
		
		return blockState_1.get(TYPE).getShape(blockState_1.get(FACING));
	}

	@Override
	public BlockEntity createBlockEntity(BlockView var1) {
		return new BunkerDoorBlockEntity();
	}
	
	static {
		BOUNDING_SHAPES_CLOSED = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorClosedShapes.Z, Direction.EAST, BunkerDoorClosedShapes.X, Direction.SOUTH, BunkerDoorClosedShapes.Z, Direction.WEST, BunkerDoorClosedShapes.X));
	}
	
}
