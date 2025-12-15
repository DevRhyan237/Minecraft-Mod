package net.mcreator.betterminecraft.block;

public class SeasonalSaplingBlock extends SaplingBlock {
	public static final TreeGrower TREE_GROWER = new TreeGrower("seasonal_sapling", 0.5f, Optional.of(getFeatureKey("betterminecraft:red_season_tree")), Optional.of(getFeatureKey("betterminecraft:red_season_tree")),
			Optional.of(getFeatureKey("betterminecraft:seasonal_bush_feature")), Optional.empty(), Optional.of(getFeatureKey("betterminecraft:yellow_season_tree")), Optional.of(getFeatureKey("betterminecraft:orange_season_tree")));

	public SeasonalSaplingBlock(BlockBehaviour.Properties properties) {
		super(TREE_GROWER, properties.mapColor(MapColor.PLANT).randomTicks().sound(SoundType.BIG_DRIPLEAF).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
		return groundState.is(Blocks.PODZOL);
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

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
		}, BetterminecraftModBlocks.SEASONAL_SAPLING.get());
	}
}
