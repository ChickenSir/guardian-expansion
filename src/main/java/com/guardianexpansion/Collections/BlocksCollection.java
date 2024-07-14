package com.guardianexpansion.Collections;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;

public class BlocksCollection {
    // Mod Blocks
    public static final Block ELDER_PRISMARINE = new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_PRISMARINE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS).requiresTool());
    public static final Block ELDER_DARK_PRISMARINE = new Block(FabricBlockSettings.copyOf(Blocks.DARK_PRISMARINE).requiresTool());

    public static void Register(String modID) {
        // Register Blocks
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine"), ELDER_PRISMARINE);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine"), new BlockItem(ELDER_PRISMARINE, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_bricks"), ELDER_PRISMARINE_BRICKS);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_bricks"), new BlockItem(ELDER_PRISMARINE_BRICKS, new FabricItemSettings()));
        
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_dark_prismarine"), ELDER_DARK_PRISMARINE);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_dark_prismarine"), new BlockItem(ELDER_DARK_PRISMARINE, new FabricItemSettings()));
    }
}
