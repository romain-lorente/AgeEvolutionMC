package fr.opineppes.minecraft.ageevolution.blueprints;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionBlocks;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorStructure;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco.Type;
import fr.opineppes.minecraft.ageevolution.blueprints.structures.BunkerDoorObject;
import fr.opineppes.minecraft.ageevolution.utils.HorizontalAxis;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class BunkerDoorBlueprint implements Blueprint<BunkerDoorBlueprint, BunkerDoorObject>{
	
	//start variables
	private World world;
	private BlockPos startBlockPos;
	private BlockState startBlockState;
	private HorizontalAxis startAxis;
	private Direction direction;
	
	//Cache
	private boolean valid;
	private BlockPos[] corners;
	private String invalidityMessage;
	
	private BunkerDoorBlueprint(World world, BlockPos startBlockPos, BlockState startBlockState, float yaw)
	{
		this.world = world;
		this.startBlockPos = startBlockPos;
		this.startBlockState = startBlockState;
		
		BunkerDoorStructure actualBlock = (BunkerDoorStructure) startBlockState.getBlock();
		startAxis = actualBlock.getAxis(startBlockState);
		direction = startAxis.getPerpendDirection(yaw);
		
		valid = false;
		corners = new BlockPos[4];
		invalidityMessage = null;
	}
	
	public BunkerDoorBlueprint verifyStructure()
	{
		boolean tempValid = false;
		boolean end = false;
		int nbCorner = 0;
    	
    	BlockPos actualBlockPos = startBlockPos;
    	BlockState actualBlockState = startBlockState;
    	BunkerDoorStructure actualBlock = (BunkerDoorStructure) startBlockState.getBlock();
    	
    	while(!end)
    	{
    		Direction nextDirection = actualBlock.getNextDirection(actualBlockState);
    		actualBlockPos = actualBlockPos.offset(nextDirection);
			actualBlockState = world.getBlockState(actualBlockPos);
			
    		if(actualBlockState.getBlock() instanceof BunkerDoorStructure)
    		{
		    	actualBlock = (BunkerDoorStructure) actualBlockState.getBlock();
		    	
		    	boolean flag1 = actualBlock.getAxis(actualBlockState) != startAxis;
		    	boolean flag2 = actualBlock.getPrevDirection(actualBlockState).getOpposite() != nextDirection;
		    	boolean flag3 = actualBlockPos.equals(startBlockPos);
		    	
		    	end = flag1 || flag2 || flag3;
		    	tempValid = flag3 && !flag1 && !flag2;
		    	
		    	if(actualBlock == AgeEvolutionBlocks.BUNKER_DOOR_CORNER_DECO)
		    		corners[nbCorner++] = actualBlockPos;
    		}
    		else 
    		{
				end = true;
			}
    		
    	}
    	
    	if(tempValid)
    	{
    		Vec2f size = getSize(startAxis, corners[0], corners[2]);
    		
    		if(size.x >= 3 && size.y >= 3)
    		{
    			BlockPos controlerPos = getControler(world, startAxis, corners);
    			if(!isObstrued(world, controlerPos, size, startAxis))
    			{
    				valid = true;
    			}
    			else 
    			{
        			invalidityMessage = "La porte est obstrué.";
				}
    		}
    		else
    		{
    			invalidityMessage = "La structure est trop petite (minimum: 3x3)";
			}
    	}
    	else 
    	{
    		invalidityMessage = "La structure est incorrecte";
		}
    	
    	return this;
	}
	
	public BunkerDoorObject build()
	{
		BlockPos controlerPos = getControler(world, startAxis, corners);
		Vec2f size = getSize(startAxis, corners[0], corners[2]);
		
		return new BunkerDoorObject(world, controlerPos, direction, size);
	}
	
	//fonctions de verification du succe
	public boolean isValid()
	{
		return valid;
	}
	
	public String getErrorMessage()
	{
		return invalidityMessage;
	}
	
	//createur du builder
	public static BunkerDoorBlueprint create(World world, BlockPos startBlockPos, BlockState startBlockState, float yaw)
	{
		return new BunkerDoorBlueprint(world, startBlockPos, startBlockState, yaw);
		
	}
	
	//fonctions utilitaire
	private static Vec2f getSize(HorizontalAxis axis, Vec3i pos1, Vec3i pos2) {
		Vec3d yVector1 = new Vec3d(pos1.getY(), 0, 0);
		Vec3d yVector2 = new Vec3d(pos2.getY(), 0, 0);
		double height = yVector1.distanceTo(yVector2);
		
		double width;
		if(axis == HorizontalAxis.X)
		{
			Vec3d xVector1 = new Vec3d(pos1.getX(), 0, 0);
    		Vec3d xVector2 = new Vec3d(pos2.getX(), 0, 0);
    		width = xVector1.distanceTo(xVector2);
		}
		else 
		{
			Vec3d zVector1 = new Vec3d(pos1.getZ(), 0, 0);
			Vec3d zVector2 = new Vec3d(pos2.getZ(), 0, 0);
			width = zVector1.distanceTo(zVector2);
		}
		
		return new Vec2f((float) width + 1, (float) height + 1);
	}
	
	private static BlockPos getControler(World world, HorizontalAxis axis, BlockPos[] corners)
	{
		Direction goodFacing = axis == HorizontalAxis.X ? Direction.EAST : Direction.SOUTH;
		for(BlockPos corner : corners)
		{
			BlockState state = world.getBlockState(corner);
			if(state.get(BunkerDoorCornerDeco.TYPE) == Type.BOTTOM && state.get(BunkerDoorCornerDeco.FACING) == goodFacing)
			{
				return corner;
			}
		}
		return null;
	}
	
	private static boolean isObstrued(World world, BlockPos controlerPos, Vec2f size, HorizontalAxis axis)
	{
		int xStart = axis == HorizontalAxis.X ? controlerPos.getX() + 1 : controlerPos.getX();
		int yStart = controlerPos.getY() + 1;
		int zStart = axis == HorizontalAxis.Z ? controlerPos.getZ() + 1 : controlerPos.getZ();
		
		int xEnd = axis == HorizontalAxis.X ? controlerPos.getX() + (int) size.x - 1 : controlerPos.getX() + 1;
		int yEnd = controlerPos.getY() + (int)size.y - 1;
		int zEnd = axis == HorizontalAxis.Z ? controlerPos.getZ() + (int) size.x - 1 : controlerPos.getZ() + 1;

		for(int x = xStart; x < xEnd; x++)
		{
			for(int z = zStart; z < zEnd; z++)
			{
				for(int y = yStart; y < yEnd; y++)
				{
					if(world.getBlockState(new BlockPos(x, y, z)).getBlock() != Blocks.AIR)
						return true;
				}
			}
		}
		return false;
	}

}
