
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package majkus522.mtechnology.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import majkus522.mtechnology.block.entity.SuperSmelterControllerBlockEntity;
import majkus522.mtechnology.block.entity.SolarPanelBlockEntity;
import majkus522.mtechnology.block.entity.MoldPressBlockEntity;
import majkus522.mtechnology.block.entity.MetalFormerBlockEntity;
import majkus522.mtechnology.block.entity.ExtruderControllerBlockEntity;
import majkus522.mtechnology.block.entity.CrusherBlockEntity;
import majkus522.mtechnology.block.entity.AlloySmelterBlockEntity;
import majkus522.mtechnology.MtechnologyMod;

public class MtechnologyModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MtechnologyMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SUPER_SMELTER_CONTROLLER = register("super_smelter_controller",
			MtechnologyModBlocks.SUPER_SMELTER_CONTROLLER, SuperSmelterControllerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRUSHER = register("crusher", MtechnologyModBlocks.CRUSHER, CrusherBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ALLOY_SMELTER = register("alloy_smelter", MtechnologyModBlocks.ALLOY_SMELTER,
			AlloySmelterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOLAR_PANEL = register("solar_panel", MtechnologyModBlocks.SOLAR_PANEL,
			SolarPanelBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MOLD_PRESS = register("mold_press", MtechnologyModBlocks.MOLD_PRESS,
			MoldPressBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> METAL_FORMER = register("metal_former", MtechnologyModBlocks.METAL_FORMER,
			MetalFormerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRUDER_CONTROLLER = register("extruder_controller",
			MtechnologyModBlocks.EXTRUDER_CONTROLLER, ExtruderControllerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
