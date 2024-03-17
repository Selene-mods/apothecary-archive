package net.selene.apothecary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.selene.apothecary.Apothecary;
import net.selene.apothecary.util.ApothecaryIdentifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SoundEventRegistry {
    private static final Registrar<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Apothecary.MOD_ID, Registries.SOUND_EVENT).getRegistrar();

    public static final RegistrySupplier<SoundEvent> SHELF_OPEN = create("shelf_open");
    public static final RegistrySupplier<SoundEvent> SHELF_CLOSE = create("shelf_close");


    private static RegistrySupplier<SoundEvent> create(String name) {
        final ResourceLocation id = new ApothecaryIdentifier(name);
        return SOUND_EVENTS.register(id, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {

    }
}