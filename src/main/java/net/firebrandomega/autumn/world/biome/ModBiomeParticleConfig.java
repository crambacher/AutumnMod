package net.firebrandomega.autumn.world.biome;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.biome.BiomeParticleConfig;

public class ModBiomeParticleConfig extends BiomeParticleConfig {
    public ModBiomeParticleConfig(ParticleEffect particle, float probability) {
        super(particle, probability);
    }

    @Override
    public ParticleEffect getParticle() {
        return super.getParticle();
    }

    @Override
    public boolean shouldAddParticle(Random random) {
        return super.shouldAddParticle(random);
    }
}
