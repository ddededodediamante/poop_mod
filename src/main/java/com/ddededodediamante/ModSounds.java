package com.ddededodediamante;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    private static SoundEvent registerSound(String path) {
        Identifier identifier = Identifier.of(ddepoopmodMod.MOD_ID, path);
    
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static final SoundEvent FART = registerSound("fart");

    public static void initialize() {
    }
}
