package net.firebrandomega.autumn.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.firebrandomega.autumn.AutumnMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType RED_LEAF_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ORANGE_LEAF_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType YELLOW_LEAF_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AutumnMod.MOD_ID,"red_leaf_particle"), RED_LEAF_PARTICLE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AutumnMod.MOD_ID,"orange_leaf_particle"), ORANGE_LEAF_PARTICLE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AutumnMod.MOD_ID,"yellow_leaf_particle"), YELLOW_LEAF_PARTICLE);
    }
}
