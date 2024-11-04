package xyz.volartrix.amethyst.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandPlayerinfo implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Usage: /pinfo <player>");
            return false;
        }

        String player = args[0];
        Player target = sender.getServer().getPlayer(player);


        if (target == null || !target.isOnline()) {
            sender.sendMessage("Player not found.");
            return false;
        }

        sender.sendMessage("Player: " + target.getName());
        sender.sendMessage("- UUID: " + target.getUniqueId());
        sender.sendMessage("- IP: " + target.getAddress());
        sender.sendMessage("- Health: " + target.getHealth());
        sender.sendMessage("- Food Level: " + target.getFoodLevel());
        sender.sendMessage("- Location: " + target.getLocation());
        sender.sendMessage("- Gamemode: " + target.getGameMode());
        sender.sendMessage("- World: " + target.getWorld().getName());


        return true;
    }
}
