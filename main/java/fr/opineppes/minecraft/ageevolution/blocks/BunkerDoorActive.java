package fr.opineppes.minecraft.ageevolution.blocks;


import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public abstract class BunkerDoorActive extends HorizontalFacingBlock implements BlockEntityProvider {

	public static final BooleanProperty CLOSED;
	
	protected BunkerDoorActive(Settings block$Settings_1) {
		super(block$Settings_1);
	}
	
	public abstract VoxelShape getNonClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1);
	public abstract VoxelShape getClosedOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1);
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
		if(blockState_1.get(CLOSED))
			return getClosedOutlineShape(blockState_1, blockView_1, blockPos_1, entityContext_1);
		
		return getNonClosedOutlineShape(blockState_1, blockView_1, blockPos_1, entityContext_1);
	}
	
	public abstract void appendOtherProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1);
	protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
		stateFactory$Builder_1.add(CLOSED, FACING);
		appendOtherProperties(stateFactory$Builder_1);
	}
	
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT_MIPPED;
	   }
	
	public BlockRenderType getRenderType(BlockState blockState_1) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockView var1) {
		return new BunkerDoorBlockEntity();
	}
	
	static {
		CLOSED = BooleanProperty.of("closed");
	}
}
