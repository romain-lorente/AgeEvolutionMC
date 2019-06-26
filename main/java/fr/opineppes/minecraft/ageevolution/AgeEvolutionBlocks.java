package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.blocks.CeilingLight;
import fr.opineppes.minecraft.ageevolution.blocks.CeilingLightBars;
import fr.opineppes.minecraft.ageevolution.blocks.SchoolChair;
import fr.opineppes.minecraft.ageevolution.blocks.SchoolTable;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class AgeEvolutionBlocks {
	//Cube
	public static final Block COLORED_COBBLESTONE = new Block(FabricBlockSettings.of(Material.STONE).build());
	public static final Block FLOOR_TILES = new Block(FabricBlockSettings.of(Material.STONE).build());
	public static final Block FLOOR_TILE_DARK = new Block(FabricBlockSettings.of(Material.STONE).build());
	public static final Block FLOOR_TILE_LIGHT = new Block(FabricBlockSettings.of(Material.STONE).build());
	
	//Avec model perso
	public static final Block SCHOOL_CHAIR = new SchoolChair(FabricBlockSettings.of(Material.METAL).build());
	public static final Block SCHOOL_TABLE = new SchoolTable(FabricBlockSettings.of(Material.METAL).build());
	public static final Block CEILING_LIGHT = new CeilingLight(FabricBlockSettings.of(Material.METAL).noCollision().lightLevel(15).build());
	public static final Block CEILING_LIGHT_BARS = new CeilingLightBars(FabricBlockSettings.of(Material.METAL).noCollision().lightLevel(15).build());
}