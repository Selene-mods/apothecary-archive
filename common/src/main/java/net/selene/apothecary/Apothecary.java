package net.selene.apothecary;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrarManager;
import net.selene.apothecary.registry.BlockEntityTypeRegistry;
import net.selene.apothecary.registry.ObjectRegistry;
import net.selene.apothecary.registry.SoundEventRegistry;
import net.selene.apothecary.registry.TabRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Apothecary {
    public static final String MOD_ID = "apothecary";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    // Registering a new creative tab
    
    public static void init() {
        ObjectRegistry.init();
        TabRegistry.init();
        BlockEntityTypeRegistry.init();
        SoundEventRegistry.init();

        
        System.out.println(ApothecaryExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
