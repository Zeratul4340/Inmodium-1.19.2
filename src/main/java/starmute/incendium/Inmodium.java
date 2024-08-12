package starmute.incendium;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starmute.incendium.item.ModItems;

public class Inmodium implements ModInitializer {
	public static final String MOD_ID = "incendium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Awaken my child, and know that I am the Overmind...");
		ModItems.registerModItems();
	}

	//koolkid94 was here
	//omicron43 was also here hi hello
}