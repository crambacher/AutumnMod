package net.firebrandomega.autumn.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.modifiers;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> MOD_AUTUMN_BIRCH_AND_OAK = PlacedFeatures.register("autumn_birch_and_oak", VegetationConfiguredFeatures.TREES_BIRCH_AND_OAK, modifiers(PlacedFeatures.createCountExtraModifier(3, 0.1F, 1)));
    public static final RegistryEntry<PlacedFeature> LEAF_PILE = PlacedFeatures.register("leaf_pile",ModConfiguredFeatures.LEAF_PILE, CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> RED_AUTUMN_PLACED = PlacedFeatures.register(
            "red_autumn_placed", ModConfiguredFeatures.RED_AUTUMN_SPAWN, modifiers(
                    PlacedFeatures.createCountExtraModifier(3, 0.1f, 2)));

    public static final RegistryEntry<PlacedFeature> ORANGE_AUTUMN_PLACED = PlacedFeatures.register(
            "orange_autumn_placed", ModConfiguredFeatures.ORANGE_AUTUMN_SPAWN, modifiers(
                    PlacedFeatures.createCountExtraModifier(3, 0.1f, 2)
            ));

    public static final RegistryEntry<PlacedFeature> YELLOW_AUTUMN_PLACED = PlacedFeatures.register(
            "yellow_autumn_placed", ModConfiguredFeatures.YELLOW_AUTUMN_SPAWN, modifiers(
                    PlacedFeatures.createCountExtraModifier(3, 0.1f, 2)
            ));

}
