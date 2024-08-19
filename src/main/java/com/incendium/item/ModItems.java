package com.incendium.item;
import com.incendium.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.ItemGroup;
import com.incendium.Inmodium;

public class ModItems {
    public static final Item MULTIPLEX_CROSSBOW = regsiterItem("multiplex",
            new MultiplexCrossbowItem(new FabricItemSettings().maxDamage(198).group(ItemGroup.COMBAT)));

    public static final Item FISTFULL_OF_ARROWS = regsiterItem("fistfull_of_arrows",
            new Item (new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item HOLY_WRATH = regsiterItem("holy_wrath",
            new HolyWrathCrossbowItem(new FabricItemSettings().maxDamage(323).group(ItemGroup.COMBAT)));
    public static final Item SENTRYS_WRATH = regsiterItem("sentrys_wrath",
            new SentrysWrathCrossbowItem(new FabricItemSettings().maxDamage(256).group(ItemGroup.COMBAT)));

    public static final Item FIRESTORM = regsiterItem("firestorm",
            new FirestormCrossbowItem(new FabricItemSettings().maxDamage(323).group(ItemGroup.COMBAT)));

    public static final Item TRAILBLAZER = regsiterItem("trailblazer",
            new TrailblazerBowItem(new FabricItemSettings().maxDamage(123).group(ItemGroup.COMBAT)));


    private static Item regsiterItem(String name, Item item) {
        return Registry.register(Registry.ITEM, Inmodium.id(name), item);
    }

    public static void registerModItems() {
        Inmodium.LOGGER.info("Registering Mod Items for " + Inmodium.MOD_ID);
    }

}