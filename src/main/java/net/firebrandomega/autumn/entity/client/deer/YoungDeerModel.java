package net.firebrandomega.autumn.entity.client.deer;

import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.DeerEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class YoungDeerModel extends AnimatedGeoModel<DeerEntity> {

private final ModelPart root;
    public YoungDeerModel(ModelPart root){
        this.root = root;
    }
    @Override
    public Identifier getModelResource(DeerEntity object) {
        return new Identifier(AutumnMod.MOD_ID, "geo/deer.geo.json");
    }

    @Override
    public Identifier getTextureResource(DeerEntity object) {
        return new Identifier(AutumnMod.MOD_ID,"textures/entities/deer/deer.png");
    }

    @Override
    public Identifier getAnimationResource(DeerEntity animatable) {
        return new Identifier(AutumnMod.MOD_ID, "animations/deer.animation.json");
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
