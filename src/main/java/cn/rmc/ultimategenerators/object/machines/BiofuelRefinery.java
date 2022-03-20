package cn.rmc.ultimategenerators.object.machines;

import cn.rmc.ultimategenerators.lists.UGItems;
import cn.rmc.ultimategenerators.object.abstracts.BContainer;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BiofuelRefinery extends BContainer {
    protected BiofuelRefinery(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SLIME_BALL);
    }


    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(40, new ItemStack[]{UGItems.BIOMASS_BUCKET}, new ItemStack[]{UGItems.BIOFUEL_BUCKET});
    }

}
