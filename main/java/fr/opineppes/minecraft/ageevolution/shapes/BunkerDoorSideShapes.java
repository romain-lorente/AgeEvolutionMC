package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class BunkerDoorSideShapes {
	
	//BOTTOM Shapes
	public static final VoxelShape Z_BOTTOM = getBottomZShape();
	public static final VoxelShape X_BOTTOM = getBottomXShape();
	
	//TOP Shapes
	public static final VoxelShape Z_TOP = getTopZShape();
	public static final VoxelShape X_TOP = getTopXShape();
	
	//SIDE Shapes
	public static final VoxelShape NORTH_SIDE = getNorthSideShape();
	public static final VoxelShape SOUTH_SIDE = getSouthSideShape();
	public static final VoxelShape EAST_SIDE = getEastSideShape();
	public static final VoxelShape WEST_SIDE = getWestSideShape();

	public static VoxelShape getEastSideShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 4.0, 16.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getNorthSideShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 0.0, 12.0, 12.0, 16.0, 16.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getSouthSideShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 16.0, 4.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getWestSideShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(12.0, 0.0, 4.0, 16.0, 16.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }
	
	public static VoxelShape getBottomZShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 4.0, 12.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getBottomXShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 4.0, 16.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getTopXShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(4.0, 12.0, 0.0, 12.0, 16.0, 16.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}

	public static VoxelShape getTopZShape()
	{
	    List<VoxelShape> shapes = new ArrayList<VoxelShape>();
	    
	    shapes.add(Block.createCuboidShape(0.0, 12.0, 4.0, 16.0, 16.0, 12.0));
	    
	    VoxelShape result = VoxelShapes.empty();
	    for(VoxelShape shape : shapes)
	    {
	        result = VoxelShapes.union(result, shape);
	    }
	    
	    return result.simplify();
	}
}
