package net.mcreator.betterminecraft.block;

public class GlowingFungiBlock extends Block {
	public GlowingFungiBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NYLIUM).strength(2.25f, 5f).lightLevel(s -> 3).requiresCorrectToolForDrops().friction(0.75f));
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
