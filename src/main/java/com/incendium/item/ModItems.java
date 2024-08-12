package com.incendium.item;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.ItemGroup;
import com.incendium.Inmodium;
import com.incendium.item.custom.MultiplexCrossbowItem;

public class ModItems {
    public static final Item MULTIPLEX_CROSSBOW = regsiterItem("multiplex",
            new MultiplexCrossbowItem(new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item FISTFULL_OF_ARROWS = regsiterItem("fistfull_of_arrows",
            new Item (new FabricItemSettings().group(ItemGroup.COMBAT)));


    private static Item regsiterItem(String name, Item item) {
        return Registry.register(Registry.ITEM, Inmodium.id(name), item);
    }

    public static void registerModItems() {
        Inmodium.LOGGER.info("Registering Mod Items for " + Inmodium.MOD_ID);
    }

}