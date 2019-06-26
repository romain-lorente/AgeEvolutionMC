package fr.opineppes.minecraft.ageevolution.items;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicWand extends Item {

	public MagicWand(Settings item$Settings_1) {
		super(item$Settings_1);
		
	}
	
	public boolean useOnEntity(ItemStack itemStack_1, PlayerEntity playerEntity_1, LivingEntity livingEntity_1, Hand hand_1) {
		livingEntity_1.addVelocity(0F, 0.9F, 0F);
		return true;
	}
	
	public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
		World world = itemUsageContext_1.getWorld();
		BlockPos blockPos = itemUsageContext_1.getBlockPos();
		
		BlockState blockState = world.getBlockState(blockPos);
		
		Random random = new Random();
		
		float x = random.nextFloat() * 1.2F - 0.6F;
		float z = random.nextFloat() * 1.2F - 0.6F;
		
		FallingBlockEntity entity = new FallingBlockEntity(world, blockPos.getX() + 0.5F, blockPos.getY() + 0.5F, blockPos.getZ() + 0.5F, blockState);
		entity.addVelocity(x, 0.6F, z);
		
		itemUsageContext_1.getWorld().spawnEntity(entity);
		return ActionResult.SUCCESS;
	}

}
