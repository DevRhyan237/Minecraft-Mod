package net.mcreator.betterminecraft.item;

public class HealingStaffItem extends Item {
	public HealingStaffItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).durability(100)
				.attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, -0.99, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.BLOCK;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		itemstack.hurtAndBreak(1, entity, LivingEntity.getSlotForHand(entity.getUsedItemHand()));
		HealingStaffLivingEntityIsHitWithItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}
}
