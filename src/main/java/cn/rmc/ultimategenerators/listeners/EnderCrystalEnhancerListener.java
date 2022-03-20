package cn.rmc.ultimategenerators.listeners;

import cn.rmc.ultimategenerators.Utils;
import cn.rmc.ultimategenerators.lists.UGItems;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EnderCrystalEnhancerListener implements Listener {

    @EventHandler
    public void piaee(PlayerInteractAtEntityEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (e.getRightClicked() == null) {
            return;
        }
        if (e.getRightClicked() instanceof EnderCrystal) {
            EnderCrystal ec = (EnderCrystal) e.getRightClicked();

            Player p = e.getPlayer();
            if (SlimefunUtils.isItemSimilar(p.getInventory().getItemInMainHand(), UGItems.ENDER_CRYSTAL_ENHANCER, true)) {
                if (!ec.isShowingBottom() && (ec.getCustomName() == null || ec.getCustomName().equals(""))) {
                    p.getInventory().setItemInMainHand(Utils.decreaseItem(p.getInventory().getItemInMainHand(), 1));
                    ec.setCustomName(ChatColor.translateAlternateColorCodes('&', "&d&l强化末影水晶&r"));
                    ec.setCustomNameVisible(false);
                }
            }
        }
    }


}
