package net.selene.apothecary.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(net.selene.apothecary.Apothecary.MOD_ID)
public class Apothecary {
    public Apothecary() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(net.selene.apothecary.Apothecary.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        net.selene.apothecary.Apothecary.init();
    }
}
