package fr.opineppes.minecraft.ageevolution.blueprints.structures;

import java.util.function.Consumer;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionBlocks;
import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorActive;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerActive;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorCornerDeco;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorSideActive;
import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorSideDeco;
import fr.opineppes.minecraft.ageevolution.utils.HorizontalAxis;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;

public class BunkerDoorObject {
	
	private World world;
	private BlockPos controler;
	private Direction direction;
	private Vec2f size;
	private Boolean cachedClosed;
	
	//Creation et sauvegarde de la porte
	
	public BunkerDoorObject(World world, BlockPos controler, Direction direction, Vec2f size) {
		this.world = world;
		this.controler = controler;
		this.direction = direction;
		this.size = size;
		this.cachedClosed = null;
	}
	
	public BunkerDoorObject(CompoundTag tag) {
		int x = tag.getInt("x");
		int y = tag.getInt("y");
		int z = tag.getInt("z");
		controler = new BlockPos(x, y, z);
		direction = Direction.byName(tag.getString("direction"));
		
		float xSize = tag.getFloat("xSize");
		float ySize = tag.getFloat("ySize");
		size = new Vec2f(xSize, ySize);
	}
	
	public CompoundTag toTag(CompoundTag tag)
	{
		tag.putInt("x", controler.getX());
		tag.putInt("y", controler.getY());
		tag.putInt("z", controler.getZ());
		
		tag.putString("direction", direction.toString());
		
		tag.putFloat("xSize", size.x);
		tag.putFloat("ySize", size.y);
		
		return tag;
	}
	
	public void setWorld(World world)
	{
		this.world = world;
	}
	
	//Actions de la porte
	
	public void construct()
	{
		if(world != null)
		{
			forEachBlocks((pos) ->
			{
				BlockState state = world.getBlockState(pos);
				BlockState newBlockState = null;
				
				if(state.getBlock() == AgeEvolutionBlocks.BUNKER_DOOR_CORNER_DECO)
				{
					newBlockState = AgeEvolutionBlocks.BUNKER_DOOR_CORNER_ACTIVE.getDefaultState();
					newBlockState = newBlockState.with(BunkerDoorCornerActive.TYPE, state.get(BunkerDoorCornerDeco.TYPE));
					newBlockState = newBlockState.with(BunkerDoorCornerActive.FACING, state.get(BunkerDoorCornerDeco.FACING));
					newBlockState = newBlockState.with(BunkerDoorActive.CLOSED, true);
				}
				else if(state.getBlock() == AgeEvolutionBlocks.BUNKER_DOOR_SIDE_DECO)
				{
					newBlockState = AgeEvolutionBlocks.BUNKER_DOOR_SIDE_ACTIVE.getDefaultState();
					newBlockState = newBlockState.with(BunkerDoorSideActive.TYPE, state.get(BunkerDoorSideDeco.TYPE));
					newBlockState = newBlockState.with(BunkerDoorSideActive.FACING, state.get(BunkerDoorSideDeco.FACING));
					newBlockState = newBlockState.with(BunkerDoorActive.CLOSED, true);
				}
				else 
				{
					newBlockState = AgeEvolutionBlocks.BUNKER_DOOR_BARRIER.getDefaultState();
					newBlockState = newBlockState.with(BunkerDoorSideActive.FACING, direction);
					newBlockState = newBlockState.with(BunkerDoorActive.CLOSED, true);
				}
				
				if(newBlockState != null)
				{
					world.setBlockState(pos, newBlockState);
					BlockEntity entity = world.getBlockEntity(pos);
					if(entity instanceof BunkerDoorBlockEntity)
					{
						BunkerDoorBlockEntity door = (BunkerDoorBlockEntity) entity;
						door.setSlave(controler);
					}
				}
			});
			
			BlockEntity entity = world.getBlockEntity(controler);
			if(entity instanceof BunkerDoorBlockEntity)
			{
				BunkerDoorBlockEntity door = (BunkerDoorBlockEntity) entity;
				door.setMaster(this);
			}
		}
	}
	
	public void destroy()
	{
		if(world != null)
		{
			forEachBlocks((pos) ->
			{
				world.setBlockState(pos, Blocks.AIR.getDefaultState());
			});
		}
	}
	
	public void openCloseSwitch()
	{
		if(world != null)
		{
			boolean closed = isClosed();
			forEachBlocks((pos) ->
			{
				BlockState newBlockState = world.getBlockState(pos).with(BunkerDoorActive.CLOSED, !closed);
				world.setBlockState(pos, newBlockState);
			});
			
			cachedClosed = !closed;
		}
	}
	
	//Recuperations des propriete de la porte
	
	public Direction getDirection()
	{
		return direction;
	}
	
	public Vec2f getSize()
	{
		return new Vec2f(size.x, size.y);
	}
	
	public boolean isClosed()
	{
		if(cachedClosed == null)
			cachedClosed = world.getBlockState(controler).get(BunkerDoorActive.CLOSED);
		return cachedClosed;
	}
	
	//Parcours des block de la porte
	
	public void forEachBlocks(Consumer<BlockPos> action)
	{
		forEachBlocks(controler, size, HorizontalAxis.fromPerpendDirection(direction), action);
	}
	
	public void forEachBlocksIn(Consumer<BlockPos> action)
	{
		forEachBlocksIn(controler, size, HorizontalAxis.fromPerpendDirection(direction), action);
	}
	
	public static void forEachBlocks(BlockPos controlerPos, Vec2f size, HorizontalAxis axis, Consumer<BlockPos> action)
	{
		int xStart = axis == HorizontalAxis.X ? controlerPos.getX() : controlerPos.getX();
		int yStart = controlerPos.getY();
		int zStart = axis == HorizontalAxis.Z ? controlerPos.getZ() : controlerPos.getZ();
		
		int xEnd = axis == HorizontalAxis.X ? controlerPos.getX() + (int) size.x : controlerPos.getX() + 1;
		int yEnd = controlerPos.getY() + (int)size.y;
		int zEnd = axis == HorizontalAxis.Z ? controlerPos.getZ() + (int) size.x : controlerPos.getZ() + 1;

		for(int x = xStart; x < xEnd; x++)
		{
			for(int z = zStart; z < zEnd; z++)
			{
				for(int y = yStart; y < yEnd; y++)
				{
					action.accept(new BlockPos(x, y, z));
				}
			}
		}
	}
	
	public static void forEachBlocksIn(BlockPos controlerPos, Vec2f size, HorizontalAxis axis, Consumer<BlockPos> action)
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
					action.accept(new BlockPos(x, y, z));
				}
			}
		}
	}

}
