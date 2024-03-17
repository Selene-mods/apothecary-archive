package net.selene.apothecary.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.selene.apothecary.Apothecary;

public class ModItemGroups {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Apothecary.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> APOTHECARY_TAB = TABS.register("apothecary_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + Apothecary.MOD_ID + ".tab"),
                    () -> new ItemStack(ModItems.TRUFFLE.get())));

    public static void registerItemGroups() {
        Apothecary.LOGGER.info("Registering items groups for {}...", Apothecary.MOD_ID);

        TABS.register();
    }
}
