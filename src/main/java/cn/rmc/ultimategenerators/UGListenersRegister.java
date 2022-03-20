package cn.rmc.ultimategenerators;


import cn.rmc.ultimategenerators.listeners.EnderCrystalEnhancerListener;
import cn.rmc.ultimategenerators.listeners.UltimateElectricityStorageCraftingListener;

class UGListenersRegister {

    private final UltimateGenerators plug;

    public UGListenersRegister(UltimateGenerators loader) {
        this.plug = loader;
    }

    public void registerAll() {
        plug.getServer().getPluginManager().registerEvents(new UltimateElectricityStorageCraftingListener(), plug);
        plug.getServer().getPluginManager().registerEvents(new EnderCrystalEnhancerListener(), plug);
        // plug.getServer().getPluginManager().registerEvents(new ReinforcedRainbowGlassBlastProofListener(), Loader.getImplement());
    }

}
