
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package majkus522.mtechnology.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import majkus522.mtechnology.client.gui.SuperSmelterGuiScreen;
import majkus522.mtechnology.client.gui.MoldPressGuiScreen;
import majkus522.mtechnology.client.gui.MetalFormerGuiScreen;
import majkus522.mtechnology.client.gui.ExtruderGuiScreen;
import majkus522.mtechnology.client.gui.CrusherGuiScreen;
import majkus522.mtechnology.client.gui.AlloySmelterGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MtechnologyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MtechnologyModMenus.SUPER_SMELTER_GUI, SuperSmelterGuiScreen::new);
			MenuScreens.register(MtechnologyModMenus.CRUSHER_GUI, CrusherGuiScreen::new);
			MenuScreens.register(MtechnologyModMenus.ALLOY_SMELTER_GUI, AlloySmelterGuiScreen::new);
			MenuScreens.register(MtechnologyModMenus.MOLD_PRESS_GUI, MoldPressGuiScreen::new);
			MenuScreens.register(MtechnologyModMenus.METAL_FORMER_GUI, MetalFormerGuiScreen::new);
			MenuScreens.register(MtechnologyModMenus.EXTRUDER_GUI, ExtruderGuiScreen::new);
		});
	}
}
