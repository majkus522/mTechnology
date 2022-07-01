
package majkus522.mtechnology;

import net.minecraft.world.item.ItemStack;

import majkus522.mtechnology.init.MtechnologyModItems;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MoldPressData
{
	public static List<Recipe> getRecipes()
	{
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD.get(), 1),
			new ItemStack(MtechnologyModItems.STEEL_PLATE.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD_PLATE.get(), 1)
		}, 120, "moldPlate"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD.get(), 1),
			new ItemStack(MtechnologyModItems.IRON_PLATE.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD_PLATE.get(), 1)
		}, 120, "moldPlate"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD.get(), 1),
			new ItemStack(MtechnologyModItems.STEEL_ROD.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD_ROD.get(), 1)
		}, 120, "moldRod"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD.get(), 1),
			new ItemStack(MtechnologyModItems.STRUCTURE_FRAME.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.MOLD_FRAME.get(), 1)
		}, 120, "moldFramed"));
		return recipes;
	}

	public static MachineModifire getModifire(int speedUpgrade, int energyUpgrade)
	{
		double speed;
		switch(speedUpgrade)
		{
			case 1:
				speed = 1.1;
				break;

			case 2:
				speed = 1.3;
				break;

			case 3:
				speed = 1.5;
				break;

			case 4:
				speed = 1.7;
				break;

			case 5:
				speed = 2;
				break;

			case 6:
				speed = 2.2;
				break;

			case 7:
				speed = 2.5;
				break;

			case 8:
				speed = 3;
				break;

			default:
				speed = 1;
				break;
		}

		double energy;
		switch(energyUpgrade)
		{
			case 1:
				energy = 0.9;
				break;

			case 2:
				energy = 0.8;
				break;

			case 3:
				energy = 0.7;
				break;

			case 4:
				energy = 0.6;
				break;

			case 5:
				energy = 0.5;
				break;

			case 6:
				energy = 0.4;
				break;

			case 7:
				energy = 0.3;
				break;

			case 8:
				energy = 0.2;
				break;

			default:
				energy = 0;
				break;
		}
		return new MachineModifire((float)energy, (float)speed);
	}

	public static List<ItemStack> getMolds()
	{
		return Arrays.asList(
			new ItemStack(MtechnologyModItems.MOLD_PLATE.get()),
			new ItemStack(MtechnologyModItems.MOLD_ROD.get()),
			new ItemStack(MtechnologyModItems.MOLD_FRAME.get())
		);
	}
}