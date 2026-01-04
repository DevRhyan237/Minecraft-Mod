package net.mcreator.betterminecraft.item;

public class PlatinumSwordItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 750, 2.5f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("betterminecraft:platinum_sword_repair_items")));

	public PlatinumSwordItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 5.5f, -1.75f, properties);
	}
}
