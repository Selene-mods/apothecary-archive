package net.selene.apothecary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.selene.apothecary.Apothecary;
import net.selene.apothecary.util.ApothecaryIdentifier;
import net.selene.apothecary.entity.blockentities.*;

import java.util.function.Supplier;

public class BlockEntityTypeRegistry {

    private static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Apothecary.MOD_ID, Registries.BLOCK_ENTITY_TYPE).getRegistrar();

    public static final RegistrySupplier<BlockEntityType<StorageBlockEntity>> INGREDIENTS_SHELF_STORAGE_ENTITY = create("ingredients_shelf_storage", () -> BlockEntityType.Builder.of(StorageBlockEntity::new, ObjectRegistry.INGREDIENTS_SHELF.get(), ObjectRegistry.POTION_SHELF.get(), ObjectRegistry.MIXED_SHELF.get()).build(null));

    private static <T extends BlockEntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(new ApothecaryIdentifier(path), type);
    }

    public static void init() {

    }
}