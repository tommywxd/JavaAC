package cc.tommyw.javaac.checks.reach;

import cc.tommyw.javaac.util.Violations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Reach implements Listener {
    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent e) {
        if(e.getDamager().getType().equals(EntityType.PLAYER)) {
            Player damager = (Player) e.getDamager();
            if(damager.getLocation().distanceSquared(e.getEntity().getLocation()) > 22) {
                Violations.addVL((Player)e.getDamager(), 1);
                Bukkit.broadcastMessage(((Player)e.getDamager()).getDisplayName() + ChatColor.RED + " might be using Reach! " + ChatColor.GRAY + ChatColor.ITALIC + "(( " + Violations.getVL((Player)e.getDamager()) + " ))");
                e.setCancelled(true);
            }
        }
    }
}
