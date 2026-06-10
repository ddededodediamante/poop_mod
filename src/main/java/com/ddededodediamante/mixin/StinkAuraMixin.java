package com.ddededodediamante.mixin;

import com.ddededodediamante.ModEffects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LivingEntity.class)
public abstract class StinkAuraMixin extends Entity {

    public StinkAuraMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract boolean hasStatusEffect(RegistryEntry<net.minecraft.entity.effect.StatusEffect> effect);

    @Shadow
    public abstract net.minecraft.entity.effect.StatusEffectInstance getStatusEffect(
            RegistryEntry<net.minecraft.entity.effect.StatusEffect> effect);

    @Inject(method = "tick", at = @At("TAIL"))
    private void applyStinkAura(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        World world = entity.getEntityWorld();

        if (!this.hasStatusEffect(ModEffects.STINK))
            return;

        net.minecraft.entity.effect.StatusEffectInstance stinkEffect = this.getStatusEffect(ModEffects.STINK);
        int amplifier = stinkEffect.getAmplifier();

        if (world.isClient() || world.getTime() % 20 != 0)
            return;

        float auraRadius = 3.0f + amplifier;

        List<Entity> nearbyEntities = world.getOtherEntities(
                this,
                this.getBoundingBox().expand(auraRadius),
                e -> e instanceof LivingEntity && !e.isRemoved() && e.isAlive());

        double auraRadiusSq = (double) auraRadius * auraRadius;
        for (Entity target : nearbyEntities) {
            if (entity.squaredDistanceTo(target) <= auraRadiusSq) {
                float damage = 1.0f + (amplifier * 0.5f);

                DamageSource dmg = entity.getDamageSources().create(DamageTypes.MAGIC);
                if (world instanceof ServerWorld) {
                    target.damage((ServerWorld) world, dmg, damage);
                }
            }
        }
    }
}
