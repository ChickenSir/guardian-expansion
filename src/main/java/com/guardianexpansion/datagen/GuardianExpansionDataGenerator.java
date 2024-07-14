package com.guardianexpansion.datagen;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.guardianexpansion.Collections.BlocksCollection;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

public class GuardianExpansionDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(GEBlockTagGenerator::new);
        pack.addProvider(GELootTableProvider::new);
        pack.addProvider(GEModelProvider::new);
        pack.addProvider(GERecipeProvider::new);
    }

    private static class GEBlockTagGenerator extends BlockTagProvider {

        public GEBlockTagGenerator(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(BlockTags.WALLS)
                .add(BlocksCollection.ELDER_PRISMARINE_WALL)
                .add(BlocksCollection.ELDER_PRISMARINE_BRICKS_WALL)
                .add(BlocksCollection.ELDER_DARK_PRISMARINE_WALL);

            getOrCreateTagBuilder(BlockTags.SLABS)
                .add(BlocksCollection.ELDER_PRISMARINE_SLAB)
                .add(BlocksCollection.ELDER_PRISMARINE_BRICKS_SLAB)
                .add(BlocksCollection.ELDER_DARK_PRISMARINE_SLAB);

            getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BlocksCollection.ELDER_PRISMARINE_STAIRS)
                .add(BlocksCollection.ELDER_PRISMARINE_BRICKS_STAIRS)
                .add(BlocksCollection.ELDER_DARK_PRISMARINE_STAIRS);
        }
        
    }

    private static class GELootTableProvider extends FabricBlockLootTableProvider {
        protected GELootTableProvider(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate() {
            addDrop(BlocksCollection.ELDER_PRISMARINE_STAIRS);
            addDrop(BlocksCollection.ELDER_PRISMARINE_SLAB, slabDrops(BlocksCollection.ELDER_PRISMARINE_SLAB));
            addDrop(BlocksCollection.ELDER_PRISMARINE_WALL);

            addDrop(BlocksCollection.ELDER_PRISMARINE_BRICKS_STAIRS);
            addDrop(BlocksCollection.ELDER_PRISMARINE_BRICKS_SLAB, slabDrops(BlocksCollection.ELDER_PRISMARINE_BRICKS_SLAB));
            addDrop(BlocksCollection.ELDER_PRISMARINE_BRICKS_WALL);

            addDrop(BlocksCollection.ELDER_DARK_PRISMARINE_STAIRS);
            addDrop(BlocksCollection.ELDER_DARK_PRISMARINE_SLAB, slabDrops(BlocksCollection.ELDER_DARK_PRISMARINE_SLAB));
            addDrop(BlocksCollection.ELDER_DARK_PRISMARINE_WALL);
        }
        
    }

    private static class GEModelProvider extends FabricModelProvider {

        public GEModelProvider(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            BlockStateModelGenerator.BlockTexturePool elder_prismarine_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlocksCollection.ELDER_PRISMARINE);
            BlockStateModelGenerator.BlockTexturePool elder_prismarine_bricks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlocksCollection.ELDER_PRISMARINE_BRICKS);
            BlockStateModelGenerator.BlockTexturePool elder_dark_prismarine_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlocksCollection.ELDER_DARK_PRISMARINE);

            elder_prismarine_pool.stairs(BlocksCollection.ELDER_PRISMARINE_STAIRS);
            elder_prismarine_pool.slab(BlocksCollection.ELDER_PRISMARINE_SLAB);
            elder_prismarine_pool.wall(BlocksCollection.ELDER_PRISMARINE_WALL);

            elder_prismarine_bricks_pool.stairs(BlocksCollection.ELDER_PRISMARINE_BRICKS_STAIRS);
            elder_prismarine_bricks_pool.slab(BlocksCollection.ELDER_PRISMARINE_BRICKS_SLAB);
            elder_prismarine_bricks_pool.wall(BlocksCollection.ELDER_PRISMARINE_BRICKS_WALL);

            elder_dark_prismarine_pool.stairs(BlocksCollection.ELDER_DARK_PRISMARINE_STAIRS);
            elder_dark_prismarine_pool.slab(BlocksCollection.ELDER_DARK_PRISMARINE_SLAB);
            elder_dark_prismarine_pool.wall(BlocksCollection.ELDER_DARK_PRISMARINE_WALL);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            
        }
        
    }

    private static class GERecipeProvider extends FabricRecipeProvider {

        public GERecipeProvider(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generate(Consumer<RecipeJsonProvider> exporter) {
            createStairsRecipe(BlocksCollection.ELDER_PRISMARINE, Ingredient.ofItems(BlocksCollection.ELDER_PRISMARINE))
                .criterion(hasItem(BlocksCollection.ELDER_PRISMARINE), conditionsFromItem(BlocksCollection.ELDER_PRISMARINE))
                .offerTo(exporter, new Identifier(getRecipeName(BlocksCollection.ELDER_PRISMARINE_STAIRS)));

            createStairsRecipe(BlocksCollection.ELDER_PRISMARINE_BRICKS, Ingredient.ofItems(BlocksCollection.ELDER_PRISMARINE_BRICKS))
                .criterion(hasItem(BlocksCollection.ELDER_PRISMARINE_BRICKS), conditionsFromItem(BlocksCollection.ELDER_PRISMARINE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(BlocksCollection.ELDER_PRISMARINE_BRICKS_STAIRS)));

            createStairsRecipe(BlocksCollection.ELDER_DARK_PRISMARINE, Ingredient.ofItems(BlocksCollection.ELDER_DARK_PRISMARINE))
                .criterion(hasItem(BlocksCollection.ELDER_DARK_PRISMARINE), conditionsFromItem(BlocksCollection.ELDER_DARK_PRISMARINE))
                .offerTo(exporter, new Identifier(getRecipeName(BlocksCollection.ELDER_DARK_PRISMARINE_STAIRS)));

        }
        
    }
    
}
