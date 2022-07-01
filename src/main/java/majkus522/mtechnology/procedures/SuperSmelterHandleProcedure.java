package majkus522.mtechnology.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import majkus522.mtechnology.SuperSmelter;
import majkus522.mtechnology.Recipe;
import majkus522.mtechnology.MachineModifire;
import majkus522.mtechnology.ExtensionMethods;

import java.util.List;

public class SuperSmelterHandleProcedure
{
	public static void execute(LevelAccessor world, double x, double y, double z)
	{
		BlockPos position = new BlockPos(x, y, z);
		List<Recipe> recipes = SuperSmelter.getRecipes();
		MachineModifire modifire = SuperSmelter.getModifire(ExtensionMethods.getCountFromBlock(world, position, 4), ExtensionMethods.getCountFromBlock(world, position, 5));
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
						if(ExtensionMethods.getCountFromBlock(world, position, 9) == 0)
						{
							ExtensionMethods.setItemForBlock(world, position, 9, recipe.output[0]);
							ExtensionMethods.setLogicNbt(world, position, "processing", false);
						}
						else if(recipe.output[0].getCount() + ExtensionMethods.getCountFromBlock(world, position, 9) <= 64 &&
								recipe.output[0].getItem() == ExtensionMethods.getItemFromBlock(world, position, 9).getItem())
						{
							ExtensionMethods.setItemForBlock(world, position, 9, recipe.output[0], recipe.output[0].getCount() + ExtensionMethods.getCountFromBlock(world, position, 9));
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
				if(recipe.input.length == 1)
				{
					if(ExtensionMethods.getItemFromBlock(world, position, 0).getItem() == recipe.input[0].getItem() &&
						ExtensionMethods.getCountFromBlock(world, position, 0) >= recipe.input[0].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 0, -recipe.input[0].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 1).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 1) >= recipe.input[0].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 1, -recipe.input[0].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 2).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 2) >= recipe.input[0].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 2, -recipe.input[0].getCount());
						return;
					}
					else
					{
						System.out.println("fdgdfg");
					}
				}
				else if(recipe.input.length == 2)
				{
					if(ExtensionMethods.getItemFromBlock(world, position, 0).getItem() == recipe.input[0].getItem() &&
						ExtensionMethods.getCountFromBlock(world, position, 0) >= recipe.input[0].getCount() &&
						ExtensionMethods.getItemFromBlock(world, position, 1).getItem() == recipe.input[1].getItem() &&
						ExtensionMethods.getCountFromBlock(world, position, 1) >= recipe.input[1].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 0, -recipe.input[0].getCount());
						ExtensionMethods.incrementCountForBlock(world, position, 1, -recipe.input[1].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 0).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 0) >= recipe.input[0].getCount() &&
							ExtensionMethods.getItemFromBlock(world, position, 2).getItem() == recipe.input[1].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 2) >= recipe.input[1].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 0, -recipe.input[0].getCount());
						ExtensionMethods.incrementCountForBlock(world, position, 2, -recipe.input[1].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 1).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 1) >= recipe.input[0].getCount() &&
							ExtensionMethods.getItemFromBlock(world, position, 0).getItem() == recipe.input[1].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 0) >= recipe.input[1].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 1, -recipe.input[0].getCount());
						ExtensionMethods.incrementCountForBlock(world, position, 0, -recipe.input[1].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 1).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 1) >= recipe.input[0].getCount() &&
							ExtensionMethods.getItemFromBlock(world, position, 2).getItem() == recipe.input[1].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 2) >= recipe.input[1].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 1, -recipe.input[0].getCount());
						ExtensionMethods.incrementCountForBlock(world, position, 2, -recipe.input[1].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 2).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 2) >= recipe.input[0].getCount() &&
							ExtensionMethods.getItemFromBlock(world, position, 0).getItem() == recipe.input[1].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 0) >= recipe.input[1].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 2, -recipe.input[0].getCount());
						ExtensionMethods.incrementCountForBlock(world, position, 0, -recipe.input[1].getCount());
						return;
					}
					else if(ExtensionMethods.getItemFromBlock(world, position, 2).getItem() == recipe.input[0].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 2) >= recipe.input[0].getCount() &&
							ExtensionMethods.getItemFromBlock(world, position, 1).getItem() == recipe.input[1].getItem() &&
							ExtensionMethods.getCountFromBlock(world, position, 1) >= recipe.input[1].getCount())
					{
						ExtensionMethods.setLogicNbt(world, position, "processing", true);
						ExtensionMethods.setStringNbt(world, position, "input", recipe.name);
						ExtensionMethods.setNumberNbt(world, position, "timeLeft", recipe.time * modifire.speed * 20);
						ExtensionMethods.incrementCountForBlock(world, position, 2, -recipe.input[0].getCount());
						ExtensionMethods.incrementCountForBlock(world, position, 1, -recipe.input[1].getCount());
						return;
					}
					else
					{
						System.out.println("sagfasgsa");
					}
				}
				else
				{

				}
			}
		}
	}
}