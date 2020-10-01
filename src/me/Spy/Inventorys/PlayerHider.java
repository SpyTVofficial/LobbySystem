package me.Spy.Inventorys;

import me.Spy.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PlayerHider implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                p.getItemInHand().getType().equals(Material.BLAZE_ROD) &&
                p.getItemInHand().getItemMeta().getDisplayName().contains("§6§lPlayerhider")) {
            Inventory Inv = Bukkit.createInventory(p, 45, "§6§lPlayer Hider");
            for (int i = 0; i < Inv.getSize(); i++)
                Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            Inv.setItem(20, Utils.createItem(Material.WOOL, 1, 5, "§aAlle Spieler anzeigen"));
            Inv.setItem(22, Utils.createItem(Material.WOOL, 1, 10, "§5Nur Premium anzeigen"));
            Inv.setItem(24, Utils.createItem(Material.WOOL, 1, 14, "§cKeine Spieler anzeigen"));
            Inv.setItem(40, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            p.openInventory(Inv);
        }
    }
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = null;
        if (e.getWhoClicked() instanceof Player)
            p = (Player)e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInventar schließen")) {
            p.getOpenInventory().close();
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aAlle Spieler anzeigen")){
            for (Player players : Bukkit.getOnlinePlayers())
                p.showPlayer(players);
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Nur Premium anzeigen")){
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (players.hasPermission("Lobby.Premium") || players.isOp()) {
                    p.showPlayer(players);
                } else {
                    p.hidePlayer(players);
                }
            }
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cKeine Spieler anzeigen")){
            for (Player players : Bukkit.getOnlinePlayers())
                p.hidePlayer(players);
        }
    }
}