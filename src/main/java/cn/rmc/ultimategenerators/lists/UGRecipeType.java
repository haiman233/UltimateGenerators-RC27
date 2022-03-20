package cn.rmc.ultimategenerators.lists;


import cn.rmc.ultimategenerators.UltimateGenerators;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class UGRecipeType {

    public static RecipeType NULL = new RecipeType(new NamespacedKey(UltimateGenerators.getImplement(),"NULL"),new CustomItemStack(Material.BARREL, "&c不可合成&r"));

    public UGRecipeType() {
    }

}
