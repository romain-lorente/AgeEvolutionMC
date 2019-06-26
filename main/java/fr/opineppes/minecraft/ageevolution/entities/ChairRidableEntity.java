package fr.opineppes.minecraft.ageevolution.entities;

import com.google.common.collect.Lists;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AbsoluteHand;
import net.minecraft.world.World;

public class ChairRidableEntity extends LivingEntity {

	public ChairRidableEntity(EntityType<? extends ChairRidableEntity> entityType_1, World world_1) {
		super(entityType_1, world_1);
	}

	@Override
	public Iterable<ItemStack> getArmorItems() {
		return Lists.newArrayList();
	}

	@Override
	public ItemStack getEquippedStack(EquipmentSlot var1) {
		return ItemStack.EMPTY;
	}

	@Override
	public void setEquippedStack(EquipmentSlot var1, ItemStack var2) {
	}

	@Override
	public AbsoluteHand getMainHand() {
		return AbsoluteHand.RIGHT;
	}
}
