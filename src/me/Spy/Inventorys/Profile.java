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

public class Profile implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                p.getItemInHand().getType().equals(Material.CHEST) &&
                p.getItemInHand().getItemMeta().getDisplayName().contains("§6§lProfil")) {
            Inventory Inv = Bukkit.createInventory(p, 45, "");
            for (int i = 0; i < Inv.getSize(); i++)
                Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            Inv.setItem(44, Utils.createItem(Material.EMERALD, 1, 0, "§aAnfragen"));
            Inv.setItem(43, Utils.createItem(Material.REDSTONE, 1, 0, "§aAktive Freunde"));
            Inv.setItem(42, Utils.createItem(Material.BARRIER, 1, 0, "BLANK"));
            p.openInventory(Inv);
        }
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = null;
        if (e.getWhoClicked() instanceof Player)
            p = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lEnterhaken")) {


            e.setCancelled(true);
        }

    }
}