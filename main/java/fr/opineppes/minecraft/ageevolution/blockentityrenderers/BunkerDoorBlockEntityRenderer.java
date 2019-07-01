package fr.opineppes.minecraft.ageevolution.blockentityrenderers;

import com.mojang.blaze3d.platform.GlStateManager;

import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorStructure.Orientation;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.model.ChestEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;

public class BunkerDoorBlockEntityRenderer extends BlockEntityRenderer<BunkerDoorBlockEntity> {
	   private static final Identifier NORMAL_TEX = new Identifier("textures/entity/chest/normal.png");
	   private final ChestEntityModel modelSingleChest = new ChestEntityModel();
	   
	public void render(BunkerDoorBlockEntity blockEntity_1, double double_1, double double_2, double double_3, float float_1, int int_1) {
	    if(blockEntity_1.isMaster() && blockEntity_1.isClosed())
	    {
	    	GlStateManager.enableDepthTest();
	    	GlStateManager.depthFunc(515);
	    	GlStateManager.depthMask(true);
		      
	    	BlockState blockState_1 = blockEntity_1.hasWorld() ? blockEntity_1.getCachedState() : (BlockState)Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
	    	ChestType chestType_1 = blockState_1.contains(ChestBlock.CHEST_TYPE) ? (ChestType)blockState_1.get(ChestBlock.CHEST_TYPE) : ChestType.SINGLE;
		      
	    	if (chestType_1 != ChestType.LEFT) {
//	    		boolean boolean_1 = chestType_1 != ChestType.SINGLE;
//	    		ChestEntityModel chestEntityModel_1 = this.method_3562(blockEntity_1, int_1, boolean_1);
//	    		if (int_1 >= 0) {
//	    			GlStateManager.matrixMode(5890);
//		            GlStateManager.pushMatrix();
//		            
//		            GlStateManager.scalef(boolean_1 ? 8.0F : 4.0F, 4.0F, 1.0F);
//		            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
//		            GlStateManager.matrixMode(5888);
//		         } else {
//		            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//		         }
	    		this.bindTexture(NORMAL_TEX);
	    		
	    		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    		
		        GlStateManager.pushMatrix();
		        GlStateManager.enableRescaleNormal();
		        
		        GlStateManager.translatef((float)double_1, (float)double_2, (float)double_3);
		        GlStateManager.scalef(1.0F, -1.0F, -1.0F);
		        
		         Vec2f size = blockEntity_1.getSize();
		         
		         float xSize = blockEntity_1.getOrient() == Orientation.X ? size.x : 1;
		         float zSize = blockEntity_1.getOrient() == Orientation.Z ? size.x : 1;
		         
		         float zPos = blockEntity_1.getOrient() == Orientation.Z ? -size.x : -1;
		         
		         GlStateManager.translatef(0, -size.y, zPos);
		         GlStateManager.scalef(xSize, size.y, zSize);
		         
		         float float_2 = blockEntity_1.getOrient() == Orientation.X ? Direction.WEST.asRotation() : Direction.NORTH.asRotation();
		         if ((double)Math.abs(float_2) > 1.0E-5D) {
		            GlStateManager.translatef(0.5F, 0.5F, 0.5F);
		            GlStateManager.rotatef(float_2, 0.0F, 1.0F, 0.0F);
		            GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
		         }

		         modelSingleChest.method_2799();
		         
		         GlStateManager.disableRescaleNormal();
		         GlStateManager.popMatrix();
		         
		         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//		         if (int_1 >= 0) {
//		            GlStateManager.matrixMode(5890);
//		            GlStateManager.popMatrix();
//		            GlStateManager.matrixMode(5888);
//		         }

		      }
	    }
	   }
	
//	private ChestEntityModel method_3562(BunkerDoorBlockEntity blockEntity_1, int int_1, boolean boolean_1) {
//	      Identifier identifier_5;
//	      
//	      if (int_1 >= 0) {
//	         identifier_5 = DESTROY_STAGE_TEXTURES[int_1];
//	      } else {
//	          identifier_5 = NORMAL_TEX;
//	      }
//	      
//	      this.bindTexture(identifier_5);
//	      return boolean_1 ? this.modelDoubleChest : this.modelSingleChest;
//	   }
}
