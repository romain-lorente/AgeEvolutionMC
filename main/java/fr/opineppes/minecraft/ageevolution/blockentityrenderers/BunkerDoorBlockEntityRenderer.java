package fr.opineppes.minecraft.ageevolution.blockentityrenderers;

import com.mojang.blaze3d.platform.GlStateManager;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionBlocks;
import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorModel;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerActive;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorSideActive;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorSideDeco;
import fr.opineppes.minecraft.ageevolution.utils.HorizontalAxis;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3i;

public class BunkerDoorBlockEntityRenderer extends BlockEntityRenderer<BunkerDoorBlockEntity> {
	
	private static final Identifier NORMAL_TEX = new Identifier("ageevolution", "textures/block/bunker_lightgray.png");
	private final BunkerDoorModel bunkerDoorModel = new BunkerDoorModel();

	public void render(BunkerDoorBlockEntity blockEntity_1, double double_1, double double_2, double double_3, float float_1, int int_1) {
    	
		GlStateManager.enableDepthTest();
    	GlStateManager.depthFunc(515);
    	GlStateManager.depthMask(true);
	      
    	this.bindTexture(NORMAL_TEX);
    		
    	GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GlStateManager.pushMatrix();
    	GlStateManager.enableRescaleNormal();

    	GlStateManager.translatef((float) double_1, (float) double_2, (float) double_3);
    	
    	float progress = blockEntity_1.getAnimationProgress(float_1);
    	float translation = progress <= 8 ? progress : 8;
    	float rotation = progress > 8 ? progress <= 53 ? progress - 8 : 45 : 0;
    	applyDoorAnimation(blockEntity_1, translation, rotation);
    	
		BlockState blockState_1 = blockEntity_1.hasWorld() ? blockEntity_1.getCachedState() : null;
		if(blockState_1 != null)
		{
	    	Direction direction = blockEntity_1.getDirection();
			float yAxis = direction != null ? direction.asRotation() : 0;
			
			applyRotation(yAxis, blockState_1);
			renderPart(blockState_1);
		}
		 
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		
	}
	
	private void applyDoorAnimation(BunkerDoorBlockEntity entity, float position, float rotation)
	{
		BlockPos doorPosition = entity.getDoorPosition();
		BlockPos thisPosition = entity.getPos();
		Direction direction = entity.getDirection();
		Vec2f size = entity.getSize();
		
		if(doorPosition != null && direction != null && size != null)
		{
			Vec3i offsets = thisPosition.subtract(doorPosition);
			HorizontalAxis axis = HorizontalAxis.fromPerpendDirection(direction);
			float xRot = axis.getOffsetX() * -direction.getDirection().offset();
			float zRot = axis.getOffsetZ() * direction.getDirection().offset();
			
			float xPos = 0.0625F * position * direction.getOffsetX();
			float zPos = 0.0625F * position * direction.getOffsetZ();
			
			GlStateManager.translatef(xPos, 0.0F, zPos);
			
			GlStateManager.translatef(-offsets.getX(), -offsets.getY() + size.y - 1, -offsets.getZ());
			GlStateManager.translatef(0.5F, 0.5F, 0.5F);
			GlStateManager.rotatef((float) rotation * 2.0F, xRot, 0.0F, zRot);
			GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
			GlStateManager.translatef(offsets.getX(), offsets.getY() - size.y + 1, offsets.getZ());
		}
		
	}
	
	private void renderPart(BlockState state)
	{
		Block block = state.getBlock();

		if(block == AgeEvolutionBlocks.BUNKER_DOOR_BARRIER)
		{
			bunkerDoorModel.renderCenter();
		}
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_SIDE_ACTIVE)
		{
			bunkerDoorModel.renderSide();
		}
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_CORNER_ACTIVE)
		{
			bunkerDoorModel.renderCorner();
		}
	}
	
	private void applyRotation(float yAxis, BlockState state)
	{
	    GlStateManager.translatef(0.5F, 0.5F, 0.5F);
	    
		Block block = state.getBlock();
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_SIDE_ACTIVE)
		{
			BunkerDoorSideDeco.Type type = state.get(BunkerDoorSideActive.TYPE);
			if(type == BunkerDoorSideDeco.Type.TOP)
			{
		    	GlStateManager.rotatef(180F, 0.0F, 0.0F, 1.0F);
			}
			if(type == BunkerDoorSideDeco.Type.SIDE)
			{
				Direction direction = state.get(BunkerDoorSideActive.FACING);
				if(direction == Direction.NORTH)
					GlStateManager.rotatef(-90F, 1.0F, 0.0F, 0.0F);
				if(direction == Direction.SOUTH)
					GlStateManager.rotatef(90F, 1.0F, 0.0F, 0.0F);
				if(direction == Direction.EAST)
					GlStateManager.rotatef(-90F, 0.0F, 0.0F, 1.0F);
				if(direction == Direction.WEST)
					GlStateManager.rotatef(90F, 0.0F, 0.0F, 1.0F);
			}
			
			if ((double)Math.abs(yAxis) > 1.0E-5D) {
			    GlStateManager.rotatef(yAxis, 0.0F, 1.0F, 0.0F);
			}
		}
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_BARRIER)
		{
			if ((double)Math.abs(yAxis) > 1.0E-5D) {
			    GlStateManager.rotatef(yAxis, 0.0F, 1.0F, 0.0F);
			}
		}
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_CORNER_ACTIVE)
		{
			BunkerDoorCornerDeco.Type type = state.get(BunkerDoorCornerActive.TYPE);
			Direction direction = state.get(BunkerDoorSideActive.FACING);
			if(type == BunkerDoorCornerDeco.Type.TOP)
			{
				if(direction == Direction.NORTH || direction == Direction.SOUTH )
					GlStateManager.rotatef(-90F * direction.getOffsetZ(), 0.0F, 1.0F, 0.0F);
				if(direction == Direction.WEST )
					GlStateManager.rotatef(-180F, 0.0F, 1.0F, 0.0F);
			}
			if(type == BunkerDoorCornerDeco.Type.BOTTOM)
			{
				if(direction == Direction.NORTH || direction == Direction.SOUTH )
					GlStateManager.rotatef(180F, 0.0F, 0.0F, 1.0F);
					GlStateManager.rotatef(-90F * direction.getOffsetZ(), 0.0F, 1.0F, 0.0F);
				if(direction == Direction.WEST || direction == Direction.EAST)
					GlStateManager.rotatef(180F, 1.0F, 0.0F, 0.0F);
				if(direction == Direction.WEST )
					GlStateManager.rotatef(-180F, 0.0F, 1.0F, 0.0F);
			}
		}
		
    	GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
	}
	
}
