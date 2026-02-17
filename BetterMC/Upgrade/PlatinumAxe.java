package net.mcreator.betterminecraft.item;

public class PlatinumAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 750, 5f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("betterminecraft:platinum_axe_repair_items")));

	public PlatinumAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -3f, properties);
	}
}
