package fr.opineppes.minecraft.ageevolution.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionBlocks;
import fr.opineppes.minecraft.ageevolution.shapes.SchoolChairShapes;
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
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SchoolChair extends HorizontalFacingBlock {
	public static final Map<Direction, VoxelShape> BOUNDING_SHAPES;
	
	public SchoolChair(Settings block$Settings_1) {
		super(block$Settings_1);
		this.setDefaultState((BlockState)((BlockState)this.stateFactory.getDefaultState()).with(FACING, Direction.NORTH));
	}
	
	public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
		BlockPos faceBlockPos = blockPos_1.offset(blockState_1.get(FACING));
		BlockState faceBlock = world_1.getBlockState(faceBlockPos);
		if(faceBlock.getBlock() == AgeEvolutionBlocks.SCHOOL_TABLE && !faceBlock.get(SchoolTable.WITH_CHAIR))
		{
			BlockState newBlockState = faceBlock.with(SchoolTable.WITH_CHAIR, true);
			world_1.setBlockState(faceBlockPos, newBlockState);
			
			world_1.setBlockState(blockPos_1, Blocks.AIR.getDefaultState());
			return true;
		}
		return false;
	}
	
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		return BOUNDING_SHAPES.get(blockState_1.get(FACING));
	}
	
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		return (BlockState)this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
	}
	
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT_MIPPED;
	   }
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}
	
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(FACING);
	}
	
	static {
	    BOUNDING_SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, SchoolChairShapes.NORTH, Direction.EAST, SchoolChairShapes.EAST, Direction.SOUTH, SchoolChairShapes.SOUTH, Direction.WEST, SchoolChairShapes.WEST));
	}

}
