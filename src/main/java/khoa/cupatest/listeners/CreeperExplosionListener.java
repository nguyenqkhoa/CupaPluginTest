package khoa.cupatest.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class CreeperExplosionListener implements Listener {

    @EventHandler
    public void onCreeperExplosion(ExplosionPrimeEvent e){

        Entity entity = e.getEntity();
        if(entity.getType() == EntityType.CREEPER){
            e.setCancelled(true);
        }

    }
}
