package com.incendium.entity;

import com.incendium.Inmodium;
import com.incendium.entity.projectile.SentryProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public  static final EntityType<SentryProjectileEntity> SENTRY_PROJECTILE = Registry.register(Registry.ENTITY_TYPE,
            Inmodium.id("sentry_projectile"),
            FabricEntityTypeBuilder.<SentryProjectileEntity>create(SpawnGroup.MISC, SentryProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3125f, 0.3125f)).build());
}
