
package majkus522.mtechnology;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import majkus522.mtechnology.init.MtechnologyModItems;

import java.util.List;
import java.util.ArrayList;

public class CrusherData
{
	public static List<Recipe> getRecipes()
	{
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Items.COPPER_INGOT, 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.COPPER_DUST.get(), 1)
		}, 40, "copperIngot"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Items.RAW_COPPER, 2)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.COPPER_DUST.get(), 3)
		}, 40, "rawCopper"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Blocks.COPPER_ORE.asItem(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.COPPER_DUST.get(), 2)
		}, 40, "copperOre"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Blocks.DEEPSLATE_COPPER_ORE.asItem(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.COPPER_DUST.get(), 2)
		}, 40, "depCopperOre"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Items.IRON_INGOT, 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.IRON_DUST.get(), 1)
		}, 40, "ironIngot"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Items.RAW_IRON, 2)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.IRON_DUST.get(), 3)
		}, 40, "rawIron"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Blocks.IRON_ORE.asItem(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.IRON_DUST.get(), 2)
		}, 40, "ironOre"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Blocks.DEEPSLATE_IRON_ORE.asItem(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.IRON_DUST.get(), 2)
		}, 40, "depIronOre"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_ORE.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_DUST.get(), 2)
		}, 40, "leadOre"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_INGOT.get(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_DUST.get(), 1)
		}, 40, "leadIngot"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.RAW_LEAD.get(), 2)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.LEAD_DUST.get(), 3)
		}, 40, "rawLead"));

		recipes.add(new Recipe(new ItemStack[]
		{
			new ItemStack(Items.COAL.asItem(), 1)
		},
		new ItemStack[]
		{
			new ItemStack(MtechnologyModItems.COAL_DUST.get(), 1)
		}, 20, "coal"));
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
}