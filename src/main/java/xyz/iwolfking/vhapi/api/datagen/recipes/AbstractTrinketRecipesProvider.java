package xyz.iwolfking.vhapi.api.datagen.recipes;

import iskallia.vault.config.entry.recipe.ConfigTrinketRecipe;
import iskallia.vault.config.recipe.TrinketRecipesConfig;
import iskallia.vault.gear.trinket.TrinketEffect;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import xyz.iwolfking.vhapi.api.datagen.AbstractVaultConfigDataProvider;
import xyz.iwolfking.vhapi.api.datagen.lib.recipes.AbstractVaultRecipeBuilder;

import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractTrinketRecipesProvider extends AbstractVaultConfigDataProvider<AbstractTrinketRecipesProvider.Builder> {

    protected AbstractTrinketRecipesProvider(DataGenerator generator, String modid) {
        super(generator, modid, "vault_recipes/trinket", Builder::new);
    }

    @Override
    public String getName() {
        return modid + " Trinket Recipes Data Provider";
    }

    public static class Builder extends AbstractVaultRecipeBuilder<TrinketRecipesConfig, ConfigTrinketRecipe> {

        public Builder() {
            super(TrinketRecipesConfig::new);
        }

        public Builder addRecipe(ResourceLocation id, TrinketEffect<?> effect, Consumer<List<ItemStack>> inputs) {
            ConfigTrinketRecipe recipe = new ConfigTrinketRecipe(effect);
            addAndConfigureRecipe(recipe, inputs, id);
            return this;
        }

        @Override
        public void configureConfig(TrinketRecipesConfig config) {
            config.getConfigRecipes().addAll(recipes);
        }

    }
}
