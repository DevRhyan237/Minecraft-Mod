package net.mcreator.betterminecraft.item;

public class OrangeItem extends Item {
	public OrangeItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(3).saturationModifier(0.6f).build()));
	}
}
