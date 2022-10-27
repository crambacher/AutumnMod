package net.firebrandomega.autumn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.firebrandomega.autumn.AutumnMod;
import net.firebrandomega.autumn.registry.ModBlocks;
import net.firebrandomega.autumn.registry.ModItems;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        offerShapelessRecipe(exporter, ModBlocks.AUTUMN_PLANKS, ModBlocks.AUTUMN_LOG, "autumn_planks",4);
        offerShapelessRecipe(exporter, ModBlocks.AUTUMN_PLANKS, ModBlocks.STRIPPED_AUTUMN_LOG, "autumn_planks",4);
        offerShapelessRecipe(exporter, ModBlocks.AUTUMN_PLANKS, ModBlocks.AUTUMN_WOOD, "autumn_planks",4);
        offerShapelessRecipe(exporter, ModBlocks.AUTUMN_PLANKS, ModBlocks.STRIPPED_AUTUMN_WOOD, "autumn_planks",4);


        offerReversibleCompactingRecipes(exporter, ModItems.LEAF, ModItems.LEAF_COVER);


        ShapedRecipeJsonBuilder.create(ModItems.AUTUMN_WINGS)
                .pattern("###").pattern("#I#").pattern("###")
                .input('#', ModItems.LEAF)
                .input('I', Items.ELYTRA)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.ELYTRA), RecipeProvider.conditionsFromItem(Items.ELYTRA))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "autumn_wings"));


        ShapedRecipeJsonBuilder.create(ModItems.AUTUMN_LEAVES_RED)
                .pattern("###").pattern("#I#").pattern("###")
                .input('#', ModItems.LEAF)
                .input('I', Items.RED_DYE)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.RED_DYE), RecipeProvider.conditionsFromItem(Items.RED_DYE))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_red"));
        ShapedRecipeJsonBuilder.create(ModItems.AUTUMN_LEAVES_ORANGE)
                .pattern("###").pattern("#I#").pattern("###")
                .input('#', ModItems.LEAF)
                .input('I', Items.ORANGE_DYE)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.ORANGE_DYE), RecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_orange"));
        ShapedRecipeJsonBuilder.create(ModItems.AUTUMN_LEAVES_YELLOW)
                .pattern("###").pattern("#I#").pattern("###")
                .input('#', ModItems.LEAF)
                .input('I', Items.YELLOW_DYE)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.YELLOW_DYE), RecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_yellow"));


        ShapedRecipeJsonBuilder.create(ModItems.RED_LEAFY_GRASS)
                .pattern("G#G").pattern("#I#").pattern("G#G")
                .input('#', ModItems.LEAF)
                .input('I', Items.RED_DYE)
                .input('G', Items.GRASS)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.RED_DYE), RecipeProvider.conditionsFromItem(Items.RED_DYE))
                .criterion(RecipeProvider.hasItem(Items.GRASS), RecipeProvider.conditionsFromItem(Items.GRASS))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "red_leafy_grass"));
        ShapedRecipeJsonBuilder.create(ModItems.YELLOW_LEAFY_GRASS)
                .pattern("G#G").pattern("#I#").pattern("G#G")
                .input('#', ModItems.LEAF)
                .input('I', Items.YELLOW_DYE)
                .input('G', Items.GRASS)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.YELLOW_DYE), RecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .criterion(RecipeProvider.hasItem(Items.GRASS), RecipeProvider.conditionsFromItem(Items.GRASS))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "yellow_leafy_grass"));
        ShapedRecipeJsonBuilder.create(ModItems.ORANGE_LEAFY_GRASS)
                .pattern("G#G").pattern("#I#").pattern("G#G")
                .input('#', ModItems.LEAF)
                .input('I', Items.ORANGE_DYE)
                .input('G', Items.GRASS)
                .criterion(RecipeProvider.hasItem(ModItems.LEAF), RecipeProvider.conditionsFromItem(ModItems.LEAF))
                .criterion(RecipeProvider.hasItem(Items.ORANGE_DYE), RecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .criterion(RecipeProvider.hasItem(Items.GRASS), RecipeProvider.conditionsFromItem(Items.GRASS))
                .offerTo(exporter, new Identifier(AutumnMod.MOD_ID, "orange_leafy_grass"));

        ShapedRecipeJsonBuilder.create(ModItems.AUTUMN_WOOD)
                .pattern("##").pattern("##")
                .input('#', ModBlocks.AUTUMN_LOG)
                .criterion(RecipeProvider.hasItem(ModItems.AUTUMN_LOG), RecipeProvider.conditionsFromItem(ModItems.AUTUMN_LOG))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.AUTUMN_WOOD)));

    }
}
