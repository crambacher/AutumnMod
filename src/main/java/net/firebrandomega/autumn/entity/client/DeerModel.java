package net.firebrandomega.autumn.entity.client;

import net.firebrandomega.autumn.entity.DeerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class DeerModel extends AnimatedGeoModel<DeerEntity> {
    @Override
    public Identifier getModelResource(DeerEntity object) {
        return null;
    }

    @Override
    public Identifier getTextureResource(DeerEntity object) {
        return null;
    }

    @Override
    public Identifier getAnimationResource(DeerEntity animatable) {
        return null;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public void setLivingAnimations(DeerEntity entity, Integer uniqueID, AnimationEvent customPredicate){
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(head != null){
            head.setRotationX(extraData.headPitch * ((float)Math.PI/180F));
            head.setRotationY(extraData.netHeadYaw* ((float)Math.PI/180F));
        }

    }
}
