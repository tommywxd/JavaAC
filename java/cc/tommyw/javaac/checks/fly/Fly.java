package cc.tommyw.javaac.checks.fly;

import cc.tommyw.javaac.util.Storage;
import cc.tommyw.javaac.util.Violations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Fly implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (System.currentTimeMillis() - Storage.joinDates.get(e.getPlayer().getUniqueId()) > 5000) {
            if(System.currentTimeMillis() - Storage.lastOnGround.get(e.getPlayer().getUniqueId()) > 500) {
                if(e.getTo().getY() >= e.getFrom().getY()) {
                    e.setCancelled(true);
                    Violations.addVL(e.getPlayer(), 1);
                    Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.RED + " might be using Fly! " + ChatColor.GRAY + ChatColor.ITALIC + "(( " + Violations.getVL(e.getPlayer()) + " ))");
                }
            }
        }
    }
}
