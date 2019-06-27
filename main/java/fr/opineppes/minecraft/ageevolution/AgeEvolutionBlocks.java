package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.blocks.CeilingLight;
import fr.opineppes.minecraft.ageevolution.blocks.CeilingLightBars;
import fr.opineppes.minecraft.ageevolution.blocks.SchoolChair;
import fr.opineppes.minecraft.ageevolution.blocks.SchoolTable;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AgeEvolutionBlocks {
	//Blocs complet
	public static final Block COLORED_COBBLESTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).build());
	public static final Block FLOOR_TILES = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).build());
	public static final Block FLOOR_TILE_DARK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).build());
	public static final Block FLOOR_TILE_LIGHT = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).build());
	public static final Block CRACKED_FLOOR_TILES = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).build());
	
	//Blocs avec un model perso
	public static final Block SCHOOL_CHAIR = new SchoolChair(FabricBlockSettings.of(Material.METAL).breakByHand(true).strength(2.0F, 3.0F).build());
	public static final Block SCHOOL_TABLE = new SchoolTable(FabricBlockSettings.of(Material.METAL).breakByHand(true).strength(2.0F, 3.0F).build());
	public static final Block FIRE_EXTINGUISHER = new Block(FabricBlockSettings.of(Material.METAL).breakByHand(true).strength(2.0F, 3.0F).build());
	public static final Block CEILING_LIGHT = new CeilingLight(FabricBlockSettings.of(Material.METAL).breakByHand(true).strength(2.0F, 3.0F).noCollision().lightLevel(15).build());
	public static final Block CEILING_LIGHT_BARS = new CeilingLightBars(FabricBlockSettings.of(Material.METAL).breakByHand(true).strength(2.0F, 3.0F).noCollision().lightLevel(15).build());

	public static void registerAllBlocks()
	{
		//Pour enregistrer un item de bloc, se rendre dans AgeEvolutionItems
		
		//Blocs complet
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "colored_cobblestone"), COLORED_COBBLESTONE);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "floor_tiles"), FLOOR_TILES);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "floor_tile_dark"), FLOOR_TILE_DARK);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "floor_tile_light"), FLOOR_TILE_LIGHT);
		
		//Blocs avec un model perso
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "school_chair"), SCHOOL_CHAIR);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "school_table"), SCHOOL_TABLE);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "ceiling_light"), CEILING_LIGHT);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "ceiling_light_bars"), CEILING_LIGHT_BARS);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "cracked_floor_tiles"), CRACKED_FLOOR_TILES);
		Registry.register(Registry.BLOCK, new Identifier("ageevolution", "fire_extinguisher"), FIRE_EXTINGUISHER);
	}
}
