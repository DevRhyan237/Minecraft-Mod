package net.mcreator.betterminecraft.item;

public class PlatinumShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 750, 5f, 0, 12, TagKey.create(Registries.ITEM, ResourceLocation.parse("betterminecraft:platinum_shovel_repair_items")));

	public PlatinumShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -3f, properties);
	}
}
