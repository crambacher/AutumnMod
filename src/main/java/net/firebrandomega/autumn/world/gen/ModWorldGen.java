package net.firebrandomega.autumn.world.gen;

import net.firebrandomega.autumn.world.feature.ModConfiguredFeatures;

public class ModWorldGen {
    public static void generateModWorldGen(){
        ModFeatureGen.generateTrees();
        ModFeatureGen.generateOtherFeatures();
        ModEntitySpawn.addEntitySpawn();
        ModConfiguredFeatures.registerConfiguredFeatures();
    }
}
