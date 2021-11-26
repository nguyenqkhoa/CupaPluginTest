package khoa.cupatest.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class CreeperMakeCupa implements Listener {

    @EventHandler
    public void MakeCreeperCupa(PlayerInteractEntityEvent e){

        Player player = e.getPlayer();
        Mob mob = (Mob) e.getRightClicked();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (mob.getType() == EntityType.CREEPER && mob.isAware() && item.getType() == Material.CREEPER_HEAD){
            mob.setAware(false);
            player.sendMessage("Creeper false");
        }
        else if (mob.getType() == EntityType.CREEPER && !mob.isAware() && item.getType() == Material.MUSIC_DISC_CAT){
            mob.setAware(true);
            player.sendMessage("Creeper true");
        }
        //Entity entity = e.getRightClicked();

    }

}
