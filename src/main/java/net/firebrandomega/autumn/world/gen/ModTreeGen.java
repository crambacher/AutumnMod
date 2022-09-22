package net.firebrandomega.autumn.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.firebrandomega.autumn.world.biome.ModOverworldBiomeCreator;
import net.firebrandomega.autumn.world.feature.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

import java.util.function.Predicate;

public class ModTreeGen {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        ModOverworldBiomeCreator.AUTUMN_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_AUTUMN_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        ModOverworldBiomeCreator.AUTUMN_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_AUTUMN_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        ModOverworldBiomeCreator.AUTUMN_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELLOW_AUTUMN_PLACED.getKey().get());
    }

    //(Predicate<BiomeSelectionContext>) BiomeKeys.PLAINS
}
