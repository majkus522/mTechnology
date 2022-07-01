
package majkus522.mtechnology;

import org.checkerframework.checker.units.qual.h;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import majkus522.mtechnology.init.MtechnologyModItems;
import majkus522.mtechnology.init.MtechnologyModBlocks;
import majkus522.mtechnology.Recipe;
import majkus522.mtechnology.MachineModifire;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class SuperSmelter 
{
	public static Block[][][] getMultiblock() 
	{
		Block h = MtechnologyModBlocks.HEATER.get();
		Block t = MtechnologyModBlocks.HEAT_TRANSPORTER.get();
		Block c = MtechnologyModBlocks.SUPER_SMELTER_CONTROLLER.get();
		
		Block[][][] multiblock = 
		{
			{
				{ h, h, h },
				{ h, h, h },
				{ h, h, h }
			},
			{
				{ h, c, h },
				{ h, t, h },
				{ h, h, h }
			},
			{
				{ h, h, h },
				{ h, h, h },
				{ h, h, h }
			}
		};
		return multiblock;
	}

	public static List<Recipe> getRecipesSmelting()
	{
		List<Recipe> recipes = new ArrayList<Recipe>();

		return recipes;
	}

	public static List<Recipe> getRecipes()
	{
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.HARDENED_STEEL_ROD.get(), 4),
			new ItemStack(MtechnologyModItems.HARDENED_STEEL_PLATE.get(), 4),
			new ItemStack(MtechnologyModBlocks.STRUCTURE_FRAME.get(), 1),
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModBlocks.HARDENED_STRUCTURE_FRAME.get(), 1)
		}, 200, "hardenedStructureFrame"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.COPPER_DUST.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(Items.COPPER_INGOT, 1)
		}, 40, "copperDust"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.IRON_DUST.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(Items.IRON_INGOT, 1)
		}, 40, "ironDust"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_DUST.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_INGOT.get(), 1)
		}, 40, "leadDust"));
		return recipes;
	}

	public static Block[] getComponents()
	{
		List<Block> placeholder = new ArrayList<Block>();
		placeholder.add(MtechnologyModBlocks.SUPER_SMELTER_CONTROLLER.get());
		for(Block[][] list2 : getMultiblock())
			for(Block[] list : list2)
				for(Block block : list)
					if(!(placeholder.contains(block)))
						placeholder.add(block);
		return placeholder.toArray(new Block[0]);
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
}