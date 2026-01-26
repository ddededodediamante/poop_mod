package com.ddededodediamante.mixin;

import com.ddededodediamante.ModEffects;
import com.ddededodediamante.ModSounds;

import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "jump", at = @At("HEAD"))
    private void fartOnJump(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        World world = entity.getEntityWorld();

        if (world.isClient()) return;

        var effect = entity.getStatusEffect(ModEffects.FART);
        if (effect == null) return;

        int amplifier = effect.getAmplifier(); 

        float randomness = 0.1f + (amplifier * 0.05f);
        randomness = Math.min(randomness, 0.6f);
        float pitch = 1.0f + (world.random.nextFloat() * 2f - 1f) * randomness;

        float volume = Math.min(1.0f, 0.8f + (amplifier * 0.04f));

        world.playSound(
                null,
                entity.getBlockPos(),
                ModSounds.FART,
                SoundCategory.PLAYERS,
                volume,
                pitch
        );
    }
}
