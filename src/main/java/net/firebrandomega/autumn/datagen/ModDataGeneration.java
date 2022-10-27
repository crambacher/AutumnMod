package net.firebrandomega.autumn.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new ModLootTableGenerator(fabricDataGenerator));
        fabricDataGenerator.addProvider(new ModRecipeGenerator(fabricDataGenerator));
    }
}
