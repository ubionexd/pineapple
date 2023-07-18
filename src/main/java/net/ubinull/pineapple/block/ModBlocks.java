package net.ubinull.pineapple.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ubinull.pineapple.Pineapple;
import net.ubinull.pineapple.block.custom.PineappleBlock;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {
	public static final Block PINEAPPLE = registerBlock("pineapple", new PineappleBlock(QuiltBlockSettings.copyOf(Blocks.PUMPKIN).nonOpaque().breakInstantly()));

	private static void buildingBlocksItemGroupAdd(FabricItemGroupEntries entries) {
		entries.addItem(PINEAPPLE);
	}

	public static void registerModBlocks() {
		Pineapple.LOGGER.debug("Registering blocks for {}", Pineapple.MOD_ID);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::buildingBlocksItemGroupAdd);
	}

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(Pineapple.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(Pineapple.MOD_ID, name), new BlockItem(block, new QuiltItemSettings()));

	}
}
