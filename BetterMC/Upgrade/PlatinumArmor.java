package net.mcreator.betterminecraft.item;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class PlatinumArmorItem extends ArmorItem {

	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(25, Map.of(ArmorType.BOOTS, 3, ArmorType.LEGGINGS, 6, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 3, ArmorType.BODY, 6), 9,
			DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("betterminecraft:platinum_armor_equip")), 1f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("betterminecraft:platinum_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("betterminecraft:platinum_armor")));

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("betterminecraft:textures/models/armor/platinumarmor_layer_1.png");
			}
		}, BetterminecraftModItems.PLATINUM_ARMOR_HELMET.get());

		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("betterminecraft:textures/models/armor/platinumarmor_layer_1.png");
			}
		}, BetterminecraftModItems.PLATINUM_ARMOR_CHESTPLATE.get());

		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("betterminecraft:textures/models/armor/platinumarmor_layer_2.png");
			}
		}, BetterminecraftModItems.PLATINUM_ARMOR_LEGGINGS.get());

		event.registerItem(new IClientItemExtensions() {

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("betterminecraft:textures/models/armor/platinumarmor_layer_1.png");
			}
		}, BetterminecraftModItems.PLATINUM_ARMOR_BOOTS.get());
	}

	private PlatinumArmorItem(ArmorType type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends PlatinumArmorItem {

		public Helmet(Item.Properties properties) {
			super(ArmorType.HELMET, properties);
		}

	}

	public static class Chestplate extends PlatinumArmorItem {

		public Chestplate(Item.Properties properties) {
			super(ArmorType.CHESTPLATE, properties);
		}

	}

	public static class Leggings extends PlatinumArmorItem {

		public Leggings(Item.Properties properties) {
			super(ArmorType.LEGGINGS, properties);
		}

	}

	public static class Boots extends PlatinumArmorItem {

		public Boots(Item.Properties properties) {
			super(ArmorType.BOOTS, properties);
		}

	}

}
