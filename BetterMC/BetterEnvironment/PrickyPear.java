package net.mcreator.betterminecraft.item;

public class PrickyPearFruitItem extends Item {
	public PrickyPearFruitItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(1.5f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		PrickyPearFruitPlayerFinishesUsingItemProcedure.execute(entity);
		return retval;
	}
}
