package net.firebrandomega.autumn.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.firebrandomega.autumn.AutumnMod;
//import net.firebrandomega.autumn.block.KnotBlock;
import net.firebrandomega.autumn.world.feature.tree.OrangeAutumnSaplingGenerator;
import net.firebrandomega.autumn.world.feature.tree.RedAutumnSaplingGenerator;
import net.firebrandomega.autumn.world.feature.tree.YellowAutumnSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block AUTUMN_LEAVES_RED = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
    public static final Block AUTUMN_LEAVES_ORANGE = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
    public static final Block AUTUMN_LEAVES_YELLOW = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));

    public static final Block RED_LEAFY_GRASS = new Block(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRASS));
    public static final Block YELLOW_LEAFY_GRASS = new Block(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRASS));
    public static final Block ORANGE_LEAFY_GRASS = new Block(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRASS));
    public static final Block LEAF_COVER = new Block(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRASS));

    //public static final Block KNOT_BLOCK = new KnotBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.2F).nonOpaque());

    public static final Block AUTUMN_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD));
    public static final Block AUTUMN_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_AUTUMN_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_AUTUMN_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.WOOD));
    public static final Block AUTUMN_PLANKS = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD));

    public static final Block RED_AUTUMN_SAPLING = new SaplingBlock(new RedAutumnSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.AZALEA_LEAVES));
    public static final Block ORANGE_AUTUMN_SAPLING = new SaplingBlock(new OrangeAutumnSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.AZALEA_LEAVES));
    public static final Block YELLOW_AUTUMN_SAPLING = new SaplingBlock(new YellowAutumnSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.AZALEA_LEAVES));


    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_red"),AUTUMN_LEAVES_RED);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_orange"),AUTUMN_LEAVES_ORANGE);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "autumn_leaves_yellow"),AUTUMN_LEAVES_YELLOW);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "leaf_cover"),LEAF_COVER);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "red_leafy_grass"), RED_LEAFY_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "orange_leafy_grass"), ORANGE_LEAFY_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "yellow_leafy_grass"), YELLOW_LEAFY_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "autumn_log"),AUTUMN_LOG);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "autumn_wood"),AUTUMN_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "red_autumn_sapling"),RED_AUTUMN_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "orange_autumn_sapling"),ORANGE_AUTUMN_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "yellow_autumn_sapling"),YELLOW_AUTUMN_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "stripped_autumn_log"),STRIPPED_AUTUMN_LOG);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "stripped_autumn_wood"),STRIPPED_AUTUMN_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "autumn_planks"),AUTUMN_PLANKS);
        //Registry.register(Registry.BLOCK, new Identifier(AutumnMod.MOD_ID, "knot_block"),KNOT_BLOCK);
    }

    public static void registerFlammableBlocks(){
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.AUTUMN_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_AUTUMN_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_AUTUMN_WOOD, 5, 5);
        instance.add(ModBlocks.AUTUMN_WOOD, 5, 5);
        instance.add(ModBlocks.AUTUMN_PLANKS, 5, 5);
        instance.add(ModBlocks.AUTUMN_LEAVES_RED, 30, 60);
        instance.add(ModBlocks.AUTUMN_LEAVES_ORANGE, 30, 60);
        instance.add(ModBlocks.AUTUMN_LEAVES_YELLOW, 30, 60);
        //instance.add(ModBlocks.KNOT_BLOCK, 5, 20);
    }

    public static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.AUTUMN_LOG,ModBlocks.STRIPPED_AUTUMN_LOG);
        StrippableBlockRegistry.register(ModBlocks.AUTUMN_WOOD,ModBlocks.STRIPPED_AUTUMN_WOOD);
    }
}
