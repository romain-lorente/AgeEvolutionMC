package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AgeEvolutionsBlockEntities {
	public static final BlockEntityType<BunkerDoorBlockEntity> BUNKER_DOOR = BlockEntityType.Builder.create(BunkerDoorBlockEntity::new, AgeEvolutionBlocks.BUNKER_DOOR_CORNER_ACTIVE, AgeEvolutionBlocks.BUNKER_DOOR_SIDE_ACTIVE, AgeEvolutionBlocks.BUNKER_DOOR_BARRIER).build(null);
	
	public static void registerAllBlockEntities()
	{
		Registry.register(Registry.BLOCK_ENTITY, new Identifier("ageevolution", "bunker_door"), BUNKER_DOOR);
	}
}
