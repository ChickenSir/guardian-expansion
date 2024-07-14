package com.guardianexpansion.Collections;

import com.guardianexpansion.Blocks.PrismarineConverter;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;

public class BlocksCollection {
    // Mod Blocks
    public static final Block ELDER_PRISMARINE = new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_PRISMARINE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS).requiresTool());
    public static final Block ELDER_DARK_PRISMARINE = new Block(FabricBlockSettings.copyOf(Blocks.DARK_PRISMARINE).requiresTool());

    public static final Block ELDER_PRISMARINE_STAIRS = new StairsBlock(ELDER_PRISMARINE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_PRISMARINE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_PRISMARINE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());

    public static final Block ELDER_PRISMARINE_BRICKS_STAIRS = new StairsBlock(ELDER_PRISMARINE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_PRISMARINE_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_PRISMARINE_BRICKS_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());

    public static final Block ELDER_DARK_PRISMARINE_STAIRS = new StairsBlock(ELDER_DARK_PRISMARINE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_DARK_PRISMARINE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());
    public static final Block ELDER_DARK_PRISMARINE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());

    public static final Block PRISMARINE_CONVERTER = new PrismarineConverter(FabricBlockSettings.copyOf(Blocks.PRISMARINE).requiresTool());

    public static void Register(String modID) {
        // Register Blocks
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine"), ELDER_PRISMARINE);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine"), new BlockItem(ELDER_PRISMARINE, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_bricks"), ELDER_PRISMARINE_BRICKS);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_bricks"), new BlockItem(ELDER_PRISMARINE_BRICKS, new FabricItemSettings()));
        
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_dark_prismarine"), ELDER_DARK_PRISMARINE);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_dark_prismarine"), new BlockItem(ELDER_DARK_PRISMARINE, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_stairs"), ELDER_PRISMARINE_STAIRS);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_stairs"), new BlockItem(ELDER_PRISMARINE_STAIRS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_slab"), ELDER_PRISMARINE_SLAB);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_slab"), new BlockItem(ELDER_PRISMARINE_SLAB, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_wall"), ELDER_PRISMARINE_WALL);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_wall"), new BlockItem(ELDER_PRISMARINE_WALL, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_bricks_stairs"), ELDER_PRISMARINE_BRICKS_STAIRS);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_bricks_stairs"), new BlockItem(ELDER_PRISMARINE_BRICKS_STAIRS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_bricks_slab"), ELDER_PRISMARINE_BRICKS_SLAB);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_bricks_slab"), new BlockItem(ELDER_PRISMARINE_BRICKS_SLAB, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_prismarine_bricks_wall"), ELDER_PRISMARINE_BRICKS_WALL);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_prismarine_bricks_wall"), new BlockItem(ELDER_PRISMARINE_BRICKS_WALL, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_dark_prismarine_stairs"), ELDER_DARK_PRISMARINE_STAIRS);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_dark_prismarine_stairs"), new BlockItem(ELDER_DARK_PRISMARINE_STAIRS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_dark_prismarine_slab"), ELDER_DARK_PRISMARINE_SLAB);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_dark_prismarine_slab"), new BlockItem(ELDER_DARK_PRISMARINE_SLAB, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(modID, "elder_dark_prismarine_wall"), ELDER_DARK_PRISMARINE_WALL);
        Registry.register(Registries.ITEM, new Identifier(modID, "elder_dark_prismarine_wall"), new BlockItem(ELDER_DARK_PRISMARINE_WALL, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(modID, "prismarine_converter"), PRISMARINE_CONVERTER);
        Registry.register(Registries.ITEM, new Identifier(modID, "prismarine_converter"), new BlockItem(PRISMARINE_CONVERTER, new FabricItemSettings()));
    }
}
