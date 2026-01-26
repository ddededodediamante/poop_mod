package com.ddededodediamante;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ddepoopmodMod implements ModInitializer {
    public static final String MOD_ID = "ddepoopmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from dde: Poop Mod!");

        ModSounds.initialize();
        ModItemGroups.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
        ModEffects.initialize();
        ModPotions.initialize();
    }
}