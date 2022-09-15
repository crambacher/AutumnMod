package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.DeerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeerRenderer extends GeoEntityRenderer<DeerEntity> {

    public DeerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DeerModel());
    }

    @Override
    public Identifier getTexture(DeerEntity instance){
        return new Identifier(AutumnMod.MOD_ID,"textures/entities/deer/deer.png");
    }

    @Override
    public Identifier getTextureResource(DeerEntity instance){
        return new Identifier(AutumnMod.MOD_ID,"textures/entities/deer/deer.png");
    }

}
