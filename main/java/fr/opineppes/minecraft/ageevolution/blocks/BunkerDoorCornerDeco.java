package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.shapes.BunkerDoorCornerShapes;
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

public class BunkerDoorCornerDeco extends HorizontalFacingBlock implements BunkerDoor {
	
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_TOP;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_BOTTOM;
	public static final EnumProperty<Type> TYPE;

	public BunkerDoorCornerDeco(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH).with(TYPE, Type.BOTTOM));
	}

	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		return blockState_1.get(TYPE).getShape(blockState_1.get(FACING));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		Direction direction = itemPlacementContext_1.getSide();
		double hitY = itemPlacementContext_1.getHitPos().y - itemPlacementContext_1.getBlockPos().getY();
		
		BlockState state = this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
		return direction != Direction.UP && (direction == Direction.DOWN ||  hitY >= 0.5D) ? state.with(TYPE, Type.TOP) : state;
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
		BOUNDING_SHAPES_TOP = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorCornerShapes.TOP_NORTH, Direction.EAST, BunkerDoorCornerShapes.TOP_EAST, Direction.SOUTH, BunkerDoorCornerShapes.TOP_SOUTH, Direction.WEST, BunkerDoorCornerShapes.TOP_WEST));
		BOUNDING_SHAPES_BOTTOM = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, BunkerDoorCornerShapes.BOTTOM_NORTH, Direction.EAST, BunkerDoorCornerShapes.BOTTOM_EAST, Direction.SOUTH, BunkerDoorCornerShapes.BOTTOM_SOUTH, Direction.WEST, BunkerDoorCornerShapes.BOTTOM_WEST));
		TYPE = EnumProperty.of("type", Type.class);
	}

	public static enum Type implements StringIdentifiable
	{
		TOP("top", BOUNDING_SHAPES_TOP),
		BOTTOM("bottom", BOUNDING_SHAPES_BOTTOM);
		
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
