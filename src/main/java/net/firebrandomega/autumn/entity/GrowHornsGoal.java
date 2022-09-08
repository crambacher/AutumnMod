package net.firebrandomega.autumn.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;

import static net.firebrandomega.autumn.entity.DeerEntity.GROW_HORNS_TARGET_PREDICATE;

public class GrowHornsGoal extends Goal {

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
