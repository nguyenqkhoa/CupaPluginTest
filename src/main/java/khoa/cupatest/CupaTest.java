package khoa.cupatest;

import khoa.cupatest.listeners.*;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CupaTest extends JavaPlugin {

    private List<ServerPlayer> npcs = new ArrayList<>();
    private static CupaTest plugin;


    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getCommand("createcupa").setExecutor(new CreateCupaCommand());
        getServer().getPluginManager().registerEvents(new CreeperDamageListener(), this);
        getServer().getPluginManager().registerEvents(new CreeperExplosionListener(), this);
        getServer().getPluginManager().registerEvents(new CreeperMakeCupa(), this);
        getServer().getPluginManager().registerEvents(new MovementListener(), this);

    }

    public List<ServerPlayer> getNpcs() {
        return npcs;
    }

    public static CupaTest getPlugin() {
        return plugin;
    }


}
