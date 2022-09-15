package net.firebrandomega.autumn.entity.client;

import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.model.ArmorStandArmorEntityModel;
import net.minecraft.entity.decoration.ArmorStandEntity;

public class ModArmorStandEntityRenderer extends ArmorStandEntityRenderer {
    public ModArmorStandEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new AutumnWingsRenderer<ArmorStandEntity, ArmorStandArmorEntityModel>(this, context.getModelLoader()));
    }
}
