package khoa.cupatest;

import khoa.cupatest.listeners.CreeperDamageListener;
import khoa.cupatest.listeners.CreeperExplosionListener;
import khoa.cupatest.listeners.CreeperMakeCupa;
import org.bukkit.plugin.java.JavaPlugin;

public final class CupaTest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new CreeperDamageListener(), this);
        getServer().getPluginManager().registerEvents(new CreeperExplosionListener(), this);
        getServer().getPluginManager().registerEvents(new CreeperMakeCupa(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
