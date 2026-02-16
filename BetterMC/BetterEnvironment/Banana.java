package net.mcreator.betterminecraft.item;

public class BananaItem extends Item {
	public BananaItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(3f).build()));
	}
}
