package com.guardianexpansion;

import com.guardianexpansion.Collections.ProjectilesCollection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class GuardianExpansionClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityRendererRegistry.register(ProjectilesCollection.GUARDIAN_STAFF_PROJECTILE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
	}
}