package xyz.volartrix.amethyst.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class  CommandAmethyst implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage("Amethyst Version Alpha 0.0.1.\n" +
                "Developed by RaphtikAtGHG.\n" +
                "Licensed under Apache License 2.0.\n");
        return true;
    }
}
