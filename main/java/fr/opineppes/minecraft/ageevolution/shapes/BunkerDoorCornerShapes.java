package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class BunkerDoorCornerShapes {

    public static final VoxelShape BOTTOM_EAST = getBottomEastShape();
    public static final VoxelShape BOTTOM_NORTH = getBottomNorthShape();
    public static final VoxelShape BOTTOM_SOUTH = getBottomSouthShape();
    public static final VoxelShape BOTTOM_WEST = getBottomWestShape();
    
    public static final VoxelShape TOP_EAST = getTopEastShape();
    public static final VoxelShape TOP_NORTH = getTopNorthShape();
    public static final VoxelShape TOP_SOUTH = getTopSouthShape();
    public static final VoxelShape TOP_WEST = getTopWestShape();

    public static VoxelShape getBottomEastShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(7.0, 0.0, 4.0, 16.0, 4.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 4.0, 4.0, 12.0, 5.0, 12.0));
        shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 7.0, 7.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 6.0, 4.0, 8.0, 7.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 5.0, 4.0, 9.0, 6.0, 12.0));
        shapes.add(Block.createCuboidShape(0.0, 7.0, 4.0, 4.0, 16.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 4.0, 5.0, 12.0, 12.0));
        shapes.add(Block.createCuboidShape(5.0, 7.0, 4.0, 6.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(6.0, 7.0, 4.0, 7.0, 8.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getBottomNorthShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 4.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 4.0, 4.0, 12.0, 5.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 0.0, 9.0, 12.0, 7.0, 16.0));
        shapes.add(Block.createCuboidShape(4.0, 6.0, 8.0, 12.0, 7.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 5.0, 7.0, 12.0, 6.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 12.0, 12.0, 16.0, 16.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 11.0, 12.0, 12.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 10.0, 12.0, 9.0, 11.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 9.0, 12.0, 8.0, 10.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getBottomSouthShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 0.0, 7.0, 12.0, 4.0, 16.0));
        shapes.add(Block.createCuboidShape(4.0, 4.0, 7.0, 12.0, 5.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 7.0, 7.0));
        shapes.add(Block.createCuboidShape(4.0, 6.0, 7.0, 12.0, 7.0, 8.0));
        shapes.add(Block.createCuboidShape(4.0, 5.0, 7.0, 12.0, 6.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 0.0, 12.0, 16.0, 4.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 4.0, 12.0, 12.0, 5.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 5.0, 12.0, 9.0, 6.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 6.0, 12.0, 8.0, 7.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getBottomWestShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 9.0, 4.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 4.0, 4.0, 9.0, 5.0, 12.0));
        shapes.add(Block.createCuboidShape(9.0, 0.0, 4.0, 16.0, 7.0, 12.0));
        shapes.add(Block.createCuboidShape(8.0, 6.0, 4.0, 9.0, 7.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 5.0, 4.0, 9.0, 6.0, 12.0));
        shapes.add(Block.createCuboidShape(12.0, 7.0, 4.0, 16.0, 16.0, 12.0));
        shapes.add(Block.createCuboidShape(11.0, 7.0, 4.0, 12.0, 12.0, 12.0));
        shapes.add(Block.createCuboidShape(10.0, 7.0, 4.0, 11.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(9.0, 7.0, 4.0, 10.0, 8.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getTopEastShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(7.0, 12.0, 4.0, 16.0, 16.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 11.0, 4.0, 12.0, 12.0, 12.0));
        shapes.add(Block.createCuboidShape(0.0, 9.0, 4.0, 7.0, 16.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 9.0, 4.0, 8.0, 10.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 10.0, 4.0, 9.0, 11.0, 12.0));
        shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 4.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 4.0, 4.0, 5.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(5.0, 7.0, 4.0, 6.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(6.0, 8.0, 4.0, 7.0, 9.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getTopNorthShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 12.0, 0.0, 12.0, 16.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 11.0, 4.0, 12.0, 12.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 9.0, 9.0, 12.0, 16.0, 16.0));
        shapes.add(Block.createCuboidShape(4.0, 9.0, 8.0, 12.0, 10.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 10.0, 7.0, 12.0, 11.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 0.0, 12.0, 12.0, 9.0, 16.0));
        shapes.add(Block.createCuboidShape(4.0, 4.0, 11.0, 12.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 10.0, 12.0, 9.0, 11.0));
        shapes.add(Block.createCuboidShape(4.0, 8.0, 9.0, 12.0, 9.0, 10.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getTopSouthShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 12.0, 7.0, 12.0, 16.0, 16.0));
        shapes.add(Block.createCuboidShape(4.0, 11.0, 7.0, 12.0, 12.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 9.0, 0.0, 12.0, 16.0, 7.0));
        shapes.add(Block.createCuboidShape(4.0, 9.0, 7.0, 12.0, 10.0, 8.0));
        shapes.add(Block.createCuboidShape(4.0, 10.0, 7.0, 12.0, 11.0, 9.0));
        shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 9.0, 4.0));
        shapes.add(Block.createCuboidShape(4.0, 4.0, 4.0, 12.0, 9.0, 5.0));
        shapes.add(Block.createCuboidShape(4.0, 7.0, 5.0, 12.0, 9.0, 6.0));
        shapes.add(Block.createCuboidShape(4.0, 8.0, 6.0, 12.0, 9.0, 7.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getTopWestShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(0.0, 12.0, 4.0, 9.0, 16.0, 12.0));
        shapes.add(Block.createCuboidShape(4.0, 11.0, 4.0, 9.0, 12.0, 12.0));
        shapes.add(Block.createCuboidShape(9.0, 9.0, 4.0, 16.0, 16.0, 12.0));
        shapes.add(Block.createCuboidShape(8.0, 9.0, 4.0, 9.0, 10.0, 12.0));
        shapes.add(Block.createCuboidShape(7.0, 10.0, 4.0, 9.0, 11.0, 12.0));
        shapes.add(Block.createCuboidShape(12.0, 0.0, 4.0, 16.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(11.0, 4.0, 4.0, 12.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(10.0, 7.0, 4.0, 11.0, 9.0, 12.0));
        shapes.add(Block.createCuboidShape(9.0, 8.0, 4.0, 10.0, 9.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

}