package com.incendium.entity.projectile;

import com.incendium.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class SentryProjectileEntity extends ExplosiveProjectileEntity {
    public SentryProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public SentryProjectileEntity(World world, LivingEntity owner, double directionX, double directionY, double directionZ) {
        super(ModEntities.SENTRY_PROJECTILE, owner, directionX, directionY, directionZ, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(){
        return new EntitySpawnS2CPacket(this);
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.world.isClient) {
            Entity entity = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            if (entity instanceof LivingEntity) {
                if (entity2 instanceof PlayerEntity) {
                    entity.damage(DamageSource.MAGIC, 9.0F);
                }
                else {
                    entity.damage(DamageSource.MAGIC, 5.0F);
                }
            }

        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            System.out.println("This projectile collided at x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.getZ());
            Explosion.DestructionType destructionType =  Explosion.DestructionType.NONE;
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, destructionType);
            this.discard();
        }
    }

    public boolean canHit() {
        return false;
    }

    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    protected boolean isBurning() {
        return false;
    }
}
