package net.selene.apothecary.fabric;

import net.selene.apothecary.ApothecaryExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class ApothecaryExpectPlatformImpl {
    /**
     * This is our actual method to {@link ApothecaryExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
