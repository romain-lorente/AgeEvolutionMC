package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorClosedShapes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.state.StateFactory.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BunkerDoorBarrier extends BunkerDoorActive {

	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_CLOSED;
	
	public BunkerDoorBarrier(Settings block$Settings_1) {
		super(block$Settings_1);
	}
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}

	@Override
	public VoxelShape getNonClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
			EntityContext entityContext_1) {
		return VoxelShapes.empty();
	}

	@Override
	public VoxelShape getClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
			EntityContext entityContext_1) {
		return BOUNDING_SHAPES_CLOSED.get(blockState_1.get(FACING));
	}

	@Override
	public void appendOtherProperties(Builder<Block, BlockState> stateFactory$Builder_1) {
	}
	
	static {
		BOUNDING_SHAPES_CLOSED = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorClosedShapes.X, Direction.EAST, BunkerDoorClosedShapes.Z, Direction.SOUTH, BunkerDoorClosedShapes.X, Direction.WEST, BunkerDoorClosedShapes.Z));
	}

}
