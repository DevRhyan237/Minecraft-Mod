package net.mcreator.betterminecraft.item;

public class SapphiregemItem extends Item {
	public SapphiregemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.BLOCK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 60;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		return ar;
	}
}
