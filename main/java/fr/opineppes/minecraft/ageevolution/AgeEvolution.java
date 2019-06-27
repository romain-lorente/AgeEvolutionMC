package fr.opineppes.minecraft.ageevolution;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AgeEvolution implements ModInitializer {
	
	public static final ItemGroup GROUP_GUNS = FabricItemGroupBuilder.build(new Identifier("ageevolution", "guns"), () -> new ItemStack(AgeEvolutionItems.AWP_GUN));
	public static final ItemGroup GROUP_DECO = FabricItemGroupBuilder.build(new Identifier("ageevolution", "guns"), () -> new ItemStack(AgeEvolutionBlocks.COLORED_COBBLESTONE));
	
	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "colored_cobblestone"), AgeEvolutionBlocks.COLORED_COBBLESTONE);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "floor_tiles"), AgeEvolutionBlocks.FLOOR_TILES);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "floor_tile_dark"), AgeEvolutionBlocks.FLOOR_TILE_DARK);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "floor_tile_light"), AgeEvolutionBlocks.FLOOR_TILE_LIGHT);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "school_chair"), AgeEvolutionBlocks.SCHOOL_CHAIR);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "school_table"), AgeEvolutionBlocks.SCHOOL_TABLE);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "ceiling_light"), AgeEvolutionBlocks.CEILING_LIGHT);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "ceiling_light_bars"), AgeEvolutionBlocks.CEILING_LIGHT_BARS);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "cracked_floor_tiles"), AgeEvolutionBlocks.CRACKED_FLOOR_TILES);
		
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "magic_wand"), AgeEvolutionItems.MAGIC_WAND);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "awp_gun"), AgeEvolutionItems.AWP_GUN);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "fn_scar_gun"), AgeEvolutionItems.FN_SCAR_GUN);
		
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "colored_cobblestone"), new BlockItem(AgeEvolutionBlocks.COLORED_COBBLESTONE, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "floor_tiles"), new BlockItem(AgeEvolutionBlocks.FLOOR_TILES, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "floor_tile_dark"), new BlockItem(AgeEvolutionBlocks.FLOOR_TILE_DARK, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "floor_tile_light"), new BlockItem(AgeEvolutionBlocks.FLOOR_TILE_LIGHT, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "school_chair"), new BlockItem(AgeEvolutionBlocks.SCHOOL_CHAIR, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "school_table"), new BlockItem(AgeEvolutionBlocks.SCHOOL_TABLE, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "ceiling_light"), new BlockItem(AgeEvolutionBlocks.CEILING_LIGHT, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "ceiling_light_bars"), new BlockItem(AgeEvolutionBlocks.CEILING_LIGHT_BARS, new Item.Settings().group(GROUP_DECO)));
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "cracked_floor_tiles"), new BlockItem(AgeEvolutionBlocks.CRACKED_FLOOR_TILES, new Item.Settings().group(GROUP_DECO)));
		
		//Registry.register(Registry.ENTITY_TYPE, new Identifier("ageevolution", "chair"), AgeEvolutionEntities.CHAIR);
	}
}
