package fr.opineppes.minecraft.ageevolution.shapes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class BunkerDoorClosedShapes {

    public static final VoxelShape X = getXShape();
    public static final VoxelShape Z = getZShape();

    public static VoxelShape getZShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 16.0, 16.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

    public static VoxelShape getXShape()
    {
        List<VoxelShape> shapes = new ArrayList<VoxelShape>();
        
        shapes.add(Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 16.0, 12.0));
        
        VoxelShape result = VoxelShapes.empty();
        for(VoxelShape shape : shapes)
        {
            result = VoxelShapes.union(result, shape);
        }
        
        return result.simplify();
    }

}