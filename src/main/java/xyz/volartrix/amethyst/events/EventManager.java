package xyz.volartrix.amethyst.events;

import org.bukkit.plugin.java.JavaPlugin;

import static xyz.volartrix.amethyst.AmethystPlugin.LOGGER;

public class EventManager {

    public static void register_events(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new EnderDragonDeath(), plugin);
        LOGGER.info("Registered Event: 'EnderDragonDeath'.");
    }

}
