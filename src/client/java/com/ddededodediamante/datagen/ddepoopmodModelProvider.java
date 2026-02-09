package com.ddededodediamante.datagen;

import com.ddededodediamante.ModBlocks;
import com.ddededodediamante.ModItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.data.family.BlockFamily;

public class ddepoopmodModelProvider extends FabricModelProvider {
    public ddepoopmodModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockFamily POOP_FAMILY = new BlockFamily.Builder(ModBlocks.POOP_BLOCK)
                .stairs(ModBlocks.POOP_STAIRS)
                .slab(ModBlocks.POOP_SLAB)
                .fence(ModBlocks.POOP_FENCE)
                .fenceGate(ModBlocks.POOP_FENCE_GATE)
                .pressurePlate(ModBlocks.POOP_PRESSURE_PLATE)
                .button(ModBlocks.POOP_BUTTON)
                .door(ModBlocks.POOP_DOOR)
                .wall(ModBlocks.POOP_WALL)
                .build();

        BlockFamily SMOOTH_POOP_FAMILY = new BlockFamily.Builder(ModBlocks.SMOOTH_POOP_BLOCK)
                .stairs(ModBlocks.SMOOTH_POOP_STAIRS)
                .slab(ModBlocks.SMOOTH_POOP_SLAB)
                .build();

        BlockFamily POOP_BRICK_FAMILY = new BlockFamily.Builder(ModBlocks.POOP_BRICKS)
                .stairs(ModBlocks.POOP_BRICK_STAIRS)
                .slab(ModBlocks.POOP_BRICK_SLAB)
                .wall(ModBlocks.POOP_BRICK_WALL)
                .build();

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POOP_BLOCK)
                .family(POOP_FAMILY);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_POOP_BLOCK)
                .family(SMOOTH_POOP_FAMILY);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POOP_BRICKS)
                .family(POOP_BRICK_FAMILY);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_POOP_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_POOP);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.POOP_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POOP_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.POOP_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POOP_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.POOP_BOOTS, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "ddepoopmodModelProvider";
    }
}
