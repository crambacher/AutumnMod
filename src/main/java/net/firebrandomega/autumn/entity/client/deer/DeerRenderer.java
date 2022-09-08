package net.firebrandomega.autumn.entity.client.deer;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.DeerEntity;
import net.firebrandomega.autumn.entity.client.deer.YoungDeerModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.MediumPufferfishEntityModel;
import net.minecraft.client.render.entity.model.SmallPufferfishEntityModel;
import net.minecraft.entity.passive.PufferfishEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeerRenderer extends GeoEntityRenderer<DeerEntity> {
    private final EntityModel<DeerEntity> youngDeerModel;
    private final EntityModel<DeerEntity> teenDeerModel;
    private final EntityModel<DeerEntity> adultDeerModel = this.getModel();
    public DeerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new YoungDeerModel(ctx.getPart(EntityModelLayers.PUFFERFISH_BIG)));
        this.teenDeerModel = new TeenDeerModel<DeerEntity>(ctx.getPart(EntityModelLayers.PUFFERFISH_MEDIUM));
        this.youngDeerModel = new SmallPufferfishEntityModel<PufferfishEntity>(ctx.getPart(EntityModelLayers.PUFFERFISH_SMALL));
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
