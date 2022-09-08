package net.firebrandomega.autumn.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;
import java.util.function.Predicate;

public class DeerEntity extends AnimalEntity implements Mount, IAnimatable {

    private static final TrackedData<Integer> HORN_STATE = DataTracker.registerData(DeerEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private AnimationFactory factory = new AnimationFactory(this);

    public DeerEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private static final Predicate<LivingEntity> GROW_HORNS_FILTER = entity -> {
        return true;
    };
    static final TargetPredicate GROW_HORNS_TARGET_PREDICATE = TargetPredicate.createNonAttackable().ignoreDistanceScalingFactor().ignoreVisibility().setPredicate(GROW_HORNS_FILTER);

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0F)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1F));
        this.goalSelector.add(2, new WanderAroundPointOfInterestGoal(this, 0.6, false));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new GrowHornsGoal(this));
    }

    public static final int NOT_GROWN = 0;
    public static final int HALF_GROWN = 1;
    public static final int FULLY_GROWN = 2;

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HORN_STATE, 0);
    }

    public int getHornState() {
        return this.dataTracker.get(HORN_STATE);
    }

    public void setHornState(int hornState) {
        this.dataTracker.set(HORN_STATE, hornState);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("HornState", this.getHornState());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setHornState(Math.min(nbt.getInt("HornState"), 3));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deer.walk"));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deer.idle"));
        return PlayState.CONTINUE;
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1F);
    }


    /* RIDEABLE */
    public boolean canBeControlledByRider() {
        return this.getPrimaryPassenger() instanceof LivingEntity;
    }

    @Override
    @Nullable
    public Entity getPrimaryPassenger() {
        return this.getFirstPassenger();
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (!this.isAlive()) {
            return;
        }

        if (!(this.hasPassengers() && this.canBeControlledByRider())) {
            this.airStrafingSpeed = 0.02f;
            super.travel(movementInput);
            return;
        }

        LivingEntity livingEntity = (LivingEntity) this.getPrimaryPassenger();
        this.setYaw(livingEntity.getYaw());
        this.prevYaw = this.getYaw();
        this.setPitch(livingEntity.getPitch() * 0.5f);
        this.setRotation(this.getYaw(), this.getPitch());
        this.headYaw = this.bodyYaw = this.getYaw();
        float f = livingEntity.sidewaysSpeed * 0.5f;
        float g = livingEntity.forwardSpeed;
        if (g <= 0.0f) {
            g *= 0.25f;
        }

        if (this.isLogicalSideForUpdatingMovement()) {
            this.setMovementSpeed((float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
            super.travel(new Vec3d(f, movementInput.y, g));
        } else if (livingEntity instanceof PlayerEntity) {
            this.setVelocity(Vec3d.ZERO);
        }

        this.updateLimbs(this, false);
        this.tryCheckBlockCollision();
    }

    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        Vec3d vec3d = getPassengerDismountOffset(this.getWidth(), passenger.getWidth(),
                this.getYaw() + (passenger.getMainArm() == Arm.RIGHT ? 90.0f : -90.0f));
        Vec3d vec3d2 = this.locateSafeDismountingPos(vec3d, passenger);
        if (vec3d2 != null) {
            return vec3d2;
        }
        Vec3d vec3d3 = getPassengerDismountOffset(this.getWidth(), passenger.getWidth(),
                this.getYaw() + (passenger.getMainArm() == Arm.LEFT ? 90.0f : -90.0f));
        Vec3d vec3d4 = this.locateSafeDismountingPos(vec3d3, passenger);
        if (vec3d4 != null) {
            return vec3d4;
        }
        return this.getPos();
    }

    @Nullable
    private Vec3d locateSafeDismountingPos(Vec3d offset, LivingEntity passenger) {
        double d = this.getX() + offset.x;
        double e = this.getBoundingBox().minY;
        double f = this.getZ() + offset.z;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        block0:
        for (EntityPose entityPose : passenger.getPoses()) {
            mutable.set(d, e, f);
            double g = this.getBoundingBox().maxY + 0.75;
            do {
                Vec3d vec3d;
                Box box;
                double h = this.world.getDismountHeight(mutable);
                if ((double) mutable.getY() + h > g) continue block0;
                if (Dismounting.canDismountInBlock(h) && Dismounting.canPlaceEntityAt(this.world, passenger, (box = passenger.getBoundingBox(entityPose)).offset(vec3d = new Vec3d(d, (double) mutable.getY() + h, f)))) {
                    passenger.setPose(entityPose);
                    return vec3d;
                }
                mutable.move(Direction.UP);
            } while ((double) mutable.getY() < g);
        }
        return null;
    }

    /*
    public static final int NOT_GROWN = 0;
    public static final int SMALL_GROWN = 1;
    public static final int ALMOST_GROWN = 2;
    public static final int FULLY_GROWN = 3;
     */
    int inflateTicks;
    int deflateTicks;

    @Override
    public void tick(){
        if (!this.world.isClient && this.isAlive() && this.canMoveVoluntarily()) {
            if (this.inflateTicks > 0) {
                if (this.getHornState() == 0) {
                    this.setHornState(HALF_GROWN);
                } else if (this.inflateTicks > 40 && this.getHornState() == 1) {
                    this.setHornState(FULLY_GROWN);
                }
                ++this.inflateTicks;
            } else if (this.getHornState() != 0) {
                if (this.deflateTicks > 60 && this.getHornState() == 2) {
                    this.setHornState(HALF_GROWN);
                } else if (this.deflateTicks > 100 && this.getHornState() == 1) {
                    this.setHornState(NOT_GROWN);
                }
                ++this.deflateTicks;
            }
        }
        super.tick();
    }
    static class GrowHornsGoal extends Goal {

        private DeerEntity deer;

        public GrowHornsGoal(DeerEntity deer){
            this.deer = deer;
        }
        @Override
        public boolean canStart() {
            List<LivingEntity> list = this.deer.world.getEntitiesByClass(LivingEntity.class, this.deer.getBoundingBox(), livingEntity -> GROW_HORNS_TARGET_PREDICATE.test(this.deer, (LivingEntity)livingEntity));
            return !list.isEmpty();
        }

        @Override
        public void start(){
            this.deer.inflateTicks = 1;
            this.deer.deflateTicks = 0;
        }
    }

}
