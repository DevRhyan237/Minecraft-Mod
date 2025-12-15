package net.mcreator.betterminecraft.item;

public class SapphireAmuletItem extends Item {
	public SapphireAmuletItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SapphireAmuletItemInInventoryTickProcedure.execute(entity);
	}
}
