package net.firebrandomega.autumn;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.firebrandomega.autumn.registry.ModBlocks;
import net.firebrandomega.autumn.registry.ModEntities;
import net.firebrandomega.autumn.registry.ModItems;
import net.firebrandomega.autumn.registry.ModParticles;
import net.firebrandomega.autumn.world.feature.ModConfiguredFeatures;
import net.firebrandomega.autumn.world.feature.ModPlacedFeatures;
import net.firebrandomega.autumn.world.gen.ModWorldGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class AutumnMod implements ModInitializer {

	public static final String MOD_ID = "autumn";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(ModItems.ACORN));
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModEntities.registerAttributes();
		ModParticles.registerParticles();
		ModBlocks.registerFlammableBlocks();
		ModBlocks.registerStrippables();

		ModWorldGen.generateModWorldGen();
		GeckoLib.initialize();
	}
}
