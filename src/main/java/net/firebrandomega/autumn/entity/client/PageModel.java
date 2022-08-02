package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.PageEntity;
import net.firebrandomega.autumn.entity.RaccoonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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
    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public void setLivingAnimations(PageEntity entity, Integer uniqueID, AnimationEvent customPredicate){
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(head != null){
            head.setRotationX(extraData.headPitch * ((float)Math.PI/180F));
            head.setRotationY(extraData.netHeadYaw* ((float)Math.PI/180F));
        }

    }
}
