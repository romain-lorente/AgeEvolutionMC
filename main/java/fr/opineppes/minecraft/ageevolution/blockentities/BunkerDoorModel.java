package fr.opineppes.minecraft.ageevolution.blockentities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.model.Model;

@Environment(EnvType.CLIENT)
public class BunkerDoorModel extends Model {

    private Cuboid Corner;
    private Cuboid Center;
    private Cuboid Valve;
    private Cuboid Side;

    public BunkerDoorModel() {
        
    //Corner
        this.Corner = new Cuboid(this, 0, 0).setTextureSize(16, 16);
        this.Corner.addBox(12F, 0F, 4.0F, 4, 4, 8);
        this.Corner.addBox(4F, 0F, 4.0F, 8, 4, 8);
        this.Corner.addBox(12F, 4F, 4.0F, 4, 8, 8);
        this.Corner.addBox(5F, 4.0F, 4.0F, 4, 3, 8);
        this.Corner.addBox(7F, 7.0F, 4.0F, 2, 2, 8);
        this.Corner.addBox(9F, 7.0F, 4.0F, 3, 4, 8);
        this.Corner.addBox(6F, 7.0F, 4.0F, 1, 1, 8);
        this.Corner.addBox(8F, 9.0F, 4.0F, 1, 1, 8);
        this.Corner.addBox(9F, 4.0F, 4.0F, 3, 3, 8);
        this.Corner.rotationPointX = 0.0F;
        this.Corner.rotationPointY = 0.0F;
        this.Corner.rotationPointZ = 0.0F;
    //Center
        this.Center = new Cuboid(this, 0, 0).setTextureSize(16, 16);
        this.Center.addBox(0.0F, 0.0F, 4.0F, 16, 16, 8);
        this.Center.rotationPointX = 0.0F;
        this.Center.rotationPointY = 0.0F;
        this.Center.rotationPointZ = 0.0F;
    //Valve
        this.Valve = new Cuboid(this, 0, 0).setTextureSize(16, 16);
        this.Valve.addBox(7.0F, 7.0F, 2.0F, 2, 2, 2);
        this.Valve.addBox(7.0F, 9.0F, 2.0F, 2, 4, 1);
        this.Valve.addBox(6.0F, 2.0F, 2.0F, 4, 1, 1);
        this.Valve.addBox(4.0F, 12.0F, 2.0F, 2, 1, 1);
        this.Valve.addBox(10.0F, 12.0F, 2.0F, 2, 1, 1);
        this.Valve.addBox(10.0F, 3.0F, 2.0F, 2, 1, 1);
        this.Valve.addBox(4.0F, 3.0F, 2.0F, 2, 1, 1);
        this.Valve.addBox(3.0F, 4.0F, 2.0F, 1, 2, 1);
        this.Valve.addBox(12.0F, 4.0F, 2.0F, 1, 2, 1);
        this.Valve.addBox(12.0F, 10.0F, 2.0F, 1, 2, 1);
        this.Valve.addBox(3.0F, 10.0F, 2.0F, 1, 2, 1);
        this.Valve.addBox(2.0F, 6.0F, 2.0F, 1, 4, 1);
        this.Valve.addBox(13.0F, 6.0F, 2.0F, 1, 4, 1);
        this.Valve.addBox(7.0F, 3.0F, 2.0F, 2, 4, 1);
        this.Valve.addBox(6.0F, 13.0F, 2.0F, 4, 1, 1);
        this.Valve.addBox(3.0F, 7.0F, 2.0F, 4, 2, 1);
        this.Valve.addBox(9.0F, 7.0F, 2.0F, 4, 2, 1);
        this.Valve.rotationPointX = 0.0F;
        this.Valve.rotationPointY = 0.0F;
        this.Valve.rotationPointZ = 0.0F;
    //CenterRight
        this.Side = new Cuboid(this, 0, 0).setTextureSize(16, 16);
        this.Side.addBox(0F, 4F, 4.0F, 16, 12, 8);
        this.Side.rotationPointX = 0.0F;
        this.Side.rotationPointY = 0.0F;
        this.Side.rotationPointZ = 0.0F;
    }
    
    public void renderCorner()
    {
    	this.Corner.render(0.0625F);
    }
    
    public void renderCenter()
    {
    	this.Center.render(0.0625F);
    }
    
    public void renderValve()
    {
    	this.Valve.render(0.0625F);
    }
    
    public void renderSide()
    {
    	this.Side.render(0.0625F);
    }
}
