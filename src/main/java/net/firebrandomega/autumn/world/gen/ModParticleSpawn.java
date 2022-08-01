package net.firebrandomega.autumn.world.gen;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.biome.BiomeParticleConfig;

public class ModParticleSpawn extends BiomeParticleConfig {
    public ModParticleSpawn(ParticleEffect particle, float probability) {
        super(particle, probability);
    }
}
