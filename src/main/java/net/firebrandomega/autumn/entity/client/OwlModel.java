package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.OwlEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OwlModel extends AnimatedGeoModel<OwlEntity> {
    @Override
    public Identifier getModelResource(OwlEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "geo/owl.geo.json");
    }

    @Override
    public Identifier getTextureResource(OwlEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "textures/entities/owl/owl.png");
    }

    @Override
    public Identifier getAnimationResource(OwlEntity animatable) {
        return new Identifier(AutumnMod.MOD_ID, "animations/owl.animation.json");
    }
}
