package net.mcreator.betterminecraft.item;

public class PiratediscItem extends Item {
	public PiratediscItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(BetterminecraftMod.MODID, "piratedisc"))));
	}
}
