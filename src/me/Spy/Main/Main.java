package me.Spy.Main;

import me.Spy.Gadgets.Enterhaken;
import me.Spy.Gadgets.JumpPads;
import me.Spy.Inventorys.Gadgets;
import me.Spy.Inventorys.PlayerHider;
import me.Spy.Inventorys.Profile;
import me.Spy.Listener.JoinQuitLISTENER;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        System.out.println("LobbySystem aktiviert!");
        init();
    }

    private void init(){
        //Listener
        Bukkit.getPluginManager().registerEvents(new JoinQuitLISTENER(), this);

        //Inventorys
        Bukkit.getPluginManager().registerEvents(new Gadgets(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerHider(), this);
        Bukkit.getPluginManager().registerEvents(new Profile(), this);

        //Gadgets
        Bukkit.getPluginManager().registerEvents(new Enterhaken(), this);
        Bukkit.getPluginManager().registerEvents(new JumpPads(), this);

        //Utils
        Bukkit.getPluginManager().registerEvents(new Utils(), this);
    }

    public void onDisable(){
        System.out.println("LobbySystem deaktiviert!");
    }
}
