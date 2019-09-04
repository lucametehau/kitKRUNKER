package ro.coderdojo.kitkrunker;

import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public final class EventsListener implements Listener {
        HashMap <Player, Long> lastShot  = new HashMap();
	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
                lastShot.put(player, 0L);
	}
        @EventHandler
        public void onPlayerShoot(EntityShootBowEvent event) {
            Player player = (Player) event.getEntity();
            if(lastShot.get(player) + 2000 < System.currentTimeMillis()) {
                Entity arrow = event.getProjectile();
                arrow.setGravity(false);
                arrow.setVelocity(event.getProjectile().getVelocity().multiply(10));
                lastShot.replace(player, System.currentTimeMillis());
            } else {
                event.setCancelled(true);
            }
        }
}
