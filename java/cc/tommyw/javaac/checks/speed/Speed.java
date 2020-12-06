package cc.tommyw.javaac.checks.speed;

import cc.tommyw.javaac.util.Violations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class Speed implements Listener {
    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e) {
        if(e.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
            return;
        }

        if(e.getPlayer().getVelocity().length() > 0.49) {
            //Violations.addVL(e.getPlayer(), 1);
            //Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.RED + " might be using Speed! " + ChatColor.GRAY + ChatColor.ITALIC + "(( " + Violations.getVL(e.getPlayer()) + " ))");
            //e.setCancelled(true);
        }
    }
}
