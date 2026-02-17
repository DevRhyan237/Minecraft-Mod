package net.mcreator.betterminecraft.item;

public class PlatinumHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 5f, 0, 12, TagKey.create(Registries.ITEM, ResourceLocation.parse("betterminecraft:platinum_hoe_repair_items")));

	public PlatinumHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -3f, properties);
	}
}
