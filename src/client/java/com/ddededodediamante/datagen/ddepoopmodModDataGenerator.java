package com.ddededodediamante.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ddepoopmodModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ddepoopmodRecipeProvider::new);
        pack.addProvider(ddepoopmodModelProvider::new);
        pack.addProvider(ddepoopmodItemTagProvider::new);
        pack.addProvider(ddepoopmodBlockLootTableProvider::new);
    }
}