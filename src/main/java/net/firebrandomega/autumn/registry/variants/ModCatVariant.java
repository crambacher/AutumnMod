package net.firebrandomega.autumn.registry.variants;

import net.minecraft.entity.passive.CatVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModCatVariant{

    public static final CatVariant ALL_BLACK = ModCatVariant.register("all_black", "textures/entity/cat/all_black.png");

    public static CatVariant register(String id, String textureId) {
        return Registry.register(Registry.CAT_VARIANT, id, new CatVariant(new Identifier(textureId)));
    }
}
