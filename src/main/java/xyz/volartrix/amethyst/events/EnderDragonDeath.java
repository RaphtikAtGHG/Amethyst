package xyz.volartrix.amethyst.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EnderDragonDeath implements Listener {
    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent event) {
        Entity killed = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (killer != null && killed instanceof EnderDragon) {
            killer.sendMessage("You killed the Ender Dragon!");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.BLUE + "The Ender Dragon has been slain by " + killer.getName() + "!");
            }
        }


        ItemStack endCrystal = new ItemStack(Material.END_CRYSTAL, 4);
        for (int i = 0; i < 4; i++) {
            killed.getWorld().dropItemNaturally(killed.getLocation(), endCrystal);
        }
    }

}
