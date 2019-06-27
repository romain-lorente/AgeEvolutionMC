package fr.opineppes.minecraft.ageevolution.events;

import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.fabricmc.fabric.mixin.resources.MixinKeyedResourceReloadListener.Server;
import net.fabricmc.loom.providers.MinecraftAssetsProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class WorldTickEventListener implements WorldTickCallback {

	@Override
	public void tick(World world) {
		if(!world.isClient())
		{
			ServerWorld world2 = (ServerWorld) world;
		}
	}

}
