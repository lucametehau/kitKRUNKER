package ro.coderdojo.kitkrunker;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Register Event Listeners
        getServer().getPluginManager().registerEvents(new EventsListener(), this);

        //Register Command Executors
        this.getCommand("CoderDojo").setExecutor(new CoderDojoCommand());
        this.getCommand("KitSniper").setExecutor(new KitSniper());
        this.getCommand("KitTank").setExecutor(new KitTank());

    }

}
