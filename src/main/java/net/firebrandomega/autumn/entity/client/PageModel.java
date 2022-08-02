package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.PageEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PageModel extends AnimatedGeoModel<PageEntity> {
    @Override
    public Identifier getModelResource(PageEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "geo/page.geo.json");
    }

    @Override
    public Identifier getTextureResource(PageEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "textures/entities/page/page.png");
    }

    @Override
    public Identifier getAnimationResource(PageEntity animatable) {
        return new Identifier(AutumnMod.MOD_ID, "animations/page.animation.json");
    }
}
