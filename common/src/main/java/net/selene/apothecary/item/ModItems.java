package net.selene.apothecary.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.selene.apothecary.Apothecary;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Apothecary.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover", () ->
            new Item(new Item.Properties().arch$tab(ModItemGroups.APOTHECARY_TAB)));
    public static final RegistrySupplier<Item> TRUFFLE = ITEMS.register("truffle", () ->
            new Item(new Item.Properties().arch$tab(ModItemGroups.APOTHECARY_TAB)));
    public static final RegistrySupplier<Item> MANDRAKE = ITEMS.register("mandrake", () ->
            new Item(new Item.Properties().arch$tab(ModItemGroups.APOTHECARY_TAB)));

    public static void registerModItems() {
        Apothecary.LOGGER.info("Registering items for {}...", Apothecary.MOD_ID);

        ITEMS.register();
    }
}
