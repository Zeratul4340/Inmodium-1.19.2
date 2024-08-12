package com.incendium.tags;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags.*;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ModTags {

    public static final TagKey<Item> HOLY = of("holy");

    public static final TagKey<Item> FIRE = of("firestorm");

    public static final TagKey<Item> MULTI = of("multiplex");

    private static TagKey<Item> of(String id) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(id));
    }

}
