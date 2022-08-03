package net.firebrandomega.autumn.world.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.ForestRockFeature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;

public class ModFeatures<FC extends FeatureConfig> {
    public static final Feature<SingleStateFeatureConfig> LEAF_PILE = ModFeatures.register("leaf_pile", new LeafPileFeature(SingleStateFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registry.FEATURE, name, feature);
    }
}
