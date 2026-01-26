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
        });
    }
}