package net.firebrandomega.autumn.world.biome;

import net.firebrandomega.autumn.registry.ModEntities;
import net.firebrandomega.autumn.registry.ModParticles;
import net.firebrandomega.autumn.world.feature.ModConfiguredFeatures;
import net.firebrandomega.autumn.world.feature.ModPlacedFeatures;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.jetbrains.annotations.Nullable;

public class ModOverworldBiomeCreator extends OverworldBiomeCreator {

    private static final Biome AUTUMN_BIOME = createAutumnBiome();

    public static void registerBiomes(){
        Registry.register(BuiltinRegistries.BIOME, AUTUMN_KEY.getValue(), AUTUMN_BIOME);
    }

    public static final RegistryKey<Biome> AUTUMN_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("autumn", "autumn_biome"));

    public static Biome createBiome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, SpawnSettings.Builder spawnSettings, GenerationSettings.Builder generationSettings, @Nullable MusicSound music, ParticleEffect particle) {
        return new Biome.Builder().precipitation(precipitation).temperature(temperature).downfall(downfall).effects(new BiomeEffects.Builder().waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463)
                .particleConfig(new BiomeParticleConfig(particle,0.00625f)).skyColor(OverworldBiomeCreator.getSkyColor(temperature)).moodSound(BiomeMoodSound.CAVE).music(music).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome createBiome(Biome.Precipitation precipitation, float temperature, float downfall, SpawnSettings.Builder spawnSettings, GenerationSettings.Builder generationSettings, @Nullable MusicSound music, ParticleEffect particle) {
        return ModOverworldBiomeCreator.createBiome(precipitation, temperature, downfall, 4159204, 329011, spawnSettings, generationSettings, music, particle);
    }

    private static void addBasicFeatures(GenerationSettings.Builder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addDefaultGrass(generationSettings);
    }
    public static Biome createAutumnBiome(){
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.DEER,8,2,5));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.SQUIRREL,6,1,2));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.RACCOON,6,1,2));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT,5,1,2));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 5,1,2));

        DefaultBiomeFeatures.addCaveMobs(builder);
        DefaultBiomeFeatures.addMonsters(builder, 100, 25, 100, false);

        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        ModOverworldBiomeCreator.addBasicFeatures(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.RED_AUTUMN_CHECKED);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ORANGE_AUTUMN_CHECKED);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.YELLOW_AUTUMN_CHECKED);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOD_AUTUMN_BIRCH_AND_OAK);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addSweetBerryBushes(builder2);
        MusicSound musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_JUNGLE_AND_FOREST);
        return ModOverworldBiomeCreator.createBiome(Biome.Precipitation.RAIN,  0.7f, 0.8f, builder,
                builder2, musicSound, ModParticles.ALL_LEAF_PARTICLE);
    }
}
