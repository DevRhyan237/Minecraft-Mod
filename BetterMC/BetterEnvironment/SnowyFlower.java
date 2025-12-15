package net.mcreator.betterminecraft.block;

public class SnowyFlowerBlock extends FlowerBlock {
	public SnowyFlowerBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.INVISIBILITY, 100, properties.mapColor(MapColor.PLANT).sound(SoundType.CAVE_VINES).instabreak().lightLevel(s -> 5).noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
		return groundState.is(Blocks.PACKED_ICE) || groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.SNOW_BLOCK);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}
