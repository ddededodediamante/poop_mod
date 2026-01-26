package com.ddededodediamante;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static class FartEffect extends StatusEffect {
        protected FartEffect() {
            super(StatusEffectCategory.NEUTRAL, 0x98D982);
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return false;
        }
    }

    public static final RegistryEntry<StatusEffect> FART = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ddepoopmodMod.MOD_ID, "fart"),
            new FartEffect());

    public static void initialize() {
    }
}