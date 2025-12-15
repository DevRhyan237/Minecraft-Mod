package net.mcreator.betterminecraft.item;

public class PalmCoconutItem extends Item {
	public PalmCoconutItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(3).saturationModifier(1.5f).build()));
	}
}
