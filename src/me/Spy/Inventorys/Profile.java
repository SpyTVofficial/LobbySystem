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
                p.getItemInHand().getType().equals(Material.REDSTONE) &&
                p.getItemInHand().getItemMeta().getDisplayName().contains("§6§lProfil")) {
            Inventory Inv = Bukkit.createInventory(p, 54, "§bFreudne");
            for (int i = 0; i < Inv.getSize(); i++)
                Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            Inv.setItem(51, Utils.createItem(Material.EMERALD, 1, 0, "§aAnfragen"));
            Inv.setItem(52, Utils.createItem(Material.REDSTONE, 1, 0, "§aAktive Freunde"));
            Inv.setItem(53, Utils.createItem(Material.BARRIER, 1, 0, "BLANK"));
            Inv.setItem(40, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            if(p.isOp()) {
                p.openInventory(Inv);
            } else {
                p.sendMessage("§cDieses Feature ist noch in der Entwicklung!");
            }
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
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInventar schließen")) {
            p.getOpenInventory().close();
        }

    }
}