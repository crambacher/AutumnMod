package net.firebrandomega.autumn.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class RedLeafParticle extends SpriteBillboardParticle {
    protected RedLeafParticle(ClientWorld level, double xCoord, double yCoord, double zCoord,
                              SpriteProvider spriteSet, double xD, double yD, double zD) {
        super(level, xCoord, yCoord, zCoord, xD, yD, zD);
        this.velocityMultiplier = 0.1F;
        this.x = xD;
        this.y = yD;
        this.z = zD;
        this.scale = 0.75F;
        this.maxAge = 200;
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    private void fadeOut(){
        this.alpha = (-(1/(float)maxAge)*age+1);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType>{

        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider){
            this.sprites = spriteProvider;
        }
        @Nullable
        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld level, double x, double y, double z, double dX, double dY, double dZ) {
            return new RedLeafParticle(level, x, y, z, this.sprites, dX, dY, dZ);
        }
    }
}
