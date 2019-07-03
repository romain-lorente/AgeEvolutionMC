package fr.opineppes.minecraft.ageevolution.items;

import fr.opineppes.minecraft.ageevolution.blocks.BunkerDoorStructure;
import fr.opineppes.minecraft.ageevolution.blueprints.BunkerDoorBlueprint;
import fr.opineppes.minecraft.ageevolution.blueprints.structures.BunkerDoorObject;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BunkerDoorDoor extends Item {

	public BunkerDoorDoor(Settings item$Settings_1) {
		super(item$Settings_1);
	}
	
	public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
		World world = itemUsageContext_1.getWorld();
		BlockPos startBlockPos = itemUsageContext_1.getBlockPos();
	    BlockState startBlockState = world.getBlockState(startBlockPos);
	    if(startBlockState.getBlock() instanceof BunkerDoorStructure)
	    {
			float yaw = itemUsageContext_1.getPlayerYaw();
	    	BunkerDoorBlueprint doorBlueprint = BunkerDoorBlueprint.create(world, startBlockPos, startBlockState, yaw).verifyStructure();
	    	
	    	if(doorBlueprint.isValid())
	    	{
	    		if(!world.isClient)
	    		{
		    		BunkerDoorObject door = doorBlueprint.build();
		    		door.construct();
	    		}
		    	return ActionResult.SUCCESS;
	    	}
	    	else if(world.isClient)
	    	{
	    		itemUsageContext_1.getPlayer().sendMessage(new TextComponent(doorBlueprint.getErrorMessage()));
	    	}
	    }
		return ActionResult.PASS;
	}

}
