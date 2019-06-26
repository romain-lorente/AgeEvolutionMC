package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.entities.ChairRidableEntity;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;

public class AgeEvolutionEntities {
	public static final EntityType<ChairRidableEntity> CHAIR = FabricEntityTypeBuilder.create(EntityCategory.MISC, ChairRidableEntity::new).size(new EntitySize(1, 1, false)).build();
}
