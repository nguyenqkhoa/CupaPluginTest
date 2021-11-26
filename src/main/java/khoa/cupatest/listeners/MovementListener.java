package khoa.cupatest.listeners;

import khoa.cupatest.CupaTest;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player p = e.getPlayer();

        CupaTest.getPlugin().getNpcs().stream().forEach(npc -> {

            Location location = npc.getBukkitEntity().getLocation();
            ((Location) location).setDirection(e.getPlayer().getLocation().subtract(location).toVector());
            float yaw = location.getYaw();
            float pitch = location.getPitch();

            ServerGamePacketListenerImpl ps = ((CraftPlayer) p).getHandle().connection;

            //Roate head packet- horozontal head movement
            ps.send(new ClientboundRotateHeadPacket(npc, (byte) ((yaw%360)*256/360)));

            //Move entity packet - vertical head movmenet
            ps.send(new ClientboundMoveEntityPacket.Rot(npc.getBukkitEntity().getEntityId(), (byte) ((yaw%360.)*256/360), (byte) ((pitch%360.)*256/360), false));


        });



    }


}
