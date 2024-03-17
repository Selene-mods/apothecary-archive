package net.selene.apothecary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.platform.Platform;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.selene.apothecary.Apothecary;
import net.selene.apothecary.block.*;
import net.selene.apothecary.util.ApothecaryIdentifier;

import java.util.function.Supplier;
import java.util.function.Consumer;

public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Apothecary.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Apothecary.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> POTION_SHELF = registerWithItem("potion_shelf", () -> new StorageBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.SHELF_OPEN.get(), SoundEventRegistry.SHELF_CLOSE.get()));
    public static final RegistrySupplier<Block> MIXED_SHELF = registerWithItem("mixed_shelf", () -> new StorageBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.SHELF_OPEN.get(), SoundEventRegistry.SHELF_CLOSE.get()));
    public static final RegistrySupplier<Block> INGREDIENTS_SHELF = registerWithItem("ingredients_shelf", () -> new StorageBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.SHELF_OPEN.get(), SoundEventRegistry.SHELF_CLOSE.get()));

    public static final RegistrySupplier<Item>  FOUR_LEAF_CLOVER = registerItem("four_leaf_clover", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item>  TRUFFLE = registerItem("truffle", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item>  MANDRAKE = registerItem("mandrake", () -> new Item(getSettings().food(Foods.POISONOUS_POTATO)));


    public static void init() {
        Apothecary.LOGGER.info("Registering blocks and items for {}...", Apothecary.MOD_ID);

        ITEMS.register();
        BLOCKS.register();
    }

    public static BlockBehaviour.Properties properties(float strength) {
        return properties(strength, strength);
    }

    public static BlockBehaviour.Properties properties(float breakSpeed, float explosionResist) {
        return BlockBehaviour.Properties.of().strength(breakSpeed, explosionResist);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new ApothecaryIdentifier(name), block);
    }
    

    public static <T extends Block> RegistrySupplier<T> registerWithItem(DeferredRegister<Block> registerB, Registrar<Block> registrarB, DeferredRegister<Item> registerI, Registrar<Item> registrarI, ResourceLocation name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = registerWithoutItem(registerB, registrarB, name, block);
        registerItem(registerI, registrarI, name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }
    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(DeferredRegister<Block> register, Registrar<Block> registrar, ResourceLocation path, Supplier<T> block) {
        if (Platform.isForge()) {
            return register.register(path.getPath(), block);
        }
        return registrar.register(path, block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return registerItem(ITEMS, ITEM_REGISTRAR, new ApothecaryIdentifier(path), itemSupplier);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(DeferredRegister<Item> register, Registrar<Item> registrar, ResourceLocation path, Supplier<T> itemSupplier) {
        if (Platform.isForge()) {
            return register.register(path.getPath(), itemSupplier);
        }
        return registrar.register(path, itemSupplier);
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {
        });
    }
}