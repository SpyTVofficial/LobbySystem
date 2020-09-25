package me.Spy.Listener;

import me.Spy.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitLISTENER implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        Location spawn = new Location(Bukkit.getWorld("Lobby"), 3D, 5D, 2D);
        p.getInventory().setItem(3, Utils.createItem(Material.CHEST, 1, 0, "§6§lGadgets"));
        p.getInventory().setItem(4, Utils.createItem(Material.COMPASS, 1, 0, "§b§lNavigator"));
        p.getInventory().setItem(5, Utils.createItem(Material.BLAZE_ROD, 1, 0, "§6§lPlayerhider"));
        p.getInventory().setItem(8, Utils.createItem(Material.REDSTONE, 1, 0, "§6§lProfil"));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p =e.getPlayer();
        e.setQuitMessage(null);
    }

}
