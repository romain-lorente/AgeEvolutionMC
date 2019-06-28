package fr.opineppes.minecraft.ageevolution;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AgeEvolutionItemGroups {
	public static final ItemGroup GROUP_GUNS = FabricItemGroupBuilder.build(new Identifier("ageevolution", "guns"), () -> new ItemStack(AgeEvolutionItems.AWP_GUN));
	public static final ItemGroup GROUP_DECO = FabricItemGroupBuilder.build(new Identifier("ageevolution", "guns"), () -> new ItemStack(AgeEvolutionBlocks.COLORED_COBBLESTONE));
}
