
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package majkus522.mtechnology.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import majkus522.mtechnology.world.inventory.SuperSmelterGuiMenu;
import majkus522.mtechnology.world.inventory.MoldPressGuiMenu;
import majkus522.mtechnology.world.inventory.MetalFormerGuiMenu;
import majkus522.mtechnology.world.inventory.ExtruderGuiMenu;
import majkus522.mtechnology.world.inventory.CrusherGuiMenu;
import majkus522.mtechnology.world.inventory.AlloySmelterGuiMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MtechnologyModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<SuperSmelterGuiMenu> SUPER_SMELTER_GUI = register("super_smelter_gui",
			(id, inv, extraData) -> new SuperSmelterGuiMenu(id, inv, extraData));
	public static final MenuType<CrusherGuiMenu> CRUSHER_GUI = register("crusher_gui",
			(id, inv, extraData) -> new CrusherGuiMenu(id, inv, extraData));
	public static final MenuType<AlloySmelterGuiMenu> ALLOY_SMELTER_GUI = register("alloy_smelter_gui",
			(id, inv, extraData) -> new AlloySmelterGuiMenu(id, inv, extraData));
	public static final MenuType<MoldPressGuiMenu> MOLD_PRESS_GUI = register("mold_press_gui",
			(id, inv, extraData) -> new MoldPressGuiMenu(id, inv, extraData));
	public static final MenuType<MetalFormerGuiMenu> METAL_FORMER_GUI = register("metal_former_gui",
			(id, inv, extraData) -> new MetalFormerGuiMenu(id, inv, extraData));
	public static final MenuType<ExtruderGuiMenu> EXTRUDER_GUI = register("extruder_gui",
			(id, inv, extraData) -> new ExtruderGuiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
