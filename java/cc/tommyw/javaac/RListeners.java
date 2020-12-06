package cc.tommyw.javaac;

import cc.tommyw.javaac.util.Ground;
import cc.tommyw.javaac.util.Storage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RListeners implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {
        Storage.joinDates.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
    }

    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent e) {
        Storage.joinDates.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e) {
        if(!Ground.onGround(e.getPlayer())) {
            Storage.lastOnGround.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
        }
    }
}
