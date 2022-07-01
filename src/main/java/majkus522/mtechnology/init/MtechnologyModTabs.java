
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package majkus522.mtechnology.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MtechnologyModTabs {
	public static CreativeModeTab TAB_MATERIALS;
	public static CreativeModeTab TAB_MACHINES;

	public static void load() {
		TAB_MATERIALS = new CreativeModeTab("tabmaterials") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MtechnologyModItems.IRON_DUST.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_MACHINES = new CreativeModeTab("tabmachines") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MtechnologyModBlocks.STRUCTURE_FRAME.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
