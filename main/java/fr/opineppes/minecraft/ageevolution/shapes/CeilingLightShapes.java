package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class CeilingLightShapes {
	
	public static final VoxelShape SHAPE = getShape();
			
	public static VoxelShape getShape()
	{
		List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(1.0, 15.0, 1.0, 15.0, 16.0, 15.0));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 0.0, 16.0, 16.0, 1.0));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 15.0, 16.0, 16.0, 16.0));
	    shapes.add(Block.createCuboidShape(0.0, 15.0, 1.0, 1.0, 16.0, 15.0));
	    shapes.add(Block.createCuboidShape(15.0, 15.0, 1.0, 16.0, 16.0, 15.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
}
