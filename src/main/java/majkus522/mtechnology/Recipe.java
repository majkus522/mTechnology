package majkus522.mtechnology;

import net.minecraft.world.item.ItemStack;

public class Recipe 
{
	public int time;
	public String name;
	public ItemStack[] input;
	public ItemStack[] output;

	public Recipe(ItemStack[] input, ItemStack[] output, int time, String name) 
	{
		this.time = time;
		this.input = input;
		this.output = output;
		this.name = name;
	}
}