package net.mcreator.betterminecraft.block;

public class PlatinumBlockBlock extends Block {
	public PlatinumBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.netherite_block.break")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.metal.step")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:platinum_block_sound")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.netherite_block.hit")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.heavy_core.fall")))).strength(1f, 10f)
				.requiresCorrectToolForDrops().friction(0.8f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
