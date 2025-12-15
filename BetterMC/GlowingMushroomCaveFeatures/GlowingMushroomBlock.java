package net.mcreator.betterminecraft.block;

public class GlowingMushroomBlockBlock extends Block {
	public GlowingMushroomBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.sculk_vein.break")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.nylium.step")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.nylium.place")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.sculk.hit")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.nylium.fall")))).strength(1f, 2f).lightLevel(s -> 3)
				.requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, BlockState plant) {
		return TriState.TRUE;
	}
}
