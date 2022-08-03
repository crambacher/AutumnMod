package net.firebrandomega.autumn.world.feature;

import com.google.common.collect.ImmutableList;
import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.registry.ModBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> RED_AUTUMN_TREE =
            ConfiguredFeatures.register("red_autumn_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.AUTUMN_LOG),
                    new StraightTrunkPlacer(5,6,3),
                    BlockStateProvider.of(ModBlocks.AUTUMN_LEAVES_RED),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0),4),
                    new TwoLayersFeatureSize(1,0,2))
                    .decorators(ImmutableList.of(new AlterGroundTreeDecorator(
                            BlockStateProvider.of(ModBlocks.RED_LEAFY_GRASS)))).build());

    public static final RegistryEntry<PlacedFeature> RED_AUTUMN_CHECKED =
            PlacedFeatures.register("red_autumn_checked", RED_AUTUMN_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.RED_AUTUMN_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> RED_AUTUMN_SPAWN =
            ConfiguredFeatures.register("red_autumn_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(RED_AUTUMN_CHECKED,0.5f)),
                            RED_AUTUMN_CHECKED));





    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ORANGE_AUTUMN_TREE =
            ConfiguredFeatures.register("orange_autumn_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.AUTUMN_LOG),
                    new StraightTrunkPlacer(5,6,3),
                    BlockStateProvider.of(ModBlocks.AUTUMN_LEAVES_ORANGE),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0),4),
                    new TwoLayersFeatureSize(1,0,2))
                    .decorators(ImmutableList.of(new AlterGroundTreeDecorator(
                            BlockStateProvider.of(ModBlocks.RED_LEAFY_GRASS)))).build());

    public static final RegistryEntry<PlacedFeature> ORANGE_AUTUMN_CHECKED =
            PlacedFeatures.register("orange_autumn_checked", ORANGE_AUTUMN_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.ORANGE_AUTUMN_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ORANGE_AUTUMN_SPAWN =
            ConfiguredFeatures.register("orange_autumn_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ORANGE_AUTUMN_CHECKED,0.5f)),
                            ORANGE_AUTUMN_CHECKED));





    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> YELLOW_AUTUMN_TREE =
            ConfiguredFeatures.register("yellow_autumn_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.AUTUMN_LOG),
                    new StraightTrunkPlacer(5,6,3),
                    BlockStateProvider.of(ModBlocks.AUTUMN_LEAVES_YELLOW),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0),4),
                    new TwoLayersFeatureSize(1,0,2))
                    .decorators(ImmutableList.of(new AlterGroundTreeDecorator(
                            BlockStateProvider.of(ModBlocks.RED_LEAFY_GRASS)))).build());

    public static final RegistryEntry<PlacedFeature> YELLOW_AUTUMN_CHECKED =
            PlacedFeatures.register("yellow_autumn_checked", YELLOW_AUTUMN_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.YELLOW_AUTUMN_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> YELLOW_AUTUMN_SPAWN =
            ConfiguredFeatures.register("yellow_autumn_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(YELLOW_AUTUMN_CHECKED,0.5f)),
                            YELLOW_AUTUMN_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<SingleStateFeatureConfig, ?>> LEAF_PILE = ConfiguredFeatures.register("leaf_pile", ModFeatures.LEAF_PILE, new SingleStateFeatureConfig(ModBlocks.RED_LEAFY_GRASS.getDefaultState()));

    public static void registerConfiguredFeatures(){
        System.out.println("Registering configured features for: "+ AutumnMod.MOD_ID);
    }
}
