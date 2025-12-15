package net.mcreator.betterminecraft.block;

public class PalmTreeSaplingBlock extends SaplingBlock {
	public static final TreeGrower TREE_GROWER = new TreeGrower("palm_tree_sapling", Optional.empty(), Optional.of(getFeatureKey("betterminecraft:oasispalmplacement")), Optional.empty());

	public PalmTreeSaplingBlock(BlockBehaviour.Properties properties) {
		super(TREE_GROWER, properties.mapColor(MapColor.PLANT).randomTicks().sound(SoundType.VINE).instabreak().noCollission().pushReaction(PushReaction.DESTROY));
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
		return groundState.is(Blocks.SAND) || groundState.is(Blocks.RED_SAND) || groundState.is(Blocks.TERRACOTTA) || groundState.is(Blocks.GRASS_BLOCK);
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
