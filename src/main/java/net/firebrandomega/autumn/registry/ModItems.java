package net.firebrandomega.autumn.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.firebrandomega.autumn.AutumnMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Items
    public static final Item ACORN = new Item(new Item.Settings().group(AutumnMod.ITEM_GROUP).food(
            new FoodComponent.Builder().saturationModifier(0.25F).hunger(1).build()));

    public static final Item LEAF = new Item(new Item.Settings().group(AutumnMod.ITEM_GROUP));

    public static final Item RACCOON_SPAWN_EGG = new SpawnEggItem(ModEntities.RACCOON,
            0x948e8d, 0x3b3635,
            new FabricItemSettings().group(AutumnMod.ITEM_GROUP));

    public static final Item DEER_SPAWN_EGG = new SpawnEggItem(ModEntities.DEER,
            0xd99f68, 0xf7eddc,
            new FabricItemSettings().group(AutumnMod.ITEM_GROUP));

    public static final Item SQUIRREL_SPAWN_EGG = new SpawnEggItem(ModEntities.SQUIRREL,
            0x93999e, 0x696a6b,
            new FabricItemSettings().group(AutumnMod.ITEM_GROUP));


    //Block Items
    public static final BlockItem AUTUMN_LEAVES_RED = new BlockItem(ModBlocks.AUTUMN_LEAVES_RED, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem AUTUMN_LEAVES_ORANGE = new BlockItem(ModBlocks.AUTUMN_LEAVES_ORANGE, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem AUTUMN_LEAVES_YELLOW = new BlockItem(ModBlocks.AUTUMN_LEAVES_YELLOW, new Item.Settings().group(AutumnMod.ITEM_GROUP));

    public static final BlockItem LEAF_COVER = new BlockItem(ModBlocks.LEAF_COVER, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem AUTUMN_WOOD = new BlockItem(ModBlocks.AUTUMN_WOOD, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem AUTUMN_LOG = new BlockItem(ModBlocks.AUTUMN_LOG, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem STRIPPED_AUTUMN_LOG = new BlockItem(ModBlocks.STRIPPED_AUTUMN_LOG, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem STRIPPED_AUTUMN_WOOD = new BlockItem(ModBlocks.STRIPPED_AUTUMN_WOOD, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem AUTUMN_PLANKS = new BlockItem(ModBlocks.AUTUMN_PLANKS, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem RED_AUTUMN_SAPLING = new BlockItem(ModBlocks.RED_AUTUMN_SAPLING, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem ORANGE_AUTUMN_SAPLING = new BlockItem(ModBlocks.ORANGE_AUTUMN_SAPLING, new Item.Settings().group(AutumnMod.ITEM_GROUP));
    public static final BlockItem YELLOW_AUTUMN_SAPLING = new BlockItem(ModBlocks.YELLOW_AUTUMN_SAPLING, new Item.Settings().group(AutumnMod.ITEM_GROUP));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_red"), AUTUMN_LEAVES_RED);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_orange"), AUTUMN_LEAVES_ORANGE);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_yellow"), AUTUMN_LEAVES_YELLOW);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "acorn"), ACORN);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "leaf"), LEAF);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "leaf_cover"), LEAF_COVER);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "autumn_planks"), AUTUMN_PLANKS);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "stripped_autumn_wood"), STRIPPED_AUTUMN_WOOD);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "stripped_autumn_log"), STRIPPED_AUTUMN_LOG);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "autumn_log"), AUTUMN_LOG);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "autumn_wood"), AUTUMN_WOOD);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "red_autumn_sapling"), RED_AUTUMN_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "orange_autumn_sapling"), ORANGE_AUTUMN_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "yellow_autumn_sapling"), YELLOW_AUTUMN_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "raccoon_spawn_egg"), RACCOON_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "deer_spawn_egg"), DEER_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(AutumnMod.MOD_ID, "squirrel_spawn_egg"), SQUIRREL_SPAWN_EGG);
    }
}
