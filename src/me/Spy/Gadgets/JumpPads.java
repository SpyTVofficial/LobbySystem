package me.Spy.Gadgets;

import me.Spy.Inventorys.Gadgets;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class JumpPads implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(Gadgets.jp.contains(p)){
            if (p.getLocation().getBlock().getType() == Material.IRON_PLATE) {
                Vector v = p.getLocation().getDirection().multiply(3.0D).setY(1.0D);
                p.setVelocity(v);
                p.playSound(p.getLocation(), Sound.FIZZ, 3.0F, 2.0F);
            }
        }
    }

}
