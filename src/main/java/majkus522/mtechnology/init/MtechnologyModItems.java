
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package majkus522.mtechnology.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import majkus522.mtechnology.item.SteelRodItem;
import majkus522.mtechnology.item.SteelPlateItem;
import majkus522.mtechnology.item.SteelIngotItem;
import majkus522.mtechnology.item.RawLeadItem;
import majkus522.mtechnology.item.MoldRodItem;
import majkus522.mtechnology.item.MoldPlateItem;
import majkus522.mtechnology.item.MoldItem;
import majkus522.mtechnology.item.MoldFrameItem;
import majkus522.mtechnology.item.MetalCutterItem;
import majkus522.mtechnology.item.LeadIngotItem;
import majkus522.mtechnology.item.LeadDustItem;
import majkus522.mtechnology.item.IronPlateItem;
import majkus522.mtechnology.item.IronDustItem;
import majkus522.mtechnology.item.HeatConduitItem;
import majkus522.mtechnology.item.HeatCoilItem;
import majkus522.mtechnology.item.HardenedSteelRodItem;
import majkus522.mtechnology.item.HardenedSteelPlateItem;
import majkus522.mtechnology.item.HardenedSteelIngotItem;
import majkus522.mtechnology.item.HammerItem;
import majkus522.mtechnology.item.GrapheneNanotubeItem;
import majkus522.mtechnology.item.GrapheneItem;
import majkus522.mtechnology.item.CopperWireItem;
import majkus522.mtechnology.item.CopperDustItem;
import majkus522.mtechnology.item.CopperCoilItem;
import majkus522.mtechnology.item.CoolCoilItem;
import majkus522.mtechnology.item.CoalDustItem;
import majkus522.mtechnology.MtechnologyMod;

public class MtechnologyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MtechnologyMod.MODID);
	public static final RegistryObject<Item> STRUCTURE_FRAME = block(MtechnologyModBlocks.STRUCTURE_FRAME, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> HEATER = block(MtechnologyModBlocks.HEATER, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> HEAT_TRANSPORTER = block(MtechnologyModBlocks.HEAT_TRANSPORTER, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> SUPER_SMELTER_CONTROLLER = block(MtechnologyModBlocks.SUPER_SMELTER_CONTROLLER,
			MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> CRUSHER = block(MtechnologyModBlocks.CRUSHER, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> ALLOY_SMELTER = block(MtechnologyModBlocks.ALLOY_SMELTER, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> SOLAR_PANEL = block(MtechnologyModBlocks.SOLAR_PANEL, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> IRON_DUST = REGISTRY.register("iron_dust", () -> new IronDustItem());
	public static final RegistryObject<Item> IRON_PLATE = REGISTRY.register("iron_plate", () -> new IronPlateItem());
	public static final RegistryObject<Item> STEEL_INGOT = REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> STEEL_BLOCK = block(MtechnologyModBlocks.STEEL_BLOCK, MtechnologyModTabs.TAB_MATERIALS);
	public static final RegistryObject<Item> STEEL_PLATE = REGISTRY.register("steel_plate", () -> new SteelPlateItem());
	public static final RegistryObject<Item> STEEL_ROD = REGISTRY.register("steel_rod", () -> new SteelRodItem());
	public static final RegistryObject<Item> COPPER_DUST = REGISTRY.register("copper_dust", () -> new CopperDustItem());
	public static final RegistryObject<Item> COPPER_COIL = REGISTRY.register("copper_coil", () -> new CopperCoilItem());
	public static final RegistryObject<Item> COPPER_WIRE = REGISTRY.register("copper_wire", () -> new CopperWireItem());
	public static final RegistryObject<Item> HEAT_COIL = REGISTRY.register("heat_coil", () -> new HeatCoilItem());
	public static final RegistryObject<Item> HEAT_CONDUIT = REGISTRY.register("heat_conduit", () -> new HeatConduitItem());
	public static final RegistryObject<Item> COPPER_COIL_BLOCK = block(MtechnologyModBlocks.COPPER_COIL_BLOCK, MtechnologyModTabs.TAB_MATERIALS);
	public static final RegistryObject<Item> COAL_DUST = REGISTRY.register("coal_dust", () -> new CoalDustItem());
	public static final RegistryObject<Item> GRAPHENE = REGISTRY.register("graphene", () -> new GrapheneItem());
	public static final RegistryObject<Item> GRAPHENE_NANOTUBE = REGISTRY.register("graphene_nanotube", () -> new GrapheneNanotubeItem());
	public static final RegistryObject<Item> METAL_CUTTER = REGISTRY.register("metal_cutter", () -> new MetalCutterItem());
	public static final RegistryObject<Item> HOLO_PROJECTED_STRUCTURE_FRAME = block(MtechnologyModBlocks.HOLO_PROJECTED_STRUCTURE_FRAME, null);
	public static final RegistryObject<Item> MOLD = REGISTRY.register("mold", () -> new MoldItem());
	public static final RegistryObject<Item> MOLD_PLATE = REGISTRY.register("mold_plate", () -> new MoldPlateItem());
	public static final RegistryObject<Item> MOLD_ROD = REGISTRY.register("mold_rod", () -> new MoldRodItem());
	public static final RegistryObject<Item> MOLD_PRESS = block(MtechnologyModBlocks.MOLD_PRESS, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> MOLD_FRAME = REGISTRY.register("mold_frame", () -> new MoldFrameItem());
	public static final RegistryObject<Item> METAL_FORMER = block(MtechnologyModBlocks.METAL_FORMER, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> HAMMER = REGISTRY.register("hammer", () -> new HammerItem());
	public static final RegistryObject<Item> LEAD_INGOT = REGISTRY.register("lead_ingot", () -> new LeadIngotItem());
	public static final RegistryObject<Item> LEAD_DUST = REGISTRY.register("lead_dust", () -> new LeadDustItem());
	public static final RegistryObject<Item> LEAD_BLOCK = block(MtechnologyModBlocks.LEAD_BLOCK, MtechnologyModTabs.TAB_MATERIALS);
	public static final RegistryObject<Item> LEAD_ORE = block(MtechnologyModBlocks.LEAD_ORE, MtechnologyModTabs.TAB_MATERIALS);
	public static final RegistryObject<Item> RAW_LEAD = REGISTRY.register("raw_lead", () -> new RawLeadItem());
	public static final RegistryObject<Item> RAW_LEAD_BLOCK = block(MtechnologyModBlocks.RAW_LEAD_BLOCK, MtechnologyModTabs.TAB_MATERIALS);
	public static final RegistryObject<Item> HARDENED_STEEL_INGOT = REGISTRY.register("hardened_steel_ingot", () -> new HardenedSteelIngotItem());
	public static final RegistryObject<Item> HARDENED_STEEL_PLATE = REGISTRY.register("hardened_steel_plate", () -> new HardenedSteelPlateItem());
	public static final RegistryObject<Item> HARDENED_STEEL_ROD = REGISTRY.register("hardened_steel_rod", () -> new HardenedSteelRodItem());
	public static final RegistryObject<Item> HARDENED_STRUCTURE_FRAME = block(MtechnologyModBlocks.HARDENED_STRUCTURE_FRAME,
			MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> COOLER = block(MtechnologyModBlocks.COOLER, MtechnologyModTabs.TAB_MACHINES);
	public static final RegistryObject<Item> COOL_COIL = REGISTRY.register("cool_coil", () -> new CoolCoilItem());
	public static final RegistryObject<Item> EXTRUDER_CONTROLLER = block(MtechnologyModBlocks.EXTRUDER_CONTROLLER, MtechnologyModTabs.TAB_MACHINES);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
