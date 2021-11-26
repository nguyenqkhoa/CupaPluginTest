package khoa.cupatest.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
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
        Mob mob = (Mob) e.getEntity();
        Entity entity = e.getEntity();
        if (mob.getType() == EntityType.CREEPER && !mob.isAware()){
            e.setCancelled(true);
            player.sendMessage("Don't hurt Cupa D:");
        }
        else if (mob.getType() == EntityType.CREEPER && mob.isAware()){
            player.sendMessage("The enemy Creeper...");
        }
    }
}
