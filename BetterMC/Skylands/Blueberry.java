package net.mcreator.betterminecraft.item;

public class BlueberryItem extends Item {
	public BlueberryItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build(), Consumables.defaultFood().consumeSeconds(0.5F).build()));
	}
}
