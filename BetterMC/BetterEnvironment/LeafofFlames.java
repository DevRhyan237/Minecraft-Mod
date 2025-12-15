package net.mcreator.betterminecraft.block;

public class LeafofFlamesBlock extends SugarCaneBlock {
	public LeafofFlamesBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.FIRE).randomTicks()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.cave_vines.break")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.weeping_vines.step")),
						() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.weeping_vines.place")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.wart_block.hit")),
						() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.wart_block.fall"))))
				.instabreak().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().pushReaction(PushReaction.DESTROY));
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return groundState.is(this) || groundState.is(Blocks.NETHERRACK) || groundState.is(Blocks.CRIMSON_NYLIUM);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		if (world.isEmptyBlock(pos.above())) {
			int i = 1;
			for (; world.getBlockState(pos.below(i)).is(this); ++i);
			if (i < 10) {
				int j = blockstate.getValue(AGE);
				if (CommonHooks.canCropGrow(world, pos, blockstate, true)) {
					if (j == 15) {
						world.setBlockAndUpdate(pos.above(), defaultBlockState());
						CommonHooks.fireCropGrowPost(world, pos.above(), defaultBlockState());
						world.setBlock(pos, blockstate.setValue(AGE, 0), 4);
					} else {
						world.setBlock(pos, blockstate.setValue(AGE, j + 1), 4);
					}
				}
			}
		}
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		LeafofFlamesNeighbourBlockChangesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LeafofFlamesMobplayerCollidesWithPlantProcedure.execute(entity);
	}
}
