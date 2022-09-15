package net.firebrandomega.autumn.entity.client;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class ModBipedEntityRenderer extends BipedEntityRenderer {
    public ModBipedEntityRenderer(EntityRendererFactory.Context ctx, BipedEntityModel model, float shadowRadius) {
        super(ctx, model, shadowRadius);
        this.addFeature(new AutumnWingsRenderer(this, ctx.getModelLoader()));
    }
}
