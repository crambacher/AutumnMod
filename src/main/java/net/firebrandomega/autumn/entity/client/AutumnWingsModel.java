package net.firebrandomega.autumn.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

@Environment(value= EnvType.CLIENT)
public class AutumnWingsModel extends ElytraEntityModel {

    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public AutumnWingsModel(ModelPart root) {
        super(root);
        this.leftWing = root.getChild(EntityModelPartNames.LEFT_WING);
        this.rightWing = root.getChild(EntityModelPartNames.RIGHT_WING);
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return super.getHeadParts();
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return super.getBodyParts();
    }

    @Override
    public void setAngles(LivingEntity livingEntity, float f, float g, float h, float i, float j) {
        float k = 0.2617994f;
        float l = -0.2617994f;
        float m = 0.0f;
        float n = 0.0f;
        if (((LivingEntity)livingEntity).isFallFlying()) {
            float o = 1.0f;
            Vec3d vec3d = ((Entity)livingEntity).getVelocity();
            if (vec3d.y < 0.0) {
                Vec3d vec3d2 = vec3d.normalize();
                o = 1.0f - (float)Math.pow(-vec3d2.y, 1.5);
            }
            k = o * 0.34906584f + (1.0f - o) * k;
            l = o * -1.5707964f + (1.0f - o) * l;
        } else if (((Entity)livingEntity).isInSneakingPose()) {
            k = 0.6981317f;
            l = -0.7853982f;
            m = 3.0f;
            n = 0.08726646f;
        }
        this.leftWing.pivotY = m;
        if (livingEntity instanceof AbstractClientPlayerEntity) {
            AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity)livingEntity;
            abstractClientPlayerEntity.elytraPitch += (k - abstractClientPlayerEntity.elytraPitch) * 0.1f;
            abstractClientPlayerEntity.elytraYaw += (n - abstractClientPlayerEntity.elytraYaw) * 0.1f;
            abstractClientPlayerEntity.elytraRoll += (l - abstractClientPlayerEntity.elytraRoll) * 0.1f;
            this.leftWing.pitch = abstractClientPlayerEntity.elytraPitch;
            this.leftWing.yaw = abstractClientPlayerEntity.elytraYaw;
            this.leftWing.roll = abstractClientPlayerEntity.elytraRoll;
        } else {
            this.leftWing.pitch = k;
            this.leftWing.roll = l;
            this.leftWing.yaw = n;
        }
        this.rightWing.yaw = -this.leftWing.yaw;
        this.rightWing.pivotY = this.leftWing.pivotY;
        this.rightWing.pitch = this.leftWing.pitch;
        this.rightWing.roll = -this.leftWing.roll;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void animateModel(Entity entity, float limbAngle, float limbDistance, float tickDelta) {
        super.animateModel(entity, limbAngle, limbDistance, tickDelta);
    }

    @Override
    public void copyStateTo(EntityModel copy) {
        super.copyStateTo(copy);
    }
}
