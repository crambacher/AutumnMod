package net.firebrandomega.autumn.world.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModFeatures<FC extends FeatureConfig> {
    //public static final Feature<SingleStateFeatureConfig> LEAF_PILE = ModFeatures.register("leaf_pile", new LeafPileFeature(SingleStateFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registry.FEATURE, name, feature);
    }
}
