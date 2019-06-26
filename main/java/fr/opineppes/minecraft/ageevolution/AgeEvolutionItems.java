package fr.opineppes.minecraft.ageevolution;

import fr.opineppes.minecraft.ageevolution.items.AWPGun;
import fr.opineppes.minecraft.ageevolution.items.MagicWand;
import fr.opineppes.minecraft.ageevolution.items.FnScarGun;
import net.minecraft.item.Item;

public class AgeEvolutionItems {
	public static final Item MAGIC_WAND = new MagicWand(new Item.Settings().group(AgeEvolution.GROUP_GUNS));
	public static final Item AWP_GUN = new AWPGun(new Item.Settings().group(AgeEvolution.GROUP_GUNS));
	public static final Item FN_SCAR_GUN = new FnScarGun(new Item.Settings().group(AgeEvolution.GROUP_GUNS));
}
