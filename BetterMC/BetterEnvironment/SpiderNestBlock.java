package net.mcreator.betterminecraft.block;

public class SpiderNestBlockBlock extends Block {
	public SpiderNestBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.COBWEB).strength(1f).pushReaction(PushReaction.DESTROY).instrument(NoteBlockInstrument.GUITAR));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, BlockEntity blockEntity, Entity breaker, ItemStack tool) {
		return Mth.randomBetweenInclusive(level.getRandom(), 30, 120);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		SpiderNestBlockBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
