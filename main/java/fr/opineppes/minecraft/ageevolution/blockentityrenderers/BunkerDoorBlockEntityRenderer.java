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
import fr.opineppes.minecraft.ageevolution.utils.BlockPosUtils;
import fr.opineppes.minecraft.ageevolution.utils.HorizontalAxis;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3i;

public class BunkerDoorBlockEntityRenderer extends BlockEntityRenderer<BunkerDoorBlockEntity> {
	
	private static final Identifier DOOR_TEX = new Identifier("ageevolution", "textures/block/bunker_door_door_dark.png");
	private static final Identifier VALVE_TEX = new Identifier("ageevolution", "textures/block/bunker_door_door_valve.png");
	private final BunkerDoorModel bunkerDoorModel = new BunkerDoorModel();
	
	float animation = 0;

	public void render(BunkerDoorBlockEntity blockEntity_1, double double_1, double double_2, double double_3, float float_1, int int_1) {
    	
		GlStateManager.enableDepthTest();
    	GlStateManager.depthFunc(515);
    	GlStateManager.depthMask(true);

    	GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GlStateManager.pushMatrix();
    	GlStateManager.enableRescaleNormal();

    	GlStateManager.translatef((float) double_1, (float) double_2 + 1.0F, (float) double_3 + 1.0F);
    	GlStateManager.scalef(1.0F, -1.0F, -1.0F);
    	
    	//Gestion de la progression de l'animation
		BlockPos thisPosition = blockEntity_1.getPos();
		BlockPos doorPosition = blockEntity_1.getDoorPosition();
		
		Direction direction = blockEntity_1.getDirection();
		HorizontalAxis axis = HorizontalAxis.fromDirection(direction);
		Vec2f size = blockEntity_1.getSize();
		
		BlockState blockState_1 = blockEntity_1.hasWorld() ? blockEntity_1.getCachedState() : null;
		
    	float progress = blockEntity_1.getAnimationProgress(float_1);
		
		if(doorPosition != null && direction != null && size != null && blockState_1 != null)
		{
	    	float translation = progress <= 8 ? progress : 8;
	    	float rotation = progress > 8 ? progress <= 53 ? progress - 8 : 45 : 0;
	    	applyDoorTopAnimation(thisPosition, doorPosition, direction, size, translation, rotation);
	    	
	    	renderDoor(direction, axis, blockState_1);
	    	renderValve(thisPosition, doorPosition, direction, axis, size);
		}
		 
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		
	}
	
	//Application des animations
	private void applyDoorTopAnimation(BlockPos blockPosition, BlockPos doorPosition, Direction direction, Vec2f size, float position, float rotation)
	{
		Vec3i offsets = blockPosition.subtract(doorPosition);
		HorizontalAxis axis = HorizontalAxis.fromPerpendDirection(direction);
		float xRot = axis.getOffsetX() * -direction.getDirection().offset();
		float zRot = axis.getOffsetZ() * -direction.getDirection().offset();
		
		float xPos = 0.0625F * (position / 2) * direction.getOffsetX();
		float zPos = 0.0625F * (position / 2) * -direction.getOffsetZ();

		GlStateManager.translatef(xPos - offsets.getX() + 0.5F, offsets.getY() + 0.25F - size.y + 1, zPos + offsets.getZ() + 0.5F);
		GlStateManager.rotatef((float) rotation * 2.0F, xRot, 0.0F, zRot);
		GlStateManager.translatef(offsets.getX() - 0.5F, -offsets.getY() - 0.25F + size.y - 1, -offsets.getZ() - 0.5F);
	}
	
	//Affichage du verrou
	private void renderValve(BlockPos blockPosition, BlockPos doorPosition, Direction direction, HorizontalAxis axis, Vec2f size)
	{
		Vec3i distance = BlockPosUtils.getDistance(blockPosition, doorPosition);
		
		float horizontalPosValve = size.x / 2F;
		float verticalPosValve = size.y / 2F;
		
		int horizontalBlock = axis == HorizontalAxis.X ? distance.getZ() : distance.getX();
		int verticalBlock = distance.getY();
		
		float horizontalOffset = horizontalPosValve - MathHelper.floor(horizontalPosValve);
		float verticalOffset = verticalPosValve - MathHelper.floor(verticalPosValve);
		animation += 0.01;
		
		GlStateManager.pushMatrix();
		applyValveRotation(direction, axis, horizontalOffset, verticalOffset);
		renderValveModel(axis, horizontalPosValve, verticalPosValve, horizontalBlock, verticalBlock, horizontalOffset, verticalOffset);
		GlStateManager.popMatrix();
	}
	
	private void applyValveRotation(Direction direction, HorizontalAxis axis, float horizontalOffset, float verticalOffset)
	{
		GlStateManager.translatef((-0.5F + horizontalOffset) * axis.getOffsetZ(), 0.5F - verticalOffset, (0.5F - horizontalOffset) * axis.getOffsetX());
		
		GlStateManager.translatef(0.5F, 0.5F, 0.5F);
		GlStateManager.rotatef(animation % 360, axis.getOffsetX(), 0.0F, axis.getOffsetZ());
		float yAxis = direction != null ? direction.asRotation() : 0;
		if ((double)Math.abs(yAxis) > 1.0E-5D) {
		    GlStateManager.rotatef(yAxis, 0.0F, 1.0F, 0.0F);
		}
		GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
	}
	
	private void renderValveModel(HorizontalAxis axis, float horizontalPosValve, float verticalPosValve, int horizontalBlock, int verticalBlock, float horizontalOffset, float verticalOffset)
	{
		if(horizontalBlock + horizontalOffset == horizontalPosValve && verticalBlock + verticalOffset == verticalPosValve)
		{
			this.bindTexture(VALVE_TEX);
			bunkerDoorModel.renderValve();
			GlStateManager.translatef(0.5F, 0.5F, 0.5F);
			GlStateManager.rotatef(180F, 0.0F, 1.0F, 0.0F);
			GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
			bunkerDoorModel.renderValve();
		}
	}

	//Affichage de la porte
	private void renderDoor(Direction direction, HorizontalAxis axis, BlockState state)
	{
    	GlStateManager.pushMatrix();
		applyDoorRotation(direction, axis, state);
		renderDoorPart(state);
    	GlStateManager.popMatrix();
	}
	
	private void applyDoorRotation(Direction direction, HorizontalAxis axis, BlockState state)
	{
	    GlStateManager.translatef(0.5F, 0.5F, 0.5F);
	    
		Block block = state.getBlock();
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_SIDE_ACTIVE)
		{
			BunkerDoorSideDeco.Type type = state.get(BunkerDoorSideActive.TYPE);
			if(type == BunkerDoorSideDeco.Type.BOTTOM)
			{
		    	GlStateManager.rotatef(180F, axis.getOffsetX(), 0.0F, axis.getOffsetZ());
			}
			if(type == BunkerDoorSideDeco.Type.SIDE)
			{
				Direction directionState = state.get(BunkerDoorSideActive.FACING);
				GlStateManager.rotatef(90F * -directionState.getDirection().offset(), axis.getOffsetX(), 0.0F, axis.getOffsetZ());
			}
		}
		if(block == AgeEvolutionBlocks.BUNKER_DOOR_CORNER_ACTIVE)
		{
			BunkerDoorCornerDeco.Type type = state.get(BunkerDoorCornerActive.TYPE);
			Direction directionState = state.get(BunkerDoorCornerActive.FACING);
			if(type == BunkerDoorCornerDeco.Type.TOP)
			{
				GlStateManager.rotatef(90F * directionState.getDirection().offset(), axis.getOffsetX(), 0.0F, axis.getOffsetZ());
			}
			
			boolean flag1 = direction == Direction.EAST && directionState == Direction.SOUTH;
			boolean flag2 = direction == Direction.SOUTH && directionState == Direction.WEST;
			boolean flag3 = direction == Direction.WEST && directionState == Direction.NORTH;
			boolean flag4 = direction == Direction.NORTH && directionState == Direction.EAST;
			if(flag1 || flag2|| flag3 || flag4)
			{
				GlStateManager.rotatef(90F * directionState.getDirection().offset(), axis.getOffsetX(), 0.0F, axis.getOffsetZ());
			}
		}
		
		float yAxis = direction != null ? direction.asRotation() : 0;
		if ((double)Math.abs(yAxis) > 1.0E-5D) {
		    GlStateManager.rotatef(yAxis, 0.0F, 1.0F, 0.0F);
		}
		
    	GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
	}
	
	private void renderDoorPart(BlockState state)
	{
		Block block = state.getBlock();

		this.bindTexture(DOOR_TEX);
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

}
