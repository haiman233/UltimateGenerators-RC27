package cn.rmc.ultimategenerators.listeners;

import cn.rmc.ultimategenerators.lists.UGItems;
import io.github.thebusybiscuit.slimefun4.utils.FireworkUtils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

public class UltimateElectricityStorageCraftingListener implements Listener {

    @EventHandler
    public void ede(EntityDamageEvent e) {
        if (e.getCause().equals(DamageCause.LAVA)) {
            if (e.getEntity() instanceof Item) {
                Item ei = (Item) e.getEntity();
                ItemStack lambda8 = UGItems.LAMBDA_ELECTRICITY_STORAGE.clone();
                lambda8.setAmount(8);
                if (lambda8.equals(ei.getItemStack())) {
                    e.setCancelled(true);
                    Location el = removeVector(ei.getLocation());
                    el.setY(el.getY());
                    ei.remove();

                    el.getWorld().playSound(el, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1F, 1F);
                    Item dit = el.getWorld().dropItemNaturally(el, UGItems.KAPA_ELECTRICITY_STORAGE);
                    el.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, el, 3);
                    FireworkUtils.launchFirework(el, Color.BLACK);
                    FireworkUtils.launchFirework(el, Color.BLACK);
                    FireworkUtils.launchFirework(el, Color.GRAY);
                    FireworkUtils.launchFirework(el, Color.SILVER);
                    dit.setGlowing(true);
                    dit.setInvulnerable(true);
                    dit.setCustomNameVisible(true);
                    dit.setCustomName(dit.getItemStack().getItemMeta().getDisplayName());
                }
            }
        }
    }

    @EventHandler
    public void edep(EntityDamageEvent e) {
        if (e.getCause().equals(DamageCause.LIGHTNING)) {
            if (e.getEntity() instanceof Item) {
                Item ei = (Item) e.getEntity();
                ItemStack kapa8 = UGItems.KAPA_ELECTRICITY_STORAGE.clone();
                kapa8.setAmount(8);
                if (kapa8.equals(ei.getItemStack())) {
                    e.setCancelled(true);
                    Location el = removeVector(ei.getLocation());
                    el.setY(el.getY() + 1);
                    ei.remove();

                    el.getWorld().playSound(el, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1F, 1F);
                    Item dit = el.getWorld().dropItemNaturally(el, UGItems.PHI_ELECTRICITY_STORAGE);
                    el.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, el, 3);
                    FireworkUtils.launchFirework(el, Color.WHITE);
                    FireworkUtils.launchFirework(el, Color.WHITE);
                    FireworkUtils.launchFirework(el, Color.GRAY);
                    FireworkUtils.launchFirework(el, Color.SILVER);
                    dit.setGlowing(true);
                    dit.setInvulnerable(true);
                    dit.setCustomNameVisible(true);
                    dit.setCustomName(dit.getItemStack().getItemMeta().getDisplayName());
                }
            }
        }
    }

    private Location removeVector(Location l) {
        return new Location(l.getWorld(), l.getX(), l.getY(), l.getZ());
    }

}
