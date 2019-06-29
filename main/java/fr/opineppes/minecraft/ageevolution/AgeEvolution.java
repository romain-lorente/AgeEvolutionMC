package fr.opineppes.minecraft.ageevolution;

import net.fabricmc.api.ModInitializer;

public class AgeEvolution implements ModInitializer {

	@Override
	public void onInitialize() {
		
		//Deplacement des enregistrement dans les fichier respectif
		AgeEvolutionBlocks.registerAllBlocks();
		AgeEvolutionItems.registerAllItems();
		AgeEvolutionsBlockEntities.registerAllBlockEntities();
		
		//Registry.register(Registry.ENTITY_TYPE, new Identifier("ageevolution", "chair"), AgeEvolutionEntities.CHAIR);
		
		//WorldTickCallback.EVENT.register(new WorldTickEventListener());
	}
}
