package com.incendium.item;

import com.incendium.tags.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.tag.ItemTags;

import java.util.function.Predicate;

public class RangedWeaponAmmo extends RangedWeaponItem {

    public static final Predicate<ItemStack> HOLY_PROJECTILES = (stack) -> {
        return stack.isIn(ModTags.HOLY);
    };

    public static final Predicate<ItemStack> MULTIPLEX_PROJECTILES = (stack) -> {
        return stack.isIn(ModTags.MULTI);
    };

    public RangedWeaponAmmo(Item.Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }

    @Override
    public int getRange() {
        return 0;
    }
}
