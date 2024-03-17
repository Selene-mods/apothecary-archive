package net.selene.apothecary.util;

import net.minecraft.resources.ResourceLocation;
import net.selene.apothecary.Apothecary;

public class ApothecaryIdentifier extends ResourceLocation {
    public ApothecaryIdentifier(String path) {
        super(Apothecary.MOD_ID, path);
    }
}