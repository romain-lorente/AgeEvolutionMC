package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.shapes.FireExtinguisherShapes;
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

public class FireExtinguisher extends HorizontalFacingBlock {

	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_WALL;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_GROUND;
	public static final EnumProperty<Type> TYPE;
	
	public FireExtinguisher(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH).with(TYPE, Type.GROUND));
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		return blockState_1.get(TYPE).getShape(blockState_1.get(FACING));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		boolean flag = itemPlacementContext_1.getSide() == Direction.UP || itemPlacementContext_1.getSide() == Direction.DOWN;
		return this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite()).with(TYPE, flag ? Type.GROUND : Type.WALL);
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
		BOUNDING_SHAPES_GROUND = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, FireExtinguisherShapes.NORTH_GROUND, Direction.EAST, FireExtinguisherShapes.EAST_GROUND, Direction.SOUTH, FireExtinguisherShapes.SOUTH_GROUND, Direction.WEST, FireExtinguisherShapes.WEST_GROUND));
		BOUNDING_SHAPES_WALL = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, FireExtinguisherShapes.NORTH_WALL, Direction.EAST, FireExtinguisherShapes.EAST_WALL, Direction.SOUTH, FireExtinguisherShapes.SOUTH_WALL, Direction.WEST, FireExtinguisherShapes.WEST_WALL));
		TYPE = EnumProperty.of("type", Type.class);
	}
	
	public static enum Type implements StringIdentifiable {
		GROUND("ground", BOUNDING_SHAPES_GROUND),
		WALL("wall", BOUNDING_SHAPES_WALL);
		
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
