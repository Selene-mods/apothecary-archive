package net.selene.apothecary.fabric;

import net.selene.apothecary.fabriclike.ApothecaryFabricLike;
import net.fabricmc.api.ModInitializer;

public class ApothecaryFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ApothecaryFabricLike.init();
    }
}
