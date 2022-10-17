package net.firebrandomega.autumn.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.firebrandomega.autumn.registry.ModEntities;
import net.firebrandomega.autumn.world.biome.ModOverworldBiomeCreator;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;

public class ModEntitySpawn {
    public static void addEntitySpawn(){
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomeCreator.AUTUMN_KEY),
                SpawnGroup.CREATURE, ModEntities.RACCOON,
                50,1,2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomeCreator.AUTUMN_KEY),
                SpawnGroup.CREATURE, ModEntities.SQUIRREL,
                50, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomeCreator.AUTUMN_KEY),
                SpawnGroup.CREATURE, ModEntities.DEER,
                50, 2, 5);

//        SpawnRestrictionAccessor.callRegister(ModEntities.RACCOON, SpawnRestriction.Location.ON_GROUND,
//                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
//        SpawnRestrictionAccessor.callRegister(ModEntities.SQUIRREL, SpawnRestriction.Location.ON_GROUND,
//                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
//        SpawnRestrictionAccessor.callRegister(ModEntities.DEER, SpawnRestriction.Location.ON_GROUND,
//                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
