package org.anhcraft.spaciouslib;

import org.anhcraft.spaciouslib.Inventory.InteractItem;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpaciousLib extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InteractItem(), this);
    }

    @Override
    public void onDisable() {

    }
}
