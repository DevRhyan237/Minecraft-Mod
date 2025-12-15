package net.mcreator.betterminecraft.block;

public class EndGrassBlock extends FlowerBlock {
	public EndGrassBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.GLOWING, 100, properties.mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.MOSS).strength(2f, 4f).noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(Blocks.END_STONE) || groundState.is(BetterminecraftModBlocks.END_MOSS_BLOCK.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}
