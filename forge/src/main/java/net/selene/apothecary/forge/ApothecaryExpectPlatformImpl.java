package net.selene.apothecary.forge;

import net.selene.apothecary.ApothecaryExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ApothecaryExpectPlatformImpl {
    /**
     * This is our actual method to {@link ApothecaryExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
