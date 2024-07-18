package com.guardianexpansion.Projectiles;

import com.guardianexpansion.Collections.ItemsCollection;
import com.guardianexpansion.Collections.ProjectilesCollection;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class GuardianStaffProjectile extends ThrownItemEntity {
    public float damage;

    public GuardianStaffProjectile(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        damage = 6;
    }

    public GuardianStaffProjectile(World world, LivingEntity owner) {
        super(ProjectilesCollection.GUARDIAN_STAFF_PROJECTILE_ENTITY_TYPE, owner, world);
        damage = 6;
    }

    @Override
    protected Item getDefaultItem() {
        return ItemsCollection.GUARDIAN_STAFF_PROJ_ITEM;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof GuardianEntity) {
            entity.damage(this.getDamageSources().thrown(this, this.getOwner()), damage+2);
        }
        else if (entity instanceof ElderGuardianEntity) {
            entity.damage(this.getDamageSources().thrown(this, this.getOwner()), damage+2);
        } else {
            entity.damage(this.getDamageSources().thrown(this, this.getOwner()), damage);
        }

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 0, false, true, true));
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
    
}
