package cn.rmc.ultimategenerators.object.machines;

import cn.rmc.ultimategenerators.lists.UGItems;
import cn.rmc.ultimategenerators.object.abstracts.BContainer;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class OilRefinery extends BContainer {
    public OilRefinery(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }



    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(40, new ItemStack[]{SlimefunItems.OIL_BUCKET}, new ItemStack[]{UGItems.DIESEL_BUCKET});

    }
}
