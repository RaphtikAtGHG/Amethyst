package xyz.volartrix.amethyst.commands;


import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static xyz.volartrix.amethyst.AmethystPlugin.LOGGER;

public class CommandManager {

    public static void register_commands(@NotNull JavaPlugin plugin) {
        plugin.getCommand("amethyst").setExecutor(new CommandAmethyst());
        LOGGER.info("Registered Command: 'amethyst'.");

        plugin.getCommand("pinfo").setExecutor(new CommandPlayerinfo());
        LOGGER.info("Registered Command: 'pinfo'.");
    }
}
