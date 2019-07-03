package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.items.AWPGun;
import fr.opineppes.minecraft.ageevolution.items.BunkerDoorDoor;
import fr.opineppes.minecraft.ageevolution.items.MagicWand;
import fr.opineppes.minecraft.ageevolution.items.FnScarGun;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AgeEvolutionItems {
	//Items
	public static final Item MAGIC_WAND = new MagicWand(new Item.Settings().group(AgeEvolutionItemGroups.GROUP_GUNS));
	public static final Item AWP_GUN = new AWPGun(new Item.Settings().group(AgeEvolutionItemGroups.GROUP_GUNS));
	public static final Item FN_SCAR_GUN = new FnScarGun(new Item.Settings().group(AgeEvolutionItemGroups.GROUP_GUNS));
	public static final Item BUNKER_DOOR_DOOR = new BunkerDoorDoor(new Item.Settings().group(AgeEvolutionItemGroups.GROUP_ITEMS));
	
	//ItemsBlocks
	public static final Item COLORED_COBBLESTONE = new BlockItem(AgeEvolutionBlocks.COLORED_COBBLESTONE, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item FLOOR_TILES = new BlockItem(AgeEvolutionBlocks.FLOOR_TILES, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item FLOOR_TILE_DARK = new BlockItem(AgeEvolutionBlocks.FLOOR_TILE_DARK, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item FLOOR_TILE_LIGHT = new BlockItem(AgeEvolutionBlocks.FLOOR_TILE_LIGHT, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item SCHOOL_CHAIR = new BlockItem(AgeEvolutionBlocks.SCHOOL_CHAIR, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item SCHOOL_TABLE = new BlockItem(AgeEvolutionBlocks.SCHOOL_TABLE, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item CEILING_LIGHT = new BlockItem(AgeEvolutionBlocks.CEILING_LIGHT, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item CEILING_LIGHT_BARS = new BlockItem(AgeEvolutionBlocks.CEILING_LIGHT_BARS, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item CRACKED_FLOOR_TILES = new BlockItem(AgeEvolutionBlocks.CRACKED_FLOOR_TILES, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item IRON_PLATE = new BlockItem(AgeEvolutionBlocks.IRON_PLATE, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item CRYSTAL_BLOCK = new BlockItem(AgeEvolutionBlocks.CRYSTAL_BLOCK, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item PINK_CRYSTAL_BLOCK = new BlockItem(AgeEvolutionBlocks.PINK_CRYSTAL_BLOCK, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item PURPLE_CRYSTAL_BLOCK = new BlockItem(AgeEvolutionBlocks.PURPLE_CRYSTAL_BLOCK, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item BLUE_BRICKS = new BlockItem(AgeEvolutionBlocks.BLUE_BRICKS, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item FIRE_EXTINGUISHER = new BlockItem(AgeEvolutionBlocks.FIRE_EXTINGUISHER, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item BUNKER_DOOR_CORNER_DECO = new BlockItem(AgeEvolutionBlocks.BUNKER_DOOR_CORNER_DECO, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item BUNKER_DOOR_SIDE_DECO = new BlockItem(AgeEvolutionBlocks.BUNKER_DOOR_SIDE_DECO, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	public static final Item COLORED_COBBLESTONE_STAIRS = new BlockItem(AgeEvolutionBlocks.COLORED_COBBLESTONE_STAIRS, new Item.Settings().group(AgeEvolutionItemGroups.GROUP_DECO));
	
	public static void registerAllItems()
	{
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "magic_wand"), MAGIC_WAND);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "awp_gun"), AWP_GUN);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "fn_scar_gun"), FN_SCAR_GUN);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "bunker_door_door"), BUNKER_DOOR_DOOR);
		
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "colored_cobblestone"), COLORED_COBBLESTONE);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "floor_tiles"), FLOOR_TILES);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "floor_tile_dark"), FLOOR_TILE_DARK);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "floor_tile_light"), FLOOR_TILE_LIGHT);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "school_chair"), SCHOOL_CHAIR);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "school_table"), SCHOOL_TABLE);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "ceiling_light"), CEILING_LIGHT);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "ceiling_light_bars"), CEILING_LIGHT_BARS);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "cracked_floor_tiles"), CRACKED_FLOOR_TILES);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "iron_plate"), IRON_PLATE);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "crystal_block"), CRYSTAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "pink_crystal_block"), PINK_CRYSTAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "purple_crystal_block"), PURPLE_CRYSTAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "blue_bricks"), BLUE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "fire_extinguisher"), FIRE_EXTINGUISHER);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "bunker_door_corner_deco"), BUNKER_DOOR_CORNER_DECO);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "bunker_door_side_deco"), BUNKER_DOOR_SIDE_DECO);
		Registry.register(Registry.ITEM, new Identifier("ageevolution", "colored_cobblestone_stairs"), COLORED_COBBLESTONE_STAIRS);
	}
}
