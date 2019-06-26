package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionBlocks;
import fr.opineppes.minecraft.ageevolution.shapes.SchoolTableShapes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SchoolTable extends HorizontalFacingBlock {
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES;
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES_WITH_CHAIR;
	public static final BooleanProperty WITH_CHAIR;
	
	public SchoolTable(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState((BlockState)((BlockState)this.stateFactory.getDefaultState()).with(FACING, Direction.NORTH));
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		if(blockState_1.get(WITH_CHAIR))
		{
			return BOUNDING_SHAPES_WITH_CHAIR.get(blockState_1.get(FACING));
		}
		else
		{
			return BOUNDING_SHAPES.get(blockState_1.get(FACING));
		}
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		return (BlockState)this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite()).with(WITH_CHAIR, false);
	}
	
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}
	
	public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
		BlockPos faceBlockPos = blockPos_1.offset(blockState_1.get(FACING));
		BlockState faceBlock = world_1.getBlockState(faceBlockPos);
		if(faceBlock.getBlock() == Blocks.AIR && blockState_1.get(WITH_CHAIR))
		{
			Direction faceBlockDirection = blockState_1.get(FACING).getOpposite();
			BlockState chairBlockState = AgeEvolutionBlocks.SCHOOL_CHAIR.getDefaultState();
			world_1.setBlockState(faceBlockPos, chairBlockState.with(SchoolChair.FACING, faceBlockDirection));
			
			BlockState newBlockState = blockState_1.with(SchoolTable.WITH_CHAIR, false);
			world_1.setBlockState(blockPos_1, newBlockState);
			return true;
		}
		return false;
	}
	
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(FACING, WITH_CHAIR);
	}
	
	static {
		WITH_CHAIR = BooleanProperty.of("with_chair");
	    BOUNDING_SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, SchoolTableShapes.NORTH, Direction.EAST, SchoolTableShapes.EAST, Direction.SOUTH, SchoolTableShapes.SOUTH, Direction.WEST, SchoolTableShapes.WEST));
	    BOUNDING_SHAPES_WITH_CHAIR = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, SchoolTableShapes.NORTH_WITH_CHAIR, Direction.EAST, SchoolTableShapes.EAST_WITH_CHAIR, Direction.SOUTH, SchoolTableShapes.SOUTH_WITH_CHAIR, Direction.WEST, SchoolTableShapes.WEST_WITH_CHAIR));
	}

}
