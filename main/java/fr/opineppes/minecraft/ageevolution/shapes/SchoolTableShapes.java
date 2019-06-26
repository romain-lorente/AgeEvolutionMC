package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class SchoolTableShapes {
	
	public static final VoxelShape NORTH = getNorthShape();
	public static final VoxelShape EAST = getEastShape();
	public static final VoxelShape SOUTH = getSouthShape();
	public static final VoxelShape WEST = getWestShape();
	
	public static final VoxelShape NORTH_WITH_CHAIR = getNorthWithChairShape();
	public static final VoxelShape EAST_WITH_CHAIR = getEastWithChairShape();
	public static final VoxelShape SOUTH_WITH_CHAIR = getSouthWithChairShape();
	public static final VoxelShape WEST_WITH_CHAIR = getWestWithChairShape();
	
	private static VoxelShape getNorthWithChairShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 3.0, 2.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 12.0, 2.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 12.0, 15.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 3.0, 15.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 3.0, 14.5, 11.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 12.0, 14.5, 11.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 7.0, 4.0, 15.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 7.0, 4.0, 2.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 11.0, 2.0, 15.0, 11.5, 14.0));
	    shapes.add(Block.createCuboidShape(1.0, 8.0, 6.0, 1.5, 9.25, 12.0));
	    shapes.add(Block.createCuboidShape(14.5, 8.0, 6.0, 15.0, 9.25, 12.0));
	    shapes.add(Block.createCuboidShape(1.5, 8.0, 6.0, 14.5, 8.2, 12.0));
	    shapes.add(Block.createCuboidShape(2.0, 8.0, 12.0, 14.0, 9.25, 12.5));
	    shapes.add(Block.createCuboidShape(3.5, 6.0, 1.0, 12.5, 6.35, 8.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 7.0, 12.0, 5.0, 8.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 5.0, 13.0, 1.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 0.0, 12.0, 13.0, 1.0));
	    shapes.add(Block.createCuboidShape(3.5, 9.0, 1.0, 12.5, 13.0, 1.35));
	    shapes.add(Block.createCuboidShape(11.0, 5.0, 1.0, 12.0, 6.0, 8.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 7.0, 5.0, 5.0, 8.0));
	    shapes.add(Block.createCuboidShape(4.0, 5.0, 1.0, 5.0, 6.0, 8.0));
	    shapes.add(Block.createCuboidShape(5.0, 5.75, 3.0, 11.0, 6.0, 5.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	private static VoxelShape getEastWithChairShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 1.0, 13.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 1.0, 4.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 14.0, 4.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 14.0, 13.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 10.0, 1.5, 13.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(3.0, 10.0, 1.5, 4.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 14.0, 12.0, 8.0, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 1.0, 12.0, 8.0, 2.0));
	    shapes.add(Block.createCuboidShape(2.0, 11.0, 1.0, 14.0, 11.5, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 8.0, 1.0, 10.0, 9.25, 1.5));
	    shapes.add(Block.createCuboidShape(4.0, 8.0, 14.5, 10.0, 9.25, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 8.0, 1.5, 10.0, 8.2, 14.5));
	    shapes.add(Block.createCuboidShape(3.5, 8.0, 2.0, 4.0, 9.25, 14.0));
	    shapes.add(Block.createCuboidShape(8.0, 6.0, 3.5, 15.0, 6.35, 12.5));
	    shapes.add(Block.createCuboidShape(8.0, 0.0, 11.0, 9.0, 5.0, 12.0));
	    shapes.add(Block.createCuboidShape(15.0, 0.0, 4.0, 16.0, 13.0, 5.0));
	    shapes.add(Block.createCuboidShape(15.0, 0.0, 11.0, 16.0, 13.0, 12.0));
	    shapes.add(Block.createCuboidShape(14.65, 9.0, 3.5, 15.0, 13.0, 12.5));
	    shapes.add(Block.createCuboidShape(8.0, 5.0, 11.0, 15.0, 6.0, 12.0));
	    shapes.add(Block.createCuboidShape(8.0, 0.0, 4.0, 9.0, 5.0, 5.0));
	    shapes.add(Block.createCuboidShape(8.0, 5.0, 4.0, 15.0, 6.0, 5.0));
	    shapes.add(Block.createCuboidShape(11.0, 5.75, 5.0, 13.0, 6.0, 11.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	private static VoxelShape getSouthWithChairShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 12.0, 15.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 3.0, 15.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 3.0, 2.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 12.0, 2.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 12.0, 14.5, 11.0, 13.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 3.0, 14.5, 11.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 7.0, 4.0, 2.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(14.0, 7.0, 4.0, 15.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 11.0, 2.0, 15.0, 11.5, 14.0));
	    shapes.add(Block.createCuboidShape(14.5, 8.0, 4.0, 15.0, 9.25, 10.0));
	    shapes.add(Block.createCuboidShape(1.0, 8.0, 4.0, 1.5, 9.25, 10.0));
	    shapes.add(Block.createCuboidShape(1.5, 8.0, 4.0, 14.5, 8.2, 10.0));
	    shapes.add(Block.createCuboidShape(2.0, 8.0, 3.5, 14.0, 9.25, 4.0));
	    shapes.add(Block.createCuboidShape(3.5, 6.0, 8.0, 12.5, 6.35, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 8.0, 5.0, 5.0, 9.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 15.0, 12.0, 13.0, 16.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 15.0, 5.0, 13.0, 16.0));
	    shapes.add(Block.createCuboidShape(3.5, 9.0, 14.65, 12.5, 13.0, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 5.0, 8.0, 5.0, 6.0, 15.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 8.0, 12.0, 5.0, 9.0));
	    shapes.add(Block.createCuboidShape(11.0, 5.0, 8.0, 12.0, 6.0, 15.0));
	    shapes.add(Block.createCuboidShape(5.0, 5.75, 11.0, 11.0, 6.0, 13.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	private static VoxelShape getWestWithChairShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 14.0, 4.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 14.0, 13.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 1.0, 13.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 1.0, 4.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 10.0, 1.5, 4.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(12.0, 10.0, 1.5, 13.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 1.0, 12.0, 8.0, 2.0));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 14.0, 12.0, 8.0, 15.0));
	    shapes.add(Block.createCuboidShape(2.0, 11.0, 1.0, 14.0, 11.5, 15.0));
	    shapes.add(Block.createCuboidShape(6.0, 8.0, 14.5, 12.0, 9.25, 15.0));
	    shapes.add(Block.createCuboidShape(6.0, 8.0, 1.0, 12.0, 9.25, 1.5));
	    shapes.add(Block.createCuboidShape(6.0, 8.0, 1.5, 12.0, 8.2, 14.5));
	    shapes.add(Block.createCuboidShape(12.0, 8.0, 2.0, 12.5, 9.25, 14.0));
	    shapes.add(Block.createCuboidShape(1.0, 6.0, 3.5, 8.0, 6.35, 12.5));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 4.0, 8.0, 5.0, 5.0));
	    shapes.add(Block.createCuboidShape(0.0, 0.0, 11.0, 1.0, 13.0, 12.0));
	    shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 1.0, 13.0, 5.0));
	    shapes.add(Block.createCuboidShape(1.0, 9.0, 3.5, 1.35, 13.0, 12.5));
	    shapes.add(Block.createCuboidShape(1.0, 5.0, 4.0, 8.0, 6.0, 5.0));
	    shapes.add(Block.createCuboidShape(7.0, 0.0, 11.0, 8.0, 5.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 5.0, 11.0, 8.0, 6.0, 12.0));
	    shapes.add(Block.createCuboidShape(3.0, 5.75, 5.0, 5.0, 6.0, 11.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
	
	private static VoxelShape getNorthShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 3.0, 2.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 12.0, 2.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 12.0, 15.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 3.0, 15.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 3.0, 14.5, 11.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 12.0, 14.5, 11.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 7.0, 4.0, 15.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 7.0, 4.0, 2.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 11.0, 2.0, 15.0, 11.5, 14.0));
	    shapes.add(Block.createCuboidShape(1.0, 8.0, 6.0, 1.5, 9.25, 12.0));
	    shapes.add(Block.createCuboidShape(14.5, 8.0, 6.0, 15.0, 9.25, 12.0));
	    shapes.add(Block.createCuboidShape(1.5, 8.0, 6.0, 14.5, 8.2, 12.0));
	    shapes.add(Block.createCuboidShape(2.0, 8.0, 12.0, 14.0, 9.25, 12.5));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	private static VoxelShape getEastShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 1.0, 13.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 1.0, 4.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 14.0, 4.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 14.0, 13.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 10.0, 1.5, 13.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(3.0, 10.0, 1.5, 4.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 14.0, 12.0, 8.0, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 1.0, 12.0, 8.0, 2.0));
	    shapes.add(Block.createCuboidShape(2.0, 11.0, 1.0, 14.0, 11.5, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 8.0, 1.0, 10.0, 9.25, 1.5));
	    shapes.add(Block.createCuboidShape(4.0, 8.0, 14.5, 10.0, 9.25, 15.0));
	    shapes.add(Block.createCuboidShape(4.0, 8.0, 1.5, 10.0, 8.2, 14.5));
	    shapes.add(Block.createCuboidShape(3.5, 8.0, 2.0, 4.0, 9.25, 14.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	private static VoxelShape getSouthShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 12.0, 15.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(14.0, 0.0, 3.0, 15.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 3.0, 2.0, 10.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 0.0, 12.0, 2.0, 10.0, 13.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 12.0, 14.5, 11.0, 13.0));
	    shapes.add(Block.createCuboidShape(1.5, 10.0, 3.0, 14.5, 11.0, 4.0));
	    shapes.add(Block.createCuboidShape(1.0, 7.0, 4.0, 2.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(14.0, 7.0, 4.0, 15.0, 8.0, 12.0));
	    shapes.add(Block.createCuboidShape(1.0, 11.0, 2.0, 15.0, 11.5, 14.0));
	    shapes.add(Block.createCuboidShape(14.5, 8.0, 4.0, 15.0, 9.25, 10.0));
	    shapes.add(Block.createCuboidShape(1.0, 8.0, 4.0, 1.5, 9.25, 10.0));
	    shapes.add(Block.createCuboidShape(1.5, 8.0, 4.0, 14.5, 8.2, 10.0));
	    shapes.add(Block.createCuboidShape(2.0, 8.0, 3.5, 14.0, 9.25, 4.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	private static VoxelShape getWestShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 14.0, 4.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 14.0, 13.0, 10.0, 15.0));
	    shapes.add(Block.createCuboidShape(12.0, 0.0, 1.0, 13.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 0.0, 1.0, 4.0, 10.0, 2.0));
	    shapes.add(Block.createCuboidShape(3.0, 10.0, 1.5, 4.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(12.0, 10.0, 1.5, 13.0, 11.0, 14.5));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 1.0, 12.0, 8.0, 2.0));
	    shapes.add(Block.createCuboidShape(4.0, 7.0, 14.0, 12.0, 8.0, 15.0));
	    shapes.add(Block.createCuboidShape(2.0, 11.0, 1.0, 14.0, 11.5, 15.0));
	    shapes.add(Block.createCuboidShape(6.0, 8.0, 14.5, 12.0, 9.25, 15.0));
	    shapes.add(Block.createCuboidShape(6.0, 8.0, 1.0, 12.0, 9.25, 1.5));
	    shapes.add(Block.createCuboidShape(6.0, 8.0, 1.5, 12.0, 8.2, 14.5));
	    shapes.add(Block.createCuboidShape(12.0, 8.0, 2.0, 12.5, 9.25, 14.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
	
}
