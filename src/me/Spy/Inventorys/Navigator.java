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
import java.util.ArrayList;

public class Navigator implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                p.getItemInHand().getType().equals(Material.CHEST) &&
                p.getItemInHand().getItemMeta().getDisplayName().contains("§6§lGadgets")) {
            Inventory Inv = Bukkit.createInventory(p, 45, "");
            for (int i = 0; i < Inv.getSize(); i++)
                Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            Inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(37, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(43, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
            Inv.setItem(22, Utils.createItem(Material.IRON_PICKAXE, 1, 0, "§bCityBuild"));
            Inv.setItem(23, Utils.createItem(Material.GOLDEN_APPLE, 1, 0, "§6Spawn"));
            Inv.setItem(21, Utils.createItem(Material.IRON_SWORD, 1, 0, "§aSpysAndCrims"));
            Inv.setItem(40, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
            p.openInventory(Inv);
        }
    }
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = null;
        if (e.getWhoClicked() instanceof Player)
            p = (Player)e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lEnterhaken")) {


        e.setCancelled(true);
    }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInventar schließen")) {
            p.getOpenInventory().close();
        }

}}
