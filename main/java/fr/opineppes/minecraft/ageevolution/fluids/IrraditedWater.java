package fr.opineppes.minecraft.ageevolution.fluids;

import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;

public class IrraditedWater extends BaseFluid {

	@Override
	public Fluid getFlowing() {
		return null;
	}

	@Override
	public Fluid getStill() {
		return null;
	}
	
	@Override
	protected BlockRenderLayer getRenderLayer() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Item getBucketItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isInfinite() {
		return false;
	}

	@Override
	protected void beforeBreakingBlock(IWorld var1, BlockPos var2, BlockState var3) {

	}

	@Override
	protected int method_15733(ViewableWorld var1) {
		return 4;
	}

	@Override
	protected int getLevelDecreasePerBlock(ViewableWorld var1) {
		return 1;
	}

	@Override
	protected boolean method_15777(FluidState var1, BlockView var2, BlockPos var3, Fluid var4, Direction var5) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTickRate(ViewableWorld var1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected float getBlastResistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected BlockState toBlockState(FluidState var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStill(FluidState var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLevel(FluidState var1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static class Flowing extends IrraditedWater {
      protected void appendProperties(StateFactory.Builder<Fluid, FluidState> stateFactory$Builder_1) {
         super.appendProperties(stateFactory$Builder_1);
         stateFactory$Builder_1.add(LEVEL);
      }

      public int getLevel(FluidState fluidState_1) {
         return (Integer)fluidState_1.get(LEVEL);
      }

      public boolean isStill(FluidState fluidState_1) {
         return false;
      }
   }

   public static class Still extends IrraditedWater {
      public int getLevel(FluidState fluidState_1) {
         return 8;
      }

      public boolean isStill(FluidState fluidState_1) {
         return true;
      }
   }

}
