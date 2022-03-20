package cn.rmc.ultimategenerators.lists;

import cn.rmc.ultimategenerators.UltimateGenerators;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class UGCategories {

//    public static ItemGroup SLIMEFUN_MACHINES = Categories.ELECTRICITY;
//    public static ItemGroup TECH_MISC = DefaultItemGroup;

    public static NestedItemGroup nestedItemGroup = new NestedItemGroup(new NamespacedKey(UltimateGenerators.getImplement(),"parent_category"),
            new CustomItemStack(SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTZhN2QyMTk1ZmY3Njc0YmJiMTJlMmY3NTc4YTJhNjNjNTRhOTgwZTY0NzQ0NDUwYWM2NjU2ZTA1YTc5MDQ5OSJ9fX0="),
            "&d终极发电机"));
    public static ItemGroup TECH_MISC = new SubItemGroup(new NamespacedKey(UltimateGenerators.getImplement(),"tech_misc"),
            nestedItemGroup,new CustomItemStack(Material.COMPARATOR, "&d终极发电机 &7- &7杂项&r"),4);
    public static ItemGroup MACHINES = new SubItemGroup(new NamespacedKey(UltimateGenerators.getImplement(),"machines"),
            nestedItemGroup,new CustomItemStack(Material.PAPER, "&d终极发电机 &7- &9机器&r"),4);
    public static ItemGroup ELECTRICITY_STORAGE = new SubItemGroup(
            new NamespacedKey(UltimateGenerators.getImplement(),"electricity_storage"),nestedItemGroup,
            new CustomItemStack(Material.LIGHT_GRAY_STAINED_GLASS, "&d终极发电机 &7- &e电力储存&r"),4);

    public static ItemGroup SINGLE_GENERATOR = new SubItemGroup(
            new NamespacedKey(UltimateGenerators.getImplement(),"single_generator"),nestedItemGroup,
            new CustomItemStack(Material.TRIPWIRE_HOOK,
            "&d终极发电机 &7- &b简易发电&r", "", "&a> 点击打开"), 4);
//    public static ItemGroup MODULAR_GENERATOR = new SubItemGroup(
//            new NamespacedKey(UltimateGenerators.getImplement(),"modular_generator"),nestedItemGroup,
//            new CustomItemStack(Material.BLACK_SHULKER_BOX, "&d终极发电机 &7- &c模块发电&r"), 5);

    public UGCategories() {
    }

}
