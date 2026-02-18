package net.mcreator.betterminecraft.block;

public class Palm_wood_packPlanksBlock extends Block {
	public Palm_wood_packPlanksBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(2f, 3f).ignitedByLava().instrument(NoteBlockInstrument.BASS));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
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
