package net.selene.apothecary.quilt;

import net.selene.apothecary.fabriclike.ApothecaryFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class ApothecaryQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        ApothecaryFabricLike.init();
    }
}
