package majkus522.mtechnology;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ExtensionMethods
{
	public static ItemStack getItemFromBlock(LevelAccessor world, BlockPos position, int slot)
	{
		AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
		BlockEntity _ent = world.getBlockEntity(position);
		if (_ent != null)
			_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
					.ifPresent(capability -> _retval.set(capability.getStackInSlot(slot).copy()));
		return _retval.get();
	}

	public static void setItemForBlock(LevelAccessor world, BlockPos position, int slot, ItemStack item)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
			if (position != null) {
				final ItemStack _setstack = item;
				blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(slot, _setstack);
				});
			}
	}

	public static void setItemForBlock(LevelAccessor world, BlockPos position, int slot, ItemStack item, int amount)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (position != null) 
		{
			item.setCount(amount);
			blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> 
			{
				if (capability instanceof IItemHandlerModifiable)
					((IItemHandlerModifiable) capability).setStackInSlot(slot, item);
			});
		}
	}

	public static int getCountFromBlock(LevelAccessor world, BlockPos position, int slot)
	{
		AtomicInteger _retval = new AtomicInteger(0);
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (blockEntity != null)
			blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
					.ifPresent(capability -> _retval.set(capability.getStackInSlot(slot).getCount()));
		return _retval.get();
	}

	public static void incrementCountForBlock(LevelAccessor world, BlockPos position, int slot, int amount)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (blockEntity != null)
		{
			blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability ->
			{
				if (capability instanceof IItemHandlerModifiable)
				{
					ItemStack itemStack = capability.getStackInSlot(slot).copy();
					itemStack.shrink(-amount);
					((IItemHandlerModifiable) capability).setStackInSlot(slot, itemStack);
				}
			});
		}
	}

	public static float getNumberNbt(LevelAccessor world, BlockPos position, String tag)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (blockEntity != null)
			return (float)blockEntity.getTileData().getDouble(tag);
		return -1;
	}

	public static void setNumberNbt(LevelAccessor world, BlockPos position, String tag, float value)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		BlockState blockState = world.getBlockState(position);
		if (blockEntity != null)
			blockEntity.getTileData().putDouble(tag, value);
		if (world instanceof Level level)
			level.sendBlockUpdated(position, blockState, blockState, 3);
	}

	public static void incrementNbt(LevelAccessor world, BlockPos position, String tag, float value)
	{
		setNumberNbt(world, position, tag, getNumberNbt(world, position, tag) + value);
	}

	public static boolean getLogicNbt(LevelAccessor world, BlockPos position, String tag)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (blockEntity != null)
			return blockEntity.getTileData().getBoolean(tag);
		return false;
	}

	public static void setLogicNbt(LevelAccessor world, BlockPos position, String tag, boolean value)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		BlockState blockState = world.getBlockState(position);
		if (blockEntity != null)
			blockEntity.getTileData().putBoolean(tag, value);
		if (world instanceof Level level)
			level.sendBlockUpdated(position, blockState, blockState, 3);
	}

	public static String getStringNbt(LevelAccessor world, BlockPos position, String tag)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (blockEntity != null)
			return blockEntity.getTileData().getString(tag);
		return "";
	}

	public static void setStringNbt(LevelAccessor world, BlockPos position, String tag, String value)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		BlockState blockState = world.getBlockState(position);
		if (blockEntity != null)
			blockEntity.getTileData().putString(tag, value);
		if (world instanceof Level level)
			level.sendBlockUpdated(position, blockState, blockState, 3);
	}

	public static void appendNbt(LevelAccessor world, BlockPos position, String tag, String value)
	{
		setStringNbt(world, position, tag, getStringNbt(world, position, tag) + value);
	}

	public static int getEnergy(LevelAccessor level, BlockPos position) 
	{
		AtomicInteger _retval = new AtomicInteger(0);
		BlockEntity _ent = level.getBlockEntity(position);
		if (_ent != null)
			_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
		return _retval.get();
	}

	public static void extractEnergy(LevelAccessor world, BlockPos position, int energy)
	{
		BlockEntity blockEntity = world.getBlockEntity(position);
		if (blockEntity != null)
			blockEntity.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(energy, false));
	}
}