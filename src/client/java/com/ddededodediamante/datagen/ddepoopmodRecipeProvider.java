package com.ddededodediamante.datagen;

import java.util.concurrent.CompletableFuture;

import com.ddededodediamante.ModBlocks;
import com.ddededodediamante.ModItems;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class ddepoopmodRecipeProvider extends FabricRecipeProvider {
    public ddepoopmodRecipeProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup,
            RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_BLOCK.asItem(), 2)
                        .pattern("pp")
                        .pattern("pp")
                        .input('p', ModItems.POOP_PIECE)
                        .criterion("has_poop_piece",
                                conditionsFromItem(ModItems.POOP_PIECE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_STAIRS.asItem(), 4)
                        .pattern("p  ")
                        .pattern("pp ")
                        .pattern("ppp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_SLAB.asItem(), 6)
                        .pattern("ppp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_WALL.asItem(), 6)
                        .pattern("ppp")
                        .pattern("ppp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_FENCE.asItem(), 3)
                        .pattern("psp")
                        .pattern("psp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .input('s', Items.STICK)
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_FENCE_GATE.asItem(), 1)
                        .pattern("sps")
                        .pattern("sps")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .input('s', Items.STICK)
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, ModBlocks.POOP_BUTTON.asItem())
                        .input(ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, ModBlocks.POOP_PRESSURE_PLATE.asItem(), 1)
                        .pattern("pp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, ModBlocks.POOP_DOOR.asItem(), 3)
                        .pattern("pp")
                        .pattern("pp")
                        .pattern("pp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.FOOD, ModItems.POOP_PIECE, 1)
                        .pattern("p")
                        .input('p', ItemTags.DIRT)
                        .criterion("has_dirt",
                                conditionsFromTag(ItemTags.DIRT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.POOP_HELMET, 1)
                        .pattern("ppp")
                        .pattern("p p")
                        .input('p', ModItems.POOP_PIECE)
                        .criterion("has_poop_piece",
                                conditionsFromItem(ModItems.POOP_PIECE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.POOP_CHESTPLATE, 1)
                        .pattern("p p")
                        .pattern("ppp")
                        .pattern("ppp")
                        .input('p', ModItems.POOP_PIECE)
                        .criterion("has_poop_piece",
                                conditionsFromItem(ModItems.POOP_PIECE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.POOP_LEGGINGS, 1)
                        .pattern("ppp")
                        .pattern("p p")
                        .pattern("p p")
                        .input('p', ModItems.POOP_PIECE)
                        .criterion("has_poop_piece",
                                conditionsFromItem(ModItems.POOP_PIECE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.POOP_BOOTS, 1)
                        .pattern("p p")
                        .pattern("p p")
                        .input('p', ModItems.POOP_PIECE)
                        .criterion("has_poop_piece",
                                conditionsFromItem(ModItems.POOP_PIECE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ddepoopmodRecipeProvider";
    }
}
