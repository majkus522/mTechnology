package majkus522.mtechnology;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.IModPlugin;

import majkus522.mtechnology.init.MtechnologyModBlocks;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@mezz.jei.api.JeiPlugin
public class CrusherJei implements IModPlugin 
{
	public static IJeiHelpers jeiHelper;

	@Override
	public ResourceLocation getPluginUid() 
	{
		return new ResourceLocation("mtechnology", "default");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) 
	{
		jeiHelper = registration.getJeiHelpers();
		registration.addRecipeCategories(new CrusherJeiCategory(jeiHelper.getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) 
	{
		registration.addRecipes(generateCrusherRecipes(), CrusherJeiCategory.Uid);
	}

	private List<CrusherJeiCategory.CrusherRecipeWrapper> generateCrusherRecipes() 
	{
		List<CrusherJeiCategory.CrusherRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		for (Recipe recipe : CrusherData.getRecipes()) 
		{
			recipes.add(new CrusherJeiCategory.CrusherRecipeWrapper(
					new ArrayList<>(Arrays.asList(recipe.input)),
					new ArrayList<>(Arrays.asList(recipe.output))));
		}
		return recipes;
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) 
	{
		registration.addRecipeCatalyst(new ItemStack(MtechnologyModBlocks.CRUSHER.get()), CrusherJeiCategory.Uid);
	}

	public static class CrusherJeiCategory implements IRecipeCategory<CrusherJeiCategory.CrusherRecipeWrapper> 
	{
		private static ResourceLocation Uid = new ResourceLocation("mtechnology", "crushercategory");
		private static final int input1 = 0;
		private static final int output1 = 1;
		private final IDrawable background;

		public CrusherJeiCategory(IGuiHelper guiHelper) 
		{
			background = guiHelper.createDrawable(new ResourceLocation("mtechnology", "textures/gui/crusher_gui.png"), 0, 0, 176, 48);
		}

		@Override
		public ResourceLocation getUid() 
		{
			return Uid;
		}

		@Override
		public Class<? extends CrusherRecipeWrapper> getRecipeClass() 
		{
			return CrusherJeiCategory.CrusherRecipeWrapper.class;
		}

		@Override
		public Component getTitle() 
		{
			return (Component) new TranslatableComponent("jei.mtechnology.crusher.title");
		}

		@Override
		public IDrawable getBackground() 
		{
			return background;
		}

		@Override
		public IDrawable getIcon() 
		{
			return null;
		}

		@Override
		public void setIngredients(CrusherRecipeWrapper recipeWrapper, IIngredients iIngredients) 
		{
			iIngredients.setInputs(VanillaTypes.ITEM, recipeWrapper.getInput());
			iIngredients.setOutputs(VanillaTypes.ITEM, recipeWrapper.getOutput());
		}

		@Override
		public void setRecipe(IRecipeLayout iRecipeLayout, CrusherRecipeWrapper recipeWrapper, IIngredients iIngredients) 
		{
			IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
			stacks.init(input1, true, 51, 15);
			stacks.init(output1, false, 105, 15);

			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			stacks.set(output1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
		}

		public static class CrusherRecipeWrapper 
		{
			private List<ItemStack> input;
			private List<ItemStack> output;

			public CrusherRecipeWrapper(List<ItemStack> input, List<ItemStack> output) 
			{
				this.input = input;
				this.output = output;
			}

			public List<ItemStack> getInput() 
			{
				return input;
			}

			public List<ItemStack> getOutput() 
			{
				return output;
			}
		}
	}
}