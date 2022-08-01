package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.RaccoonEntity;
import net.firebrandomega.autumn.entity.SquirrelEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SquirrelRenderer extends GeoEntityRenderer<SquirrelEntity> {
    public SquirrelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SquirrelModel());
    }

    @Override
    public Identifier getTexture(SquirrelEntity instance){
        return new Identifier(AutumnMod.MOD_ID,"textures/entities/squirrel/squirrel.png");
    }

    @Override
    public Identifier getTextureResource(SquirrelEntity instance){
        return new Identifier(AutumnMod.MOD_ID,"textures/entities/squirrel/squirrel.png");
    }
}
