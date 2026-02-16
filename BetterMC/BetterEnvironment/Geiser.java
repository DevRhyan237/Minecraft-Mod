package net.mcreator.betterminecraft.block;

public class GeiserBlockBlock extends Block {
	public GeiserBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHERRACK).strength(2.5f, 6.5f).instrument(NoteBlockInstrument.DIDGERIDOO));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.LAVA;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		GeiserBlockEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
