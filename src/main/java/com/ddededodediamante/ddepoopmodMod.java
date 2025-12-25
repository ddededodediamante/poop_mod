package com.ddededodediamante;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ddepoopmodMod implements ModInitializer {
    public static final String MOD_ID = "ddepoopmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello dde's Amazing world!");

        ModItemGroups.register();
        ModItems.initialize();
        ModBlocks.initialize();
    }
}