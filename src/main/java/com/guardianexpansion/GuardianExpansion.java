package com.guardianexpansion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guardianexpansion.Collections.BlocksCollection;
import com.guardianexpansion.Collections.ItemsCollection;

public class GuardianExpansion implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("guardian-expansion");

	public static final String modID = "guardianexpansion";
	public static final String modName = "Guardian Expansion";

	// Item Group For Modded Content
	private static final ItemGroup GUARDIAN_EXPANSION_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemsCollection.PRISMARINE_HELMET))
		.displayName(Text.translatable(modName))
		.entries((context, entries) -> {
			entries.add(ItemsCollection.PRISMARINE_SWORD);
			entries.add(ItemsCollection.PRISMARINE_PICKAXE);
			entries.add(ItemsCollection.PRISMARINE_AXE);
			entries.add(ItemsCollection.PRISMARINE_SHOVEL);
			entries.add(ItemsCollection.PRISMARINE_HOE);
			entries.add(ItemsCollection.PRISMARINE_HELMET);
			entries.add(ItemsCollection.PRISMARINE_CHESTPLATE);
			entries.add(ItemsCollection.PRISMARINE_LEGGINGS);
			entries.add(ItemsCollection.PRISMARINE_BOOTS);
			entries.add(ItemsCollection.GUARDIAN_BEAM);
			entries.add(ItemsCollection.ELDER_GUARDIAN_BEAM);
			entries.add(ItemsCollection.GUARDIAN_HELMET);
			entries.add(ItemsCollection.GUARDIAN_CHESTPLATE);
			entries.add(ItemsCollection.GUARDIAN_LEGGINGS);
			entries.add(ItemsCollection.GUARDIAN_BOOTS);
			entries.add(ItemsCollection.ELDER_PRISMARINE_SHARD);
			entries.add(ItemsCollection.ELDER_GUARDIAN_HELMET);
			entries.add(ItemsCollection.ELDER_GUARDIAN_CHESTPLATE);
			entries.add(ItemsCollection.ELDER_GUARDIAN_LEGGINGS);
			entries.add(ItemsCollection.ELDER_GUARDIAN_BOOTS);
			entries.add(ItemsCollection.OCEAN_UPGRADE_TEMPLATE);
			entries.add(BlocksCollection.ELDER_PRISMARINE);
			entries.add(BlocksCollection.ELDER_PRISMARINE_STAIRS);
			entries.add(BlocksCollection.ELDER_PRISMARINE_SLAB);
			entries.add(BlocksCollection.ELDER_PRISMARINE_WALL);
			entries.add(BlocksCollection.ELDER_PRISMARINE_BRICKS);
			entries.add(BlocksCollection.ELDER_PRISMARINE_BRICKS_STAIRS);
			entries.add(BlocksCollection.ELDER_PRISMARINE_BRICKS_SLAB);
			entries.add(BlocksCollection.ELDER_PRISMARINE_BRICKS_WALL);
			entries.add(BlocksCollection.ELDER_DARK_PRISMARINE);
			entries.add(BlocksCollection.ELDER_DARK_PRISMARINE_STAIRS);
			entries.add(BlocksCollection.ELDER_DARK_PRISMARINE_SLAB);
			entries.add(BlocksCollection.ELDER_DARK_PRISMARINE_WALL);
		})
		.build();

	@Override
	public void onInitialize() {
		// Register Items
		LOGGER.info("Registering Items!");

		ItemsCollection.Register(modID);

		// Register Blocks
		LOGGER.info("Registering Blocks!");

		BlocksCollection.Register(modID);

		// Register Item Group
		LOGGER.info("Registerting Item Group!");

		Registry.register(Registries.ITEM_GROUP, new Identifier(modID, "guardian_expansion_group"), GUARDIAN_EXPANSION_GROUP);
	}
}