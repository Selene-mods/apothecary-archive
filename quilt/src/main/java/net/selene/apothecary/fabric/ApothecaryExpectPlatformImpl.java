package net.selene.apothecary.fabric;

import net.selene.apothecary.ApothecaryExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class ApothecaryExpectPlatformImpl {
    /**
     * This is our actual method to {@link ApothecaryExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
