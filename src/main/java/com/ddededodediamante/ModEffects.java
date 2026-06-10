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

    public static class StinkEffect extends StatusEffect {
        protected StinkEffect() {
            super(StatusEffectCategory.HARMFUL, 0x4A3728); 
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    public static final RegistryEntry<StatusEffect> FART = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ddepoopmodMod.MOD_ID, "fart"),
            new FartEffect());

    public static final RegistryEntry<StatusEffect> STINK = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ddepoopmodMod.MOD_ID, "stink"),
            new StinkEffect());

    public static void initialize() {
    }
}