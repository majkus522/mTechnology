package majkus522.mtechnology;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;

import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.IModPlugin;

import majkus522.mtechnology.init.MtechnologyModBlocks;
import mezz.jei.api.recipe.RecipeType;

@mezz.jei.api.JeiPlugin
public class JeiDescriptions implements IModPlugin 
{
	@Override
	public ResourceLocation getPluginUid() 
	{
		return new ResourceLocation("mtechnology", "default");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registry) 
	{
		IIngredientManager ingredientManager = registry.getIngredientManager();
		IIngredientType<ItemStack> itemType = ingredientManager.getIngredientType(ItemStack.class);
		
		registry.addIngredientInfo(new ItemStack(MtechnologyModBlocks.SUPER_SMELTER_CONTROLLER.get()), itemType, (Component) new TranslatableComponent("jei.mtechnology.super_smelter_controller"));
	}
}