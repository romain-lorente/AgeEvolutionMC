package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class FireExtinguisherShapes {
	
	public static final VoxelShape NORTH_WALL = getNorthWallShape();
	public static final VoxelShape EAST_WALL = getEastWallShape();
	public static final VoxelShape SOUTH_WALL = getSouthWallShape();
	public static final VoxelShape WEST_WALL = getWestWallShape();
	
	public static final VoxelShape NORTH_GROUND = getNorthGroundShape();
	public static final VoxelShape EAST_GROUND = getEastGroundShape();
	public static final VoxelShape SOUTH_GROUND = getSouthGroundShape();
	public static final VoxelShape WEST_GROUND = getWestGroundShape();
	
	public static VoxelShape getNorthWallShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(7.0, 6.0, 15.75, 9.0, 9.0, 16.0));
	    shapes.add(Block.createCuboidShape(7.0, 1.0, 13.75, 9.0, 6.0, 15.75));
	    shapes.add(Block.createCuboidShape(7.25, 10.0, 14.0, 8.75, 11.0, 15.5));
	    shapes.add(Block.createCuboidShape(5.25, 11.0, 14.375, 8.75, 11.4, 15.125));
	    shapes.add(Block.createCuboidShape(7.75, 11.4, 14.375, 8.75, 12.1, 15.125));
	    shapes.add(Block.createCuboidShape(5.25, 11.7, 14.375, 7.75, 12.1, 15.125));
	    shapes.add(Block.createCuboidShape(8.75, 10.75, 14.0, 9.75, 12.25, 15.5));
	    shapes.add(Block.createCuboidShape(9.75, 10.5, 13.75, 11.25, 12.5, 15.75));
	    shapes.add(Block.createCuboidShape(7.0, 8.0, 13.75, 9.0, 10.0, 15.75));
	    shapes.add(Block.createCuboidShape(7.0, 6.0, 13.75, 9.0, 8.0, 15.75));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getEastWallShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(0.0, 6.0, 7.0, 0.25, 9.0, 9.0));
	    shapes.add(Block.createCuboidShape(0.25, 1.0, 7.0, 2.25, 6.0, 9.0));
	    shapes.add(Block.createCuboidShape(0.5, 10.0, 7.25, 2.0, 11.0, 8.75));
	    shapes.add(Block.createCuboidShape(0.875, 11.0, 5.25, 1.625, 11.4, 8.75));
	    shapes.add(Block.createCuboidShape(0.875, 11.4, 7.75, 1.625, 12.1, 8.75));
	    shapes.add(Block.createCuboidShape(0.875, 11.7, 5.25, 1.625, 12.1, 7.75));
	    shapes.add(Block.createCuboidShape(0.5, 10.75, 8.75, 2.0, 12.25, 9.75));
	    shapes.add(Block.createCuboidShape(0.25, 10.5, 9.75, 2.25, 12.5, 11.25));
	    shapes.add(Block.createCuboidShape(0.25, 8.0, 7.0, 2.25, 10.0, 9.0));
	    shapes.add(Block.createCuboidShape(0.25, 6.0, 7.0, 2.25, 8.0, 9.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getSouthWallShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(7.0, 6.0, 0.0, 9.0, 9.0, 0.25));
	    shapes.add(Block.createCuboidShape(7.0, 1.0, 0.25, 9.0, 6.0, 2.25));
	    shapes.add(Block.createCuboidShape(7.25, 10.0, 0.5, 8.75, 11.0, 2.0));
	    shapes.add(Block.createCuboidShape(7.25, 11.0, 0.875, 10.75, 11.4, 1.625));
	    shapes.add(Block.createCuboidShape(7.25, 11.4, 0.875, 8.25, 12.1, 1.625));
	    shapes.add(Block.createCuboidShape(8.25, 11.7, 0.875, 10.75, 12.1, 1.625));
	    shapes.add(Block.createCuboidShape(6.25, 10.75, 0.5, 7.25, 12.25, 2.0));
	    shapes.add(Block.createCuboidShape(4.75, 10.5, 0.25, 6.25, 12.5, 2.25));
	    shapes.add(Block.createCuboidShape(7.0, 8.0, 0.25, 9.0, 10.0, 2.25));
	    shapes.add(Block.createCuboidShape(7.0, 6.0, 0.25, 9.0, 8.0, 2.25));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getWestWallShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(15.75, 6.0, 7.0, 16.0, 9.0, 9.0));
	    shapes.add(Block.createCuboidShape(13.75, 1.0, 7.0, 15.75, 6.0, 9.0));
	    shapes.add(Block.createCuboidShape(14.0, 10.0, 7.25, 15.5, 11.0, 8.75));
	    shapes.add(Block.createCuboidShape(14.375, 11.0, 7.25, 15.125, 11.4, 10.75));
	    shapes.add(Block.createCuboidShape(14.375, 11.4, 7.25, 15.125, 12.1, 8.25));
	    shapes.add(Block.createCuboidShape(14.375, 11.7, 8.25, 15.125, 12.1, 10.75));
	    shapes.add(Block.createCuboidShape(14.0, 10.75, 6.25, 15.5, 12.25, 7.25));
	    shapes.add(Block.createCuboidShape(13.75, 10.5, 4.75, 15.75, 12.5, 6.25));
	    shapes.add(Block.createCuboidShape(13.75, 8.0, 7.0, 15.75, 10.0, 9.0));
	    shapes.add(Block.createCuboidShape(13.75, 6.0, 7.0, 15.75, 8.0, 9.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getNorthGroundShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(2.0, 0.0, 7.0, 7.0, 2.0, 9.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.25, 7.25, 12.0, 1.75, 8.75));
	    shapes.add(Block.createCuboidShape(12.0, 0.625, 7.25, 12.4, 1.375, 10.75));
	    shapes.add(Block.createCuboidShape(12.4, 0.625, 7.25, 13.1, 1.375, 8.25));
	    shapes.add(Block.createCuboidShape(12.625, 0.625, 8.25, 13.025, 1.375, 10.75));
	    shapes.add(Block.createCuboidShape(11.75, 0.25, 6.25, 13.25, 1.75, 7.25));
	    shapes.add(Block.createCuboidShape(11.5, 0.0, 4.75, 13.5, 2.0, 6.25));
	    shapes.add(Block.createCuboidShape(9.0, 0.0, 7.0, 11.0, 2.0, 9.0));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 2.0, 9.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getEastGroundShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 2.0, 9.0, 2.0, 7.0));
	    shapes.add(Block.createCuboidShape(7.25, 0.25, 11.0, 8.75, 1.75, 12.0));
	    shapes.add(Block.createCuboidShape(5.25, 0.625, 12.0, 8.75, 1.375, 12.4));
	    shapes.add(Block.createCuboidShape(7.75, 0.625, 12.4, 8.75, 1.375, 13.1));
	    shapes.add(Block.createCuboidShape(5.25, 0.625, 12.625, 7.75, 1.375, 13.025));
	    shapes.add(Block.createCuboidShape(8.75, 0.25, 11.75, 9.75, 1.75, 13.25));
	    shapes.add(Block.createCuboidShape(9.75, 0.0, 11.5, 11.25, 2.0, 13.5));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 9.0, 9.0, 2.0, 11.0));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 2.0, 9.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getSouthGroundShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(9.0, 0.0, 7.0, 14.0, 2.0, 9.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.25, 7.25, 5.0, 1.75, 8.75));
	    shapes.add(Block.createCuboidShape(3.6, 0.625, 5.25, 4.0, 1.375, 8.75));
	    shapes.add(Block.createCuboidShape(2.9, 0.625, 7.75, 3.6, 1.375, 8.75));
	    shapes.add(Block.createCuboidShape(2.975, 0.625, 5.25, 3.375, 1.375, 7.75));
	    shapes.add(Block.createCuboidShape(2.75, 0.25, 8.75, 4.25, 1.75, 9.75));
	    shapes.add(Block.createCuboidShape(2.5, 0.0, 9.75, 4.5, 2.0, 11.25));
	    shapes.add(Block.createCuboidShape(5.0, 0.0, 7.0, 7.0, 2.0, 9.0));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 2.0, 9.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getWestGroundShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 9.0, 9.0, 2.0, 14.0));
	    shapes.add(Block.createCuboidShape(7.25, 0.25, 4.0, 8.75, 1.75, 5.0));
	    shapes.add(Block.createCuboidShape(7.25, 0.625, 3.6, 10.75, 1.375, 4.0));
	    shapes.add(Block.createCuboidShape(7.25, 0.625, 2.9, 8.25, 1.375, 3.6));
	    shapes.add(Block.createCuboidShape(8.25, 0.625, 2.975, 10.75, 1.375, 3.375));
	    shapes.add(Block.createCuboidShape(6.25, 0.25, 2.75, 7.25, 1.75, 4.25));
	    shapes.add(Block.createCuboidShape(4.75, 0.0, 2.5, 6.25, 2.0, 4.5));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 5.0, 9.0, 2.0, 7.0));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 2.0, 9.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
}
