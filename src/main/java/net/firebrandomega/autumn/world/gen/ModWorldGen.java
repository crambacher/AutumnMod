package net.firebrandomega.autumn.world.gen;

import net.firebrandomega.autumn.world.feature.ModConfiguredFeatures;

public class ModWorldGen {
    public static void generateModWorldGen(){
        ModTreeGen.generateTrees();
        ModEntitySpawn.addEntitySpawn();
        ModConfiguredFeatures.registerConfiguredFeatures();
    }
}
