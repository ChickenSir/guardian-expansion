package com.example.guardianexpansion;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardianExpansion implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("guardian-expansion");

	public static final String modID = "guardianexpansion";
	public static final String modName = "Guardian Expansion";

	// Item Group For Modded Content

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}