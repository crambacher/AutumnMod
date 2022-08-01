package net.firebrandomega.autumn.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.entity.DeerEntity;
import net.firebrandomega.autumn.entity.RaccoonEntity;
import net.firebrandomega.autumn.entity.SquirrelEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(AutumnMod.MOD_ID,"raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,RaccoonEntity::new)
            .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());

    public static final EntityType<SquirrelEntity> SQUIRREL = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(AutumnMod.MOD_ID,"squirrel"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SquirrelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());

    public static final EntityType<DeerEntity> DEER = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(AutumnMod.MOD_ID,"deer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,DeerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON,RaccoonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DEER, DeerEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SQUIRREL, SquirrelEntity.setAttributes());
    }
}
