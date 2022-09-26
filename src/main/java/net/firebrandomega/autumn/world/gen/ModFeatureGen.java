package net.firebrandomega.autumn.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.firebrandomega.autumn.world.biome.ModOverworldBiomeCreator;
import net.firebrandomega.autumn.world.feature.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModFeatureGen {
    public static void generateTrees() {
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

    public static void generateOtherFeatures(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        ModOverworldBiomeCreator.AUTUMN_KEY),
                GenerationStep.Feature.LOCAL_MODIFICATIONS, ModPlacedFeatures.LEAF_PILE_PLACED.getKey().get());
    }

    //(Predicate<BiomeSelectionContext>) BiomeKeys.PLAINS
}
