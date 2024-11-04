package xyz.volartrix.amethyst.commands;


import org.bukkit.plugin.java.JavaPlugin;

import static xyz.volartrix.amethyst.AmethystPlugin.LOGGER;

public class CommandManager {

    public static void register_commands(JavaPlugin plugin) {
        plugin.getCommand("amethyst").setExecutor(new CommandAmethyst());
        LOGGER.info("Registered Command: 'amethyst'.");
    }
}
