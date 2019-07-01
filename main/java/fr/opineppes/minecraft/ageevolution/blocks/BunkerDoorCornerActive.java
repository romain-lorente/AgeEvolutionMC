package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco.Type;
import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorClosedShapes;
import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorCornerShapes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory.Builder;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BunkerDoorCornerActive extends BunkerDoorActive {

	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_TOP;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_BOTTOM;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_CLOSED;
	public static final EnumProperty<Type> TYPE;

	public BunkerDoorCornerActive(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH).with(TYPE, Type.BOTTOM).with(CLOSED, false));
	}

	@Override
	public VoxelShape getClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
			EntityContext entityContext_1) {
		return BOUNDING_SHAPES_CLOSED.get(blockState_1.get(FACING));
	}

	@Override
	public VoxelShape getNonClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
			EntityContext entityContext_1) {
		return blockState_1.get(TYPE).getShape(blockState_1.get(FACING));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		Direction direction = itemPlacementContext_1.getSide();
		double hitY = itemPlacementContext_1.getHitPos().y - itemPlacementContext_1.getBlockPos().getY();
		
		BlockState state = this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
		return direction != Direction.UP && (direction == Direction.DOWN ||  hitY >= 0.5D) ? state.with(TYPE, Type.TOP) : state;
	}

	@Override
	public void appendOtherProperties(Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(TYPE);
	}
	
	static {
		BOUNDING_SHAPES_TOP = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorCornerShapes.TOP_NORTH, Direction.EAST, BunkerDoorCornerShapes.TOP_EAST, Direction.SOUTH, BunkerDoorCornerShapes.TOP_SOUTH, Direction.WEST, BunkerDoorCornerShapes.TOP_WEST));
		BOUNDING_SHAPES_BOTTOM = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorCornerShapes.BOTTOM_NORTH, Direction.EAST, BunkerDoorCornerShapes.BOTTOM_EAST, Direction.SOUTH, BunkerDoorCornerShapes.BOTTOM_SOUTH, Direction.WEST, BunkerDoorCornerShapes.BOTTOM_WEST));
		BOUNDING_SHAPES_CLOSED = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorClosedShapes.Z, Direction.EAST, BunkerDoorClosedShapes.X, Direction.SOUTH, BunkerDoorClosedShapes.Z, Direction.WEST, BunkerDoorClosedShapes.X));
		TYPE = EnumProperty.of("type", Type.class);
	}
	
}
