package net.firebrandomega.autumn.world.gen;

//import net.firebrandomega.autumn.world.biome.ModOverworldBiomeCreator;

public class ModWorldGen {
    public static void generateModWorldGen(){

        //ModOverworldBiomeCreator.registerBiomes();
        ModTreeGen.generateTrees();
        ModEntitySpawn.addEntitySpawn();
    }
}
