package com.example.guardianexpansion;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardianExpansion implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("guardian-expansion");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}