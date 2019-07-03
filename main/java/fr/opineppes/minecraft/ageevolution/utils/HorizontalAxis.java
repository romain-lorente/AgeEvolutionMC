package fr.opineppes.minecraft.ageevolution.utils;

import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;

public enum HorizontalAxis implements StringIdentifiable {
	X("x")
	{
		@Override
		public Direction getDirection(float yaw) {
			int ind = MathHelper.abs(MathHelper.floor(yaw / 90.0D) & 3) % 4;
			return ind == 0 || ind == 1 ? Direction.WEST : Direction.EAST;
		}
		
		@Override
		public Direction getPerpendDirection(float yaw) {
			int ind = MathHelper.abs(MathHelper.floor(yaw / 90.0D) & 3) % 4;
			return ind == 0 || ind == 3 ? Direction.SOUTH : Direction.NORTH;
		}

		@Override
		public float getOffsetX() {
			return 1;
		}
		
		@Override
		public float getOffsetZ() {
			return 0;
		}
	},
	Z("z")
	{
		@Override
		public Direction getDirection(float yaw) {
			int ind = MathHelper.abs(MathHelper.floor(yaw / 90.0D) & 3) % 4;
			return ind == 0 || ind == 3 ? Direction.SOUTH : Direction.NORTH;
		}
		
		@Override
		public Direction getPerpendDirection(float yaw) {
			int ind = MathHelper.abs(MathHelper.floor(yaw / 90.0D) & 3) % 4;
			return ind == 0 || ind == 1 ? Direction.WEST : Direction.EAST;
		}

		@Override
		public float getOffsetX() {
			return 0;
		}
		
		@Override
		public float getOffsetZ() {
			return 1;
		}
	};
	
	private String id;
	
	private HorizontalAxis(String id) {
		this.id = id;
	}
	
	@Override
	public String asString() {
		return id;
	}
	
	public abstract Direction getDirection(float yaw);
	public abstract Direction getPerpendDirection(float yaw);
	public abstract float getOffsetX();
	public abstract float getOffsetZ();
	
	public static HorizontalAxis fromDirection(Direction direction)
	{
		if(direction == Direction.NORTH ||direction == Direction.SOUTH)
			return Z;
	
		if(direction == Direction.EAST || direction == Direction.WEST)
			return X;
		
		return null;
	}
	
	public static HorizontalAxis fromPerpendDirection(Direction direction)
	{
		if(direction == Direction.NORTH ||direction == Direction.SOUTH)
			return X;
	
		if(direction == Direction.EAST || direction == Direction.WEST)
			return Z;
		
		return null;
	}
}
