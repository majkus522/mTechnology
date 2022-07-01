
package majkus522.mtechnology.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import majkus522.mtechnology.init.MtechnologyModTabs;

public class HardenedSteelIngotItem extends Item {
	public HardenedSteelIngotItem() {
		super(new Item.Properties().tab(MtechnologyModTabs.TAB_MATERIALS).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
