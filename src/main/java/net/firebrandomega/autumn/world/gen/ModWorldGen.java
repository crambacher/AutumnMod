package net.firebrandomega.autumn.world.gen;

public class ModWorldGen {
    public static void generateModWorldGen(){
        ModTreeGen.generateTrees();
        ModEntitySpawn.addEntitySpawn();
    }
}
