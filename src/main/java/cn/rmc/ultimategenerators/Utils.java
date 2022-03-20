package cn.rmc.ultimategenerators;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Random;


public class Utils {

    public static ItemStack decreaseItem(ItemStack item, int amount) {
        ItemStack clone = item.clone();
        if (amount < clone.getAmount()) {
            clone.setAmount(clone.getAmount() - amount);
            return clone;
        } else {
            return null;
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static final String db64s(final String base64) {
        return new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_8);
    }

    public static ItemStack[] buildRecipe(ItemStack... itemStacks) {

        if (itemStacks.length == 9) {
            return itemStacks;
        }

        ItemStack[] itArr = new ItemStack[]{null, null, null, null, null, null, null, null, null};
        if (itemStacks.length <= 0) {
            return itArr;
        }
        if (itemStacks.length > 9) {
            return itArr;
        }
        System.arraycopy(itemStacks, 0, itArr, 0, itemStacks.length);
        return itArr;
    }


    public static void setMetadata(Metadatable object, String key, Object value, Plugin plugin) {
        object.setMetadata(key, new FixedMetadataValue(plugin, value));
    }

    public static Object getMetadata(Metadatable object, String key, Plugin plugin) {
        List<MetadataValue> values = object.getMetadata(key);
        for (MetadataValue value : values) {
            if (value.getOwningPlugin() == plugin) {
                return value.value();
            }
        }
        return null;
    }

    public static Location locModify(Location orig, float xOffset, float yOffset, float zOffset) {
        return new Location(orig.getWorld(), orig.getX() + xOffset, orig.getY() + yOffset, orig.getZ() + zOffset);
    }

    public static void asyncDelay(Runnable r) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(UltimateGenerators.getImplement(), r);
    }

    public static int getRandomMetaExcept(int except) {

        Random rd = new Random();
        while (true) {
            int n = rd.nextInt(16);
            if (n != except) {
                return n;
            } else {
                rd.nextInt(16);
            }
        }

    }

}
