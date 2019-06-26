package fr.opineppes.minecraft.ageevolution.blocks;

import com.google.common.collect.Lists;

import java.util.List;

import fr.opineppes.minecraft.ageevolution.shapes.CeilingLightBarsShapes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
public class CeilingLightBars extends Block {
	
	public static final EnumProperty<Orientation> ORIENT;
	
	public CeilingLightBars(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.getDefaultState().with(ORIENT, Orientation.X));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		return (BlockState)this.getDefaultState().with(ORIENT, Orientation.getOrientation(itemPlacementContext_1.getPlayerFacing().getOpposite()));
	}
	
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		return blockState_1.get(ORIENT).getShape();
	}
	
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(ORIENT);
	}
	
	static {
		ORIENT = EnumProperty.of("orient", Orientation.class);
	}
	
	public static enum Orientation implements StringIdentifiable
	{
		X("x", Lists.newArrayList(Direction.EAST, Direction.WEST), CeilingLightBarsShapes.SHAPE_X),
		Z("z", Lists.newArrayList(Direction.NORTH, Direction.SOUTH), CeilingLightBarsShapes.SHAPE_Z);
		
		private String value;
		private List<Direction> directions;
		private VoxelShape shape;
		
		Orientation(String value, List<Direction> directions, VoxelShape shape)
		{
			this.value = value;
			this.directions = directions;
			this.shape = shape;
		}
		
		public VoxelShape getShape()
		{
			return shape;
		}

		@Override
		public String asString() {
			return value;
		}
		
		public static Orientation getOrientation(Direction dir)
		{
			for(Orientation orientation : values())
			{
				if(orientation.directions.contains(dir))
				{
					return orientation;
				}
			}
			return null;
		}
	}

}
