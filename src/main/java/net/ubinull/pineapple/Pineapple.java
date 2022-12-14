package net.ubinull.pineapple;

import net.ubinull.pineapple.block.ModBlocks;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pineapple implements ModInitializer {
	public static final String MOD_ID = "pineapple";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(ModContainer mod) {
		ModBlocks.registerModBlocks();

		LOGGER.info("{} mod loaded! Made by ubinull :)", mod.metadata().name());
	}
}
