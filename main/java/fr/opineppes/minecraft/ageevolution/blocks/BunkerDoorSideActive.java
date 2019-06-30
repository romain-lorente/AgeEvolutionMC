package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorClosedShapes;
import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorSideShapes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory.Builder;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BunkerDoorSideActive extends BunkerDoorActive {
	
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_TOP;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_BOTTOM;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_SIDE;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_CLOSED;
	public static final EnumProperty<Type> TYPE;
	
	public BunkerDoorSideActive(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH).with(TYPE, Type.BOTTOM).with(CLOSED, false));
	}

	@Override
	public VoxelShape getNonClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
			EntityContext entityContext_1) {
		return blockState_1.get(TYPE).getShape(blockState_1.get(FACING));
	}
	
	@Override
	public VoxelShape getClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
			EntityContext entityContext_1) {
		return BOUNDING_SHAPES_CLOSED.get(blockState_1.get(FACING));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		Direction direction = itemPlacementContext_1.getSide();
		
		BlockState state = this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
		return direction == Direction.UP ? state : direction == Direction.DOWN ? state.with(TYPE, Type.TOP) : state.with(TYPE, Type.SIDE);
	}
	
	@Override
	public void appendOtherProperties(Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(TYPE);
	}

	static {
		BOUNDING_SHAPES_TOP = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorSideShapes.Z_TOP, Direction.EAST, BunkerDoorSideShapes.X_TOP, Direction.SOUTH, BunkerDoorSideShapes.Z_TOP, Direction.WEST, BunkerDoorSideShapes.X_TOP));
		BOUNDING_SHAPES_BOTTOM = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorSideShapes.Z_BOTTOM, Direction.EAST, BunkerDoorSideShapes.X_BOTTOM, Direction.SOUTH, BunkerDoorSideShapes.Z_BOTTOM, Direction.WEST, BunkerDoorSideShapes.X_BOTTOM));
		BOUNDING_SHAPES_SIDE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorSideShapes.NORTH_SIDE, Direction.EAST, BunkerDoorSideShapes.EAST_SIDE, Direction.SOUTH, BunkerDoorSideShapes.SOUTH_SIDE, Direction.WEST, BunkerDoorSideShapes.WEST_SIDE));
		BOUNDING_SHAPES_CLOSED = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorClosedShapes.X, Direction.EAST, BunkerDoorClosedShapes.Z, Direction.SOUTH, BunkerDoorClosedShapes.X, Direction.WEST, BunkerDoorClosedShapes.Z));
		TYPE = EnumProperty.of("type", Type.class);
	}
	
	public static enum Type implements StringIdentifiable
	{
		TOP("top", BOUNDING_SHAPES_TOP),
		BOTTOM("bottom", BOUNDING_SHAPES_BOTTOM),
		SIDE("side", BOUNDING_SHAPES_SIDE);
		
		private String id;
		private Map<Direction, VoxelShape> shapes;
		
		Type(String id, Map<Direction, VoxelShape> shapes) {
			this.id = id;
			this.shapes = shapes;
		}
		
		public VoxelShape getShape(Direction direction)
		{
			return shapes.get(direction);
		}

		@Override
		public String asString() {
			return id;
		}
	}
}
