package net.mcreator.betterminecraft.block;

public class EndFungiBlock extends Block {
	public EndFungiBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.soul_soil.break")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.sculk_catalyst.bloom")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.soul_soil.place")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.soul_sand.hit")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.soul_soil.fall")))).strength(2.5f, 7.5f));
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
