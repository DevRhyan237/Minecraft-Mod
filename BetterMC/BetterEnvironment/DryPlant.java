package net.mcreator.betterminecraft.block;

public class DryPlantBlock extends FlowerBlock {
	public DryPlantBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.MOVEMENT_SLOWDOWN, 100, properties.mapColor(MapColor.PLANT).sound(SoundType.HANGING_ROOTS).instabreak().noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(Blocks.SAND) || groundState.is(Blocks.RED_SAND) || groundState.is(Blocks.TERRACOTTA);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}
