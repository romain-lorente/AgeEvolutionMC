package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class CeilingLightBarsShapes {
	public static final VoxelShape SHAPE_X = getShapeX();
	public static final VoxelShape SHAPE_Z = getShapeZ();
	
	public static VoxelShape getShapeX()
	{
		List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(0.0, 15.75, 0.0, 16.0, 16.0, 16.0));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 0.0, 16.0, 15.75, 0.5));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 0.5, 0.5, 15.75, 15.5));
	    shapes.add(Block.createCuboidShape(2.0, 14.75, 2.0, 3.0, 15.75, 14.0));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 15.5, 16.0, 15.75, 16.0));
	    shapes.add(Block.createCuboidShape(15.5, 15.0, 0.5, 16.0, 15.75, 15.5));
	    shapes.add(Block.createCuboidShape(5.6, 14.75, 2.0, 6.6, 15.75, 14.0));
	    shapes.add(Block.createCuboidShape(9.4, 14.75, 2.0, 10.4, 15.75, 14.0));
	    shapes.add(Block.createCuboidShape(13.0, 14.75, 2.0, 14.0, 15.75, 14.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
	
	public static VoxelShape getShapeZ()
	{
		List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(0.0, 15.75, 0.0, 16.0, 16.0, 16.0));
	    shapes.add(Block.createCuboidShape(15.5, 15.0, 0.0, 16.0, 15.75, 16.0));
	    shapes.add(Block.createCuboidShape(0.5, 15.0, 0.0, 15.5, 15.75, 0.5));
	    shapes.add(Block.createCuboidShape(2.0, 14.75, 2.0, 14.0, 15.75, 3.0));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 0.0, 0.5, 15.75, 16.0));
	    shapes.add(Block.createCuboidShape(0.5, 15.0, 15.5, 15.5, 15.75, 16.0));
	    shapes.add(Block.createCuboidShape(2.0, 14.75, 5.6, 14.0, 15.75, 6.6));
	    shapes.add(Block.createCuboidShape(2.0, 14.75, 9.4, 14.0, 15.75, 10.4));
	    shapes.add(Block.createCuboidShape(2.0, 14.75, 13.0, 14.0, 15.75, 14.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
}
