
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package majkus522.mtechnology.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import majkus522.mtechnology.block.SuperSmelterControllerBlock;
import majkus522.mtechnology.block.StructureFrameBlock;
import majkus522.mtechnology.block.SteelBlockBlock;
import majkus522.mtechnology.block.SolarPanelBlock;
import majkus522.mtechnology.block.RawLeadBlockBlock;
import majkus522.mtechnology.block.MoldPressBlock;
import majkus522.mtechnology.block.MetalFormerBlock;
import majkus522.mtechnology.block.LeadOreBlock;
import majkus522.mtechnology.block.LeadBlockBlock;
import majkus522.mtechnology.block.HoloProjectedStructureFrameBlock;
import majkus522.mtechnology.block.HeaterBlock;
import majkus522.mtechnology.block.HeatTransporterBlock;
import majkus522.mtechnology.block.HardenedStructureFrameBlock;
import majkus522.mtechnology.block.ExtruderControllerBlock;
import majkus522.mtechnology.block.CrusherBlock;
import majkus522.mtechnology.block.CopperCoilBlockBlock;
import majkus522.mtechnology.block.CoolerBlock;
import majkus522.mtechnology.block.AlloySmelterBlock;
import majkus522.mtechnology.MtechnologyMod;

public class MtechnologyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MtechnologyMod.MODID);
	public static final RegistryObject<Block> STRUCTURE_FRAME = REGISTRY.register("structure_frame", () -> new StructureFrameBlock());
	public static final RegistryObject<Block> HEATER = REGISTRY.register("heater", () -> new HeaterBlock());
	public static final RegistryObject<Block> HEAT_TRANSPORTER = REGISTRY.register("heat_transporter", () -> new HeatTransporterBlock());
	public static final RegistryObject<Block> SUPER_SMELTER_CONTROLLER = REGISTRY.register("super_smelter_controller",
			() -> new SuperSmelterControllerBlock());
	public static final RegistryObject<Block> CRUSHER = REGISTRY.register("crusher", () -> new CrusherBlock());
	public static final RegistryObject<Block> ALLOY_SMELTER = REGISTRY.register("alloy_smelter", () -> new AlloySmelterBlock());
	public static final RegistryObject<Block> SOLAR_PANEL = REGISTRY.register("solar_panel", () -> new SolarPanelBlock());
	public static final RegistryObject<Block> STEEL_BLOCK = REGISTRY.register("steel_block", () -> new SteelBlockBlock());
	public static final RegistryObject<Block> COPPER_COIL_BLOCK = REGISTRY.register("copper_coil_block", () -> new CopperCoilBlockBlock());
	public static final RegistryObject<Block> HOLO_PROJECTED_STRUCTURE_FRAME = REGISTRY.register("holo_projected_structure_frame",
			() -> new HoloProjectedStructureFrameBlock());
	public static final RegistryObject<Block> MOLD_PRESS = REGISTRY.register("mold_press", () -> new MoldPressBlock());
	public static final RegistryObject<Block> METAL_FORMER = REGISTRY.register("metal_former", () -> new MetalFormerBlock());
	public static final RegistryObject<Block> LEAD_BLOCK = REGISTRY.register("lead_block", () -> new LeadBlockBlock());
	public static final RegistryObject<Block> LEAD_ORE = REGISTRY.register("lead_ore", () -> new LeadOreBlock());
	public static final RegistryObject<Block> RAW_LEAD_BLOCK = REGISTRY.register("raw_lead_block", () -> new RawLeadBlockBlock());
	public static final RegistryObject<Block> HARDENED_STRUCTURE_FRAME = REGISTRY.register("hardened_structure_frame",
			() -> new HardenedStructureFrameBlock());
	public static final RegistryObject<Block> COOLER = REGISTRY.register("cooler", () -> new CoolerBlock());
	public static final RegistryObject<Block> EXTRUDER_CONTROLLER = REGISTRY.register("extruder_controller", () -> new ExtruderControllerBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			StructureFrameBlock.registerRenderLayer();
			HeaterBlock.registerRenderLayer();
			HeatTransporterBlock.registerRenderLayer();
			HoloProjectedStructureFrameBlock.registerRenderLayer();
			HardenedStructureFrameBlock.registerRenderLayer();
			CoolerBlock.registerRenderLayer();
		}
	}
}
