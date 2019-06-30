package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorSideShapes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BunkerDoorSideDeco extends HorizontalFacingBlock implements BunkerDoorStructure {
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_TOP;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_BOTTOM;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_SIDE;
	public static final EnumProperty<Type> TYPE;
	
	public BunkerDoorSideDeco(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH).with(TYPE, Type.BOTTOM));
	}
	
	@Override
	public Direction getPrevDirection(BlockState blockState) {
		Direction facing = blockState.get(FACING);
		Type type = blockState.get(TYPE);
		
		switch(type)
		{
		case TOP:
			switch(facing)
			{
			case SOUTH:
			case NORTH:
				return Direction.EAST;
			case EAST:
			case WEST:
				return Direction.SOUTH;
			default:
				return facing;
			}
		case BOTTOM:
			switch(facing)
			{
			case SOUTH:
			case NORTH:
				return Direction.WEST;
			case EAST:
			case WEST:
				return Direction.NORTH;
			default:
				return facing;
			}
		case SIDE:
			switch(facing)
			{
			case NORTH:
			case WEST:
				return Direction.DOWN;
			case SOUTH:
			case EAST:
				return Direction.UP;
			default:
				return facing;
			}
		default:
			return null;
		}
	}
	
	@Override
	public Direction getNextDirection(BlockState blockState) {
		Direction facing = blockState.get(FACING);
		Type type = blockState.get(TYPE);
		
		switch(type)
		{
		case TOP:
			switch(facing)
			{
			case SOUTH:
			case NORTH:
				return Direction.WEST;
			case EAST:
			case WEST:
				return Direction.NORTH;
			default:
				return facing;
			}
		case BOTTOM:
			switch(facing)
			{
			case SOUTH:
			case NORTH:
				return Direction.EAST;
			case EAST:
			case WEST:
				return Direction.SOUTH;
			default:
				return facing;
			}
		case SIDE:
			switch(facing)
			{
			case NORTH:
			case WEST:
				return Direction.UP;
			case SOUTH:
			case EAST:
				return Direction.DOWN;
			default:
				return facing;
			}
		default:
			return null;
		}
	}

	@Override
	public Orientation getOrientation(BlockState blockState) {
		Direction facing = blockState.get(FACING);
		Type type = blockState.get(TYPE);
		
		switch(type)
		{
		case TOP:
		case BOTTOM:
			switch(facing)
			{
			case NORTH:
			case SOUTH:
				return Orientation.X;
			case WEST:
			case EAST:
				return Orientation.Z;
			default:
				return null;
			}
		case SIDE:
			switch(facing)
			{
			case NORTH:
			case SOUTH:
				return Orientation.Z;
			case WEST:
			case EAST:
				return Orientation.X;
			default:
				return null;
			}
		default:
			return null;
		}
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		return blockState_1.get(TYPE).getShape(blockState_1.get(FACING));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		Direction direction = itemPlacementContext_1.getSide();
		
		BlockState state = this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
		return direction == Direction.UP ? state : direction == Direction.DOWN ? state.with(TYPE, Type.TOP) : state.with(TYPE, Type.SIDE);
	}
	
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT_MIPPED;
	   }
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}
	
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(FACING, TYPE);
	}

	static {
		BOUNDING_SHAPES_TOP = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorSideShapes.Z_TOP, Direction.EAST, BunkerDoorSideShapes.X_TOP, Direction.SOUTH, BunkerDoorSideShapes.Z_TOP, Direction.WEST, BunkerDoorSideShapes.X_TOP));
		BOUNDING_SHAPES_BOTTOM = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorSideShapes.Z_BOTTOM, Direction.EAST, BunkerDoorSideShapes.X_BOTTOM, Direction.SOUTH, BunkerDoorSideShapes.Z_BOTTOM, Direction.WEST, BunkerDoorSideShapes.X_BOTTOM));
		BOUNDING_SHAPES_SIDE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorSideShapes.NORTH_SIDE, Direction.EAST, BunkerDoorSideShapes.EAST_SIDE, Direction.SOUTH, BunkerDoorSideShapes.SOUTH_SIDE, Direction.WEST, BunkerDoorSideShapes.WEST_SIDE));
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
