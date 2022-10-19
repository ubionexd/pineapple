package net.ubinull.pineapple.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ubinull.pineapple.Pineapple;
import net.ubinull.pineapple.block.custom.PineappleBlock;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {
	public static final Block PINEAPPLE = registerBlock("pineapple", new PineappleBlock(QuiltBlockSettings.of(Material.SOLID_ORGANIC).nonOpaque().breakInstantly()), ItemGroup.MISC);

	public static void registerModBlocks() {
		Pineapple.LOGGER.debug("Registering blocks for {}", Pineapple.MOD_ID);
	}

	private static Block registerBlock(String name, Block block, ItemGroup tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registry.BLOCK, new Identifier(Pineapple.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		return Registry.register(Registry.ITEM, new Identifier(Pineapple.MOD_ID, name), new BlockItem(block, new QuiltItemSettings().group(tab)));
	}
}
