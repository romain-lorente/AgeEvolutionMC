package fr.opineppes.minecraft.ageevolution.events;

import java.util.List;

import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldTickEventListener implements WorldTickCallback {

	@Override
	public void tick(World world) {
		if(world instanceof ServerWorld)
		{
			ServerWorld world2 = (ServerWorld) world;
			
			List<Entity> entities = world2.getEntities(EntityType.ITEM, (entity) -> { return true; });
			entities.forEach((entity) -> {
				ItemEntity item = (ItemEntity) entity;
				if(item.getAge() > 20)
				{
					if(item.getStack().getItem() == Items.TORCH && item.onGround)
					{
						BlockPos pos = item.getBlockPos();
						
						world2.setBlockState(pos, Blocks.TORCH.getDefaultState());
						item.remove();
					}
				}
			});
		}
	}

}
