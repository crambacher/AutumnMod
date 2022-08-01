package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.SquirrelEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SquirrelModel extends AnimatedGeoModel<SquirrelEntity> {
    @Override
    public Identifier getModelResource(SquirrelEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "geo/squirrel_base.geo.json");
    }

    @Override
    public Identifier getTextureResource(SquirrelEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "textures/entities/squirrel/squirrel.png");
    }

    @Override
    public Identifier getAnimationResource(SquirrelEntity animatable) {
        return new Identifier(AutumnMod.MOD_ID, "animations/squirrel_base.animation.json");
    }
}
