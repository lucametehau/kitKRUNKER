package ro.coderdojo.kitkrunker;

import java.util.Collection;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;


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
        @EventHandler
        public void particles(PlayerInteractEvent event)throws Exception{
        for(float a = 1; a < 120; a += 0.08f){
            Vector vector = event.getPlayer().getLocation().getDirection().normalize().clone().multiply(a);
            Location eye = event.getPlayer().getLocation().add(0, 1, 0).add(vector);
            
            eye.getBlock().setType(Material.AIR);
            Collection<Entity> entities = event.getPlayer().getLocation().getWorld().getNearbyEntities(eye, 0, 0, 0);
            for(Entity entity : entities){
                if(entity instanceof LivingEntity){
                    if(entity.getEntityId() == event.getPlayer().getEntityId()){
                        continue;
                    }
//                    double maxHealth = ((Attributable)entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
//                    ((org.bukkit.entity.LivingEntity) entity).damage(maxHealth );
                    ((LivingEntity) ((Attributable)entity)).setHealth(1);
                    
                }
            }
            event.getPlayer().getLocation().getWorld().spawnParticle(Particle.LAVA, eye, 0, 150, 30, 50, 1);
        }
    }
}
