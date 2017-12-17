package me.xtimdevx.coresurvival.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by xTimDevx on 12/11/2017.
 */
public class DamageEvent implements Listener{

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if(entity.getType() == EntityType.VILLAGER) {
            if(event.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {
                event.setCancelled(true);
            }
        }
    }
}
