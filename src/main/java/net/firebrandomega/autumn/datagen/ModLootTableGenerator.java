package net.firebrandomega.autumn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.registry.ModBlocks;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLootTableGenerator extends SimpleFabricLootTableProvider {
    public ModLootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/autumn_planks"), BlockLootTableGenerator.drops(ModBlocks.AUTUMN_PLANKS));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/autumn_log"), BlockLootTableGenerator.drops(ModBlocks.AUTUMN_LOG));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/autumn_wood"), BlockLootTableGenerator.drops(ModBlocks.AUTUMN_WOOD));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/stripped_autumn_log"), BlockLootTableGenerator.drops(ModBlocks.STRIPPED_AUTUMN_LOG));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/stripped_autumn_wood"), BlockLootTableGenerator.drops(ModBlocks.STRIPPED_AUTUMN_WOOD));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/leaf_cover"), BlockLootTableGenerator.drops(ModBlocks.LEAF_COVER));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/red_leafy_grass"), BlockLootTableGenerator.drops(ModBlocks.RED_LEAFY_GRASS));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/orange_leafy_grass"), BlockLootTableGenerator.drops(ModBlocks.ORANGE_LEAFY_GRASS));
        identifierBuilderBiConsumer.accept(new Identifier(AutumnMod.MOD_ID, "blocks/yellow_leafy_grass"), BlockLootTableGenerator.drops(ModBlocks.YELLOW_LEAFY_GRASS));

    }
}
