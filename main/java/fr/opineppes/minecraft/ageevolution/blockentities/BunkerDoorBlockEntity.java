package fr.opineppes.minecraft.ageevolution.blockentities;

import fr.opineppes.minecraft.ageevolution.AgeEvolutionsBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class BunkerDoorBlockEntity extends BlockEntity {

	private boolean closed = false;
	
	public BunkerDoorBlockEntity() {
		super(AgeEvolutionsBlockEntities.BUNKER_DOOR);
	}
	
	public boolean isClosed()
	{
		return closed;
	}
	
	@Override
	public void fromTag(CompoundTag compoundTag_1) {
		super.fromTag(compoundTag_1);
		
		this.closed = compoundTag_1.getBoolean("closed");
	}

	@Override
	public CompoundTag toTag(CompoundTag compoundTag_1) {
		
		compoundTag_1.putBoolean("closed", closed);
		
		return super.toTag(compoundTag_1);
	}
}
