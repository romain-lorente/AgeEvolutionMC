package fr.opineppes.minecraft.ageevolution.blueprints;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionBlocks;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorStructure;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco.Type;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorStructure.Orientation;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class BunkerDoorBlueprint {
	
	public static void create(World world, BlockPos startBlockPos, BlockState startBlockState) throws BadBunkerDoorBlueprint
	{
		boolean end = false;
    	boolean valid = false;
    	
    	int nbCorner = 0;
    	BlockPos[] corners = new BlockPos[4];
    	
    	BlockPos actualBlockPos = startBlockPos;
    	BlockState actualBlockState = startBlockState;
    	BunkerDoorStructure actualBlock = (BunkerDoorStructure) startBlockState.getBlock();
    	
    	Orientation startOrientation = actualBlock.getOrientation(startBlockState);
    	
    	while(!end)
    	{
    		Direction nextDirection = actualBlock.getNextDirection(actualBlockState);
    		actualBlockPos = actualBlockPos.offset(nextDirection);
			actualBlockState = world.getBlockState(actualBlockPos);
			
    		if(actualBlockState.getBlock() instanceof BunkerDoorStructure)
    		{
		    	actualBlock = (BunkerDoorStructure) actualBlockState.getBlock();
		    	
		    	boolean flag1 = actualBlock.getOrientation(actualBlockState) != startOrientation;
		    	boolean flag2 = actualBlock.getPrevDirection(actualBlockState).getOpposite() != nextDirection;
		    	boolean flag3 = actualBlockPos.equals(startBlockPos);
		    	
		    	end = flag1 || flag2 || flag3;
		    	valid = flag3 && !flag1 && !flag2;
		    	
		    	if(actualBlock == AgeEvolutionBlocks.BUNKER_DOOR_CORNER_DECO)
		    		corners[nbCorner++] = actualBlockPos;
    		}
    		else 
    		{
				end = true;
			}
    		
    	}
    	
    	if(valid)
    	{
    		Vec2f size = getSize(startOrientation, corners[0], corners[2]);
    		
    		if(size.x >= 3 && size.y >= 3)
    		{
    			if(!isObstrued(world, startOrientation, size, corners))
    			{
    				//return new BunkerDoorObject();
    			}
    			else 
    			{
        			throw new BadBunkerDoorBlueprint("La porte est obstrué.");
				}
    		}
    		else
    		{
    			throw new BadBunkerDoorBlueprint("La structure est trop petite (minimum: 3x3)");
			}
    	}
    	else 
    	{
	    	throw new BadBunkerDoorBlueprint("La structure est incorrecte");
		}
	}
	
	private static Vec2f getSize(Orientation orient, Vec3i pos1, Vec3i pos2) {
		Vec3d yVector1 = new Vec3d(pos1.getY(), 0, 0);
		Vec3d yVector2 = new Vec3d(pos2.getY(), 0, 0);
		double height = yVector1.distanceTo(yVector2);
		
		double width;
		if(orient == Orientation.X)
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
	
	public static boolean isObstrued(World world, Orientation orient, Vec2f size, BlockPos[] corners)
	{
		BlockPos startPos = null;
		
		Direction goodFacing = orient == Orientation.X ? Direction.EAST : Direction.SOUTH;
		for(BlockPos corner : corners)
		{
			BlockState state = world.getBlockState(corner);
			if(state.get(BunkerDoorCornerDeco.TYPE) == Type.BOTTOM && state.get(BunkerDoorCornerDeco.FACING) == goodFacing)
			{
				startPos = corner;
				break;
			}
		}
		
		if(startPos != null)
		{
			int xStart = orient == Orientation.X ? startPos.getX() + 1 : startPos.getX();
			int yStart = startPos.getY() + 1;
			int zStart = orient == Orientation.Z ? startPos.getZ() + 1 : startPos.getZ();
			
			int xEnd = orient == Orientation.X ? startPos.getX() + (int) size.x - 1 : startPos.getX() + 1;
			int yEnd = startPos.getY() + (int)size.y - 1;
			int zEnd = orient == Orientation.Z ? startPos.getZ() + (int) size.x - 1 : startPos.getZ() + 1;

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
		return true;
	}

	
	public static class BadBunkerDoorBlueprint extends Exception
	{
		private static final long serialVersionUID = -9122205914808525568L;
		
		public BadBunkerDoorBlueprint(String message)
		{
			super(message);
		}
	}

}
