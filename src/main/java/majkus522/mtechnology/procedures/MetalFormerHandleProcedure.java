package majkus522.mtechnology.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import majkus522.mtechnology.Recipe;
import majkus522.mtechnology.MachineModifire;
import majkus522.mtechnology.ExtensionMethods;
import majkus522.mtechnology.MetalFormerData;

import java.util.List;

public class MetalFormerHandleProcedure
{
	public static void execute(LevelAccessor world, double x, double y, double z)
	{
		BlockPos position = new BlockPos(x, y, z);
		List<Recipe> recipes = MetalFormerData.getRecipes();
		MachineModifire modifire = MetalFormerData.getModifire(ExtensionMethods.getCountFromBlock(world, position, 3), ExtensionMethods.getCountFromBlock(world, position, 4));
		if(ExtensionMethods.getLogicNbt(world, position, "processing"))
		{
			if(ExtensionMethods.getEnergy(world, position) >= modifire.energy &&
					ExtensionMethods.getNumberNbt(world, position, "timeLeft") > 0)
			{
				ExtensionMethods.incrementNbt(world, position, "timeLeft", -modifire.speed);
				ExtensionMethods.extractEnergy(world, position, (int)modifire.energy * 40);
			}
			else if(ExtensionMethods.getNumberNbt(world, position, "timeLeft") <= 0)
			{
				for(Recipe recipe : recipes)
				{
					if(recipe.name == ExtensionMethods.getStringNbt(world, position, "input"))
					{
						if(ExtensionMethods.getCountFromBlock(world, position, 2) == 0)
						{
							ExtensionMethods.setItemForBlock(world, position, 2, recipe.output[0]);
							ExtensionMethods.setLogicNbt(world, position, "processing", false);
						}
						else if(recipe.output[0].getCount() + ExtensionMethods.getCountFromBlock(world, position, 2) <= 1 &&
								recipe.output[0].getItem() == ExtensionMethods.getItemFromBlock(world, position, 2).getItem())
						{
							ExtensionMethods.setItemForBlock(world, position, 2, recipe.output[0], recipe.output[0].getCount() + ExtensionMethods.getCountFromBlock(world, position, 2));
							ExtensionMethods.setLogicNbt(world, position, "processing", false);
						}
						else
							return;
						break;
					}
				}
			}
		}
		else
		{
			for(Recipe recipe : recipes)
			{
				if(recipe.input[0].getItem() == ExtensionMethods.getItemFromBlock(world, position, 0).getItem() &&
					recipe.input[0].getCount() <= ExtensionMethods.getItemFromBlock(world, position, 0).getCount() &&
					recipe.input[1].getItem() == ExtensionMethods.getItemFromBlock(world, position, 1).getItem() &&
					recipe.input[1].getCount() <= ExtensionMethods.getItemFromBlock(world, position, 1).getCount())
				{
					ExtensionMethods.setLogicNbt(world, position, "processing", true);
					ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
					ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed);
					System.out.println(recipe.time * modifire.speed);
					ExtensionMethods.incrementCountForBlock(world, position, 0, -recipe.input[0].getCount());
					return;
				}
			}
		}
	}
}