package com.ddededodediamante;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion FART = Registry.register(
            Registries.POTION,
            Identifier.of(ddepoopmodMod.MOD_ID, "fart"),
            new Potion("fart",
                    new StatusEffectInstance(
                            ModEffects.FART,
                            3600,
                            0)));

    public static final Potion STRONG_FART = Registry.register(
            Registries.POTION,
            Identifier.of(ddepoopmodMod.MOD_ID, "strong_fart"),
            new Potion("fart",
                    new StatusEffectInstance(
                            ModEffects.FART,
                            3800,
                            1)));

    public static final Potion STINK = Registry.register(
            Registries.POTION,
            Identifier.of(ddepoopmodMod.MOD_ID, "stink"),
            new Potion("stink",
                    new StatusEffectInstance(
                            ModEffects.STINK,
                            1800,
                            0)));

    public static final Potion LONG_STINK = Registry.register(
            Registries.POTION,
            Identifier.of(ddepoopmodMod.MOD_ID, "long_stink"),
            new Potion("stink",
                    new StatusEffectInstance(
                            ModEffects.STINK,
                            3600,
                            0)));

    public static final Potion STRONG_STINK = Registry.register(
            Registries.POTION,
            Identifier.of(ddepoopmodMod.MOD_ID, "strong_stink"),
            new Potion("stink",
                    new StatusEffectInstance(
                            ModEffects.STINK,
                            800,
                            1)));

    public static void initialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WATER,
                    ModBlocks.POOP_BLOCK.asItem(),
                    Registries.POTION.getEntry(FART));

            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(FART),
                    ModBlocks.POOP_BLOCK.asItem(),
                    Registries.POTION.getEntry(STRONG_FART));

            // Stink potion brewing
            builder.registerPotionRecipe(
                    Potions.WATER,
                    ModBlocks.POOP_BRICK_SLAB.asItem(),
                    Registries.POTION.getEntry(STINK));

            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(STINK),
                    ModBlocks.POOP_BLOCK.asItem(),
                    Registries.POTION.getEntry(LONG_STINK));

            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(STINK),
                    ModBlocks.POOP_BRICK_SLAB.asItem(),
                    Registries.POTION.getEntry(STRONG_STINK));
        });
    }
}