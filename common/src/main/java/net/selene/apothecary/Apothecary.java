package net.selene.apothecary;

import com.google.common.base.Suppliers;
import dev.architectury.platform.Mod;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.selene.apothecary.block.ModBlocks;
import net.selene.apothecary.item.ModItemGroups;
import net.selene.apothecary.item.ModItems;
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
        ModBlocks.registerModBLocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        
        System.out.println(ApothecaryExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
