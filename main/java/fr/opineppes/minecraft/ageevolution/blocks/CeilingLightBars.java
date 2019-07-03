package fr.opineppes.minecraft.ageevolution.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

import fr.opineppes.minecraft.ageevolution.shapes.CeilingLightBarsShapes;
import fr.opineppes.minecraft.ageevolution.utils.HorizontalAxis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CeilingLightBars extends Block {
	
	public static final Map<HorizontalAxis, VoxelShape> BOUNDING_SHAPES;
	public static final EnumProperty<HorizontalAxis> ORIENT;
	
	public CeilingLightBars(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState(this.getDefaultState().with(ORIENT, HorizontalAxis.X));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		return (BlockState)this.getDefaultState().with(ORIENT, HorizontalAxis.fromDirection(itemPlacementContext_1.getPlayerFacing().getOpposite()));
	}
	
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		return BOUNDING_SHAPES.get(blockState_1.get(ORIENT));
	}
	
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(ORIENT);
	}
	
	static {
		BOUNDING_SHAPES = Maps.newEnumMap(ImmutableMap.of(HorizontalAxis.X, CeilingLightBarsShapes.SHAPE_X, HorizontalAxis.Z, CeilingLightBarsShapes.SHAPE_Z));
		ORIENT = EnumProperty.of("orient", HorizontalAxis.class);
	}
}
