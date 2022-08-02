package net.firebrandomega.autumn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.firebrandomega.autumn.entity.client.DeerRenderer;
import net.firebrandomega.autumn.entity.client.PageRenderer;
import net.firebrandomega.autumn.entity.client.RaccoonRenderer;
import net.firebrandomega.autumn.entity.client.SquirrelRenderer;
import net.firebrandomega.autumn.particle.OrangeLeafParticle;
import net.firebrandomega.autumn.particle.RedLeafParticle;
import net.firebrandomega.autumn.particle.YellowLeafParticle;
import net.firebrandomega.autumn.registry.ModBlocks;
import net.firebrandomega.autumn.registry.ModEntities;
import net.firebrandomega.autumn.registry.ModParticles;
import net.minecraft.client.render.RenderLayer;

public class AutumnModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AUTUMN_LEAVES_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AUTUMN_LEAVES_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AUTUMN_LEAVES_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_AUTUMN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_AUTUMN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_AUTUMN_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);
        EntityRendererRegistry.register(ModEntities.DEER, DeerRenderer::new);
        EntityRendererRegistry.register(ModEntities.SQUIRREL, SquirrelRenderer::new);
        EntityRendererRegistry.register(ModEntities.PAGE, PageRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_LEAF_PARTICLE, RedLeafParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_LEAF_PARTICLE, OrangeLeafParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_LEAF_PARTICLE, YellowLeafParticle.Factory::new);
    }
}