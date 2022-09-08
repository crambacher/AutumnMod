package net.firebrandomega.autumn.entity.client.deer;

import net.firebrandomega.autumn.entity.DeerEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TeenDeerModel extends AnimatedGeoModel<DeerEntity> {
    private final ModelPart root;
    public TeenDeerModel(ModelPart root){
        this.root = root;
    }
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
}
