package net.mcreator.betterminecraft.item.inventory;

@EventBusSubscriber
public class BackpackItemInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == BetterminecraftModItems.BACKPACK_ITEM.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof BackpackMenu)
				player.closeContainer();
		}
	}

	public BackpackItemInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 12);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != BetterminecraftModItems.BACKPACK_ITEM.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}
