package majkus522.mtechnology;

import net.minecraft.world.level.block.Block;
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

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@mezz.jei.api.JeiPlugin
public class SuperSmelterJei implements IModPlugin 
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
		registration.addRecipeCategories(new SuperSmelterJeiCategory(jeiHelper.getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) 
	{
		registration.addRecipes(generateSuperSmelterRecipes(), SuperSmelterJeiCategory.Uid);
	}

	private List<SuperSmelterJeiCategory.SuperSmelterRecipeWrapper> generateSuperSmelterRecipes() 
	{
		List<SuperSmelterJeiCategory.SuperSmelterRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		for (Recipe recipe : SuperSmelter.getRecipes())
		{
			recipes.add(new SuperSmelterJeiCategory.SuperSmelterRecipeWrapper(
					new ArrayList<>(Arrays.asList(recipe.input)),
					new ArrayList<>(Arrays.asList(recipe.output))));
		}
		return recipes;
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) 
	{
		for (Block block : SuperSmelter.getComponents()) 
		{
			registration.addRecipeCatalyst(new ItemStack(block), SuperSmelterJeiCategory.Uid);
		}
	}

	public static class SuperSmelterJeiCategory implements IRecipeCategory<SuperSmelterJeiCategory.SuperSmelterRecipeWrapper>
	{
		private static ResourceLocation Uid = new ResourceLocation("mtechnology", "supersmeltersmeltingcategory");
		private static final int input1 = 0;
		private static final int input2 = 1;
		private static final int input3 = 2;
		private static final int output1 = 3;
		private final IDrawable background;

		public SuperSmelterJeiCategory(IGuiHelper guiHelper) 
		{
			background = guiHelper.createDrawable(new ResourceLocation("mtechnology", "textures/gui/super_smleter.png"), 0, 0, 130, 70);
		}

		@Override
		public ResourceLocation getUid() 
		{
			return Uid;
		}

		@Override
		public Class<? extends SuperSmelterRecipeWrapper> getRecipeClass() 
		{
			return SuperSmelterJeiCategory.SuperSmelterRecipeWrapper.class;
		}

		@Override
		public Component getTitle() 
		{
			return (Component) new TranslatableComponent("jei.mtechnology.super_smelter.title");
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
		public void setIngredients(SuperSmelterRecipeWrapper recipeWrapper, IIngredients iIngredients) 
		{
			iIngredients.setInputs(VanillaTypes.ITEM, recipeWrapper.getInput());
			iIngredients.setOutputs(VanillaTypes.ITEM, recipeWrapper.getOutput());
		}

		@Override
		public void setRecipe(IRecipeLayout iRecipeLayout, SuperSmelterRecipeWrapper recipeWrapper, IIngredients iIngredients)
		{
			IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
			stacks.init(input1, true, 5, 5);
			stacks.init(input2, true, 30, 5);
			stacks.init(input3, true, 60, 5);
			stacks.init(output1, false, 101, 26);

			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			stacks.set(input2, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
			stacks.set(input3, iIngredients.getInputs(VanillaTypes.ITEM).get(2));
			stacks.set(output1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
		}

		public static class SuperSmelterRecipeWrapper 
		{
			private List<ItemStack> input;
			private List<ItemStack> output;

			public SuperSmelterRecipeWrapper(List<ItemStack> input, List<ItemStack> output) 
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