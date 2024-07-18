package com.guardianexpansion.Projectiles;

import com.guardianexpansion.Collections.ItemsCollection;
import com.guardianexpansion.Collections.ProjectilesCollection;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
        damage = 2;
    }

    public GuardianStaffProjectile(World world, LivingEntity owner) {
        super(ProjectilesCollection.GUARDIAN_STAFF_PROJECTILE_ENTITY_TYPE, owner, world);
        damage = 2;
    }

    @Override
    protected Item getDefaultItem() {
        return ItemsCollection.GUARDIAN_STAFF_PROJ_ITEM;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        float i = entity instanceof GuardianEntity ? damage+2 : damage;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), i);
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
