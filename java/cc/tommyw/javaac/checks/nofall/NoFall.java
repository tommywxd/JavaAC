package cc.tommyw.javaac.checks.nofall;

import cc.tommyw.javaac.util.Violations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class NoFall implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location from = e.getFrom().clone();
        Location to = e.getTo().clone();

        Vector vec = to.toVector();
        double i = vec.distance(from.toVector());

        if (i == 0.0D) {
            return;
        }

        if (p.getGameMode().equals(GameMode.CREATIVE) | p.getGameMode().equals(GameMode.SPECTATOR)) {
            return;
        }

        if (p.getVehicle() != null) {
            return;
        }

        if (from.getY() < to.getY()) {
            return;
        }

        if ((p.getFallDistance() == 0.0F) && (i > 0.90D && (p.isOnGround()))) {
            Violations.addVL(e.getPlayer(), 1);
            Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.RED + " might be using NoFall! " + ChatColor.GRAY + ChatColor.ITALIC + "(( " + Violations.getVL(e.getPlayer()) + " ))");
            e.setCancelled(true);
        }
    }
}
