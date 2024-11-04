package xyz.volartrix.amethyst;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.volartrix.amethyst.util.AmLogger;

import java.util.logging.Logger;

import static xyz.volartrix.amethyst.commands.CommandManager.register_commands;
import static xyz.volartrix.amethyst.events.EventManager.register_events;

public class AmethystPlugin extends JavaPlugin implements Listener {

    public static AmLogger LOGGER = null;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        LOGGER = new AmLogger("Main", this.getLogger());

        for (Plugin p : Bukkit.getPluginManager().getPlugins()) {
            LOGGER.info("Plugin Found: " + p.getName());
        }

        register_commands(this);

        register_events(this);

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        LOGGER.info("Player Joined: " + event.getPlayer().getName());
        LOGGER.info("Player Count: " + Bukkit.getOnlinePlayers().size());
        LOGGER.info("Players and their UUIDs and IPs: ");
        for (Player p : Bukkit.getOnlinePlayers()) {
            LOGGER.info("- " + p.getName() + ", " + p.getUniqueId() + ", " + p.getAddress());
        }
    }
}
