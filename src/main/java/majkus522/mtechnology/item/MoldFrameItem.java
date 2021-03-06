
package majkus522.mtechnology.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import majkus522.mtechnology.init.MtechnologyModTabs;

public class MoldFrameItem extends Item {
	public MoldFrameItem() {
		super(new Item.Properties().tab(MtechnologyModTabs.TAB_MATERIALS).stacksTo(64).rarity(Rarity.COMMON));
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
