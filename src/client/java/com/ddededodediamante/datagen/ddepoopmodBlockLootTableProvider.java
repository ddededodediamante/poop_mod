package com.ddededodediamante.datagen;

import java.util.concurrent.CompletableFuture;

import com.ddededodediamante.ModBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

public class ddepoopmodBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected ddepoopmodBlockLootTableProvider(FabricDataOutput dataOutput,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.POOP_BLOCK);
        addDrop(ModBlocks.POOP_BUTTON);
        addDrop(ModBlocks.POOP_DOOR);
        addDrop(ModBlocks.POOP_FENCE);
        addDrop(ModBlocks.POOP_FENCE_GATE);
        addDrop(ModBlocks.POOP_PRESSURE_PLATE);
        addDrop(ModBlocks.POOP_SLAB);
        addDrop(ModBlocks.POOP_STAIRS);
        addDrop(ModBlocks.POOP_WALL);

        addDrop(ModBlocks.SMOOTH_POOP_BLOCK);
        addDrop(ModBlocks.SMOOTH_POOP_STAIRS);
        addDrop(ModBlocks.SMOOTH_POOP_SLAB);

        addDrop(ModBlocks.POOP_BRICKS);
        addDrop(ModBlocks.POOP_BRICK_STAIRS);
        addDrop(ModBlocks.POOP_BRICK_SLAB);
        addDrop(ModBlocks.POOP_BRICK_WALL);

        addDrop(ModBlocks.CRACKED_POOP_BRICKS);
        addDrop(ModBlocks.CHISELED_POOP);
    }
}