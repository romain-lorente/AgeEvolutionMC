package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class SchoolChairShapes {
	
	public static final VoxelShape NORTH = getNorthShape();
	public static final VoxelShape EAST = getEastShape();
	public static final VoxelShape SOUTH = getSouthShape();
	public static final VoxelShape WEST = getWestShape();
	
	private static VoxelShape getEastShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
		shapes.add(Block.createCuboidShape(5.0, 6.0, 3.5, 12.0, 6.35, 12.5));
		shapes.add(Block.createCuboidShape(11.0, 0.0, 4.0, 12.0, 5.0, 5.0));
		shapes.add(Block.createCuboidShape(4.0, 0.0, 11.0, 5.0, 13.0, 12.0));
		shapes.add(Block.createCuboidShape(4.0, 0.0, 4.0, 5.0, 13.0, 5.0));
		shapes.add(Block.createCuboidShape(5.0, 9.0, 3.5, 5.35, 13.0, 12.5));
		shapes.add(Block.createCuboidShape(5.0, 5.0, 4.0, 12.0, 6.0, 5.0));
		shapes.add(Block.createCuboidShape(11.0, 0.0, 11.0, 12.0, 5.0, 12.0));
		shapes.add(Block.createCuboidShape(5.0, 5.0, 11.0, 12.0, 6.0, 12.0));
		shapes.add(Block.createCuboidShape(7.0, 5.75, 5.0, 9.0, 6.0, 11.0));
	    
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
	    
	    shapes.add(Block.createCuboidShape(3.5, 6.0, 5.0, 12.5, 6.35, 12.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 11.0, 12.0, 5.0, 12.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 4.0, 5.0, 13.0, 5.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 4.0, 12.0, 13.0, 5.0));
	    shapes.add(Block.createCuboidShape(3.5, 9.0, 5.0, 12.5, 13.0, 5.35));
	    shapes.add(Block.createCuboidShape(11.0, 5.0, 5.0, 12.0, 6.0, 12.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 11.0, 5.0, 5.0, 12.0));
	    shapes.add(Block.createCuboidShape(4.0, 5.0, 5.0, 5.0, 6.0, 12.0));
	    shapes.add(Block.createCuboidShape(5.0, 5.75, 7.0, 11.0, 6.0, 9.0));
	    
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
	    
	    shapes.add(Block.createCuboidShape(4.0, 6.0, 3.5, 11.0, 6.35, 12.5));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 11.0, 5.0, 5.0, 12.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 4.0, 12.0, 13.0, 5.0));
	    shapes.add(Block.createCuboidShape(11.0, 0.0, 11.0, 12.0, 13.0, 12.0));
	    shapes.add(Block.createCuboidShape(10.65, 9.0, 3.5, 11.0, 13.0, 12.5));
	    shapes.add(Block.createCuboidShape(4.0, 5.0, 11.0, 11.0, 6.0, 12.0));
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 4.0, 5.0, 5.0, 5.0));
	    shapes.add(Block.createCuboidShape(4.0, 5.0, 4.0, 11.0, 6.0, 5.0));
	    shapes.add(Block.createCuboidShape(7.0, 5.75, 5.0, 9.0, 6.0, 11.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
	
	private static VoxelShape getNorthShape()
	{
		List<VoxelShape> shapes = new ArrayList<>();
		
	    shapes.add(Block.createCuboidShape(3.5, 6, 4, 12.5, 6.35, 11)); // CUBE
	    shapes.add(Block.createCuboidShape(4, 0, 4, 5, 5, 5)); // CUBE
	    shapes.add(Block.createCuboidShape(11, 0, 11, 12, 13, 12)); // CUBE
	    shapes.add(Block.createCuboidShape(4, 0, 11, 5, 13, 12)); // CUBE
	    shapes.add(Block.createCuboidShape(3.5, 9, 10.65, 12.5, 13, 11)); // CUBE
	    shapes.add(Block.createCuboidShape(4, 5, 4, 5, 6, 11)); // CUBE
	    shapes.add(Block.createCuboidShape(11, 0, 4, 12, 5, 5)); // CUBE
	    shapes.add(Block.createCuboidShape(11, 5, 4, 12, 6, 11)); // CUBE
	    shapes.add(Block.createCuboidShape(5, 5.75, 7, 11, 6, 9)); // CUBE

	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
}
