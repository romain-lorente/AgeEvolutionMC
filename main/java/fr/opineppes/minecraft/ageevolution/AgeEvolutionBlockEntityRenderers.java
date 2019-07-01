package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.blockentities.BunkerDoorBlockEntity;
import fr.opineppes.minecraft.ageevolution.blockentityrenderers.BunkerDoorBlockEntityRenderer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;

public class AgeEvolutionBlockEntityRenderers {
	
	public static void registerAllBlockEntityRenderers()
	{
		BlockEntityRendererRegistry.INSTANCE.register(BunkerDoorBlockEntity.class, new BunkerDoorBlockEntityRenderer());
	}
}
