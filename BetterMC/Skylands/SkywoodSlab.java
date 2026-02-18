package net.mcreator.betterminecraft.block;

public class SkywoodpackSlabBlock extends SlabBlock {
	public SkywoodpackSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.CHERRY_WOOD).strength(2f, 3f).ignitedByLava().instrument(NoteBlockInstrument.BASS));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 20;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
}
