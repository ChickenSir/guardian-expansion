package com.guardianexpansion.Collections;

import com.guardianexpansion.Projectiles.GuardianStaffProjectile;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ProjectilesCollection {
    // Mod Projectiles
    public static final EntityType<GuardianStaffProjectile> GUARDIAN_STAFF_PROJECTILE_ENTITY_TYPE = FabricEntityTypeBuilder.<GuardianStaffProjectile>create(
        SpawnGroup.MISC, GuardianStaffProjectile::new)
        .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build();

    public static void Register(String modID) {
        // Register Projectiles
        Registry.register(Registries.ENTITY_TYPE, new Identifier(modID, "guardian_staff_projectile"), GUARDIAN_STAFF_PROJECTILE_ENTITY_TYPE);
    }
}
