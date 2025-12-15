package net.mcreator.betterminecraft.block;

public class EndeEyefungiBlock extends SaplingBlock {
	public static final TreeGrower TREE_GROWER = new TreeGrower("ende_eyefungi", Optional.empty(), Optional.of(getFeatureKey("betterminecraft:end_void_tree")), Optional.empty());

	public EndeEyefungiBlock(BlockBehaviour.Properties properties) {
		super(TREE_GROWER, properties.mapColor(MapColor.PLANT).randomTicks().sound(SoundType.GRASS).instabreak().lightLevel(s -> 5).noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
		return groundState.is(BetterminecraftModBlocks.END_FUNGI.get()) || groundState.is(BetterminecraftModBlocks.END_WART_STONE.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> getFeatureKey(String feature) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse(feature));
	}
}
