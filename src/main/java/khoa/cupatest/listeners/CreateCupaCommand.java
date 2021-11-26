package khoa.cupatest.listeners;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import khoa.cupatest.CupaTest;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CreateCupaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            CraftPlayer craftPlayer = (CraftPlayer) player;
            ServerPlayer sp = craftPlayer.getHandle();

            MinecraftServer server = sp.getServer();
            ServerLevel level = sp.getLevel();
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "Cupa Creeper");

            String signature = "sqD3GIh5EUpHSW2Js4D3RS9P0cJ1Zt3CwK6uxCwgz8UyhQXNWsAvrfyuN+cdXP2tW5MRLWj8jqH/22UJK9/McTyNCeLi0f8ziYMM6X30JMLE40IrxIG+6AjbVt3jhbvj5yT+IMUxUplVDpSSCCh7cn8dy5EdgsKiMFkLzig4VZfG2tqoDugva3/PJzsCQdXkWeZ+ic/CHr+20/YipuRdS/PA4NPyjtJYSKwxj5FZXbpl5wnxuTiKpMLgQHShbdtn7sVD0gb6DVgxTOzyM8NsVA+dihQY0otBNlcPEedrawajkS/FFVcyNCUPlpDurs3GBoGJowMVkb6AgUVVgJUTHoc2aPq6HReolp+C3j3pm+76S/H/FWJGkBrNF48H6R1zlLpgvGaPJH3ePsFG2K6o8cVMNhwave87cWSZuai8Ohi+s14co59dQpvaV5A057atRW0OCYnUspHAZzeVRN9pvmDW2wRkX3PuMzRotNcqjmBCnETbSAkePBzEOAILTmRceLcQ6LwThPnJqlp0y6UQ7QPNr+t+uGjQWlj1N/YG6hQpOR2ym2jfputyzoF2Y7uaDiknsZ64XwZRoVTtCi+88Zg6hkV1o8/cm2IvDWPoohzqCOh8m4bNYeLo0lzkfy0wlI60tOmLiOoEtNgFPKjSmMHDpRwNgRVEdp+DnZO6eFk=";
            String texture = "ewogICJ0aW1lc3RhbXAiIDogMTYzNzIxNTIyMDExOSwKICAicHJvZmlsZUlkIiA6ICIxNzNmNWI1NGQzZDY0NzRmYTVlYzg0NDIwMmU3ZTcwMSIsCiAgInByb2ZpbGVOYW1lIiA6ICJNYWdtYVBpbGxhciIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8zZjRiNDE5MWY4MDAyMTRjZmI2NzM2YzRlZmUwOTFiZDc2ODA2NTEzNTU4MTFhODJhZjM1OTRmYTY0MzdjMWEzIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";

            gameProfile.getProperties().put("texture", new Property("textures", texture, signature));

            ServerPlayer npc = new ServerPlayer(server, level, gameProfile);
            npc.setPos(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());


            ServerGamePacketListenerImpl ps = sp.connection;


            //PlayerInfoPacket
            ps.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.ADD_PLAYER, npc));

            //Spawn Packet
            ps.send(new ClientboundAddPlayerPacket(npc));

            player.sendMessage("Cupa :)");

            CupaTest.getPlugin().getNpcs().add(npc);

        }


        return true;
    }
}
