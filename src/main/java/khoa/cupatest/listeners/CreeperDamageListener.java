package khoa.cupatest.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class CreeperDamageListener  implements Listener {

    @EventHandler
    public void onCreeperDamage(EntityDamageByEntityEvent e){

        Player player = (Player) e.getDamager();
        Entity entity = e.getEntity();
        if (entity.getType() == EntityType.CREEPER){
            e.setCancelled(true);
            player.sendMessage("Don't hurt Cupa D:");
        }
    }
}
