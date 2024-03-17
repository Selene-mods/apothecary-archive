package net.selene.apothecary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.selene.apothecary.Apothecary;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Apothecary.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> APOTHECARY_TAB = CREATIVE_MODE_TABS.register("apothecary", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
            .icon(() -> new ItemStack(ObjectRegistry.TRUFFLE.get()))
            .title(Component.translatable("creativetab.apothecary.tab"))
            .displayItems((parameters, out) -> {
                out.accept(ObjectRegistry.TRUFFLE.get());
                out.accept(ObjectRegistry.MANDRAKE.get());
                out.accept(ObjectRegistry.FOUR_LEAF_CLOVER.get());

                out.accept(ObjectRegistry.INGREDIENTS_SHELF.get());
                out.accept(ObjectRegistry.POTION_SHELF.get());
                out.accept(ObjectRegistry.MIXED_SHELF.get());
            })
            .build());

    public static void init() {
        CREATIVE_MODE_TABS.register();
    }
}