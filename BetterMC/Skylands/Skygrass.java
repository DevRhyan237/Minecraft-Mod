package net.mcreator.betterminecraft.block;

public class SkygrassBlock extends Block {
	public SkygrassBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.ROOTED_DIRT).strength(1.5f, 2.5f).friction(0.55f).instrument(NoteBlockInstrument.HAT));
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
