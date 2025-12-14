package net.mcreator.betterminecraft.item;

public class GolemThroneSuitMusicDiscItem extends Item {
	public GolemThroneSuitMusicDiscItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(BetterminecraftMod.MODID, "golem_throne_suit_music_disc"))));
	}
}
