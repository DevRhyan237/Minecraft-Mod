package net.mcreator.betterminecraft.block;

public class SapphireblockBlock extends Block {
	public SapphireblockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.LODESTONE).strength(5f, 10f).requiresCorrectToolForDrops().friction(0.5f).instrument(NoteBlockInstrument.FLUTE));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			SapphireblockRedstoneOnProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
	}
}
