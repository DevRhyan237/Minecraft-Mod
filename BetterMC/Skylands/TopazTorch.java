package net.mcreator.betterminecraft.block;

public class TopazTorchBlock extends Block {
	public TopazTorchBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.BAMBOO).strength(0.1f, 0.25f).lightLevel(s -> 15).noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).offsetType(Block.OffsetType.XZ));
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(pos);
		return box(0, 0, 0, 12, 12, 12).move(offset.x, offset.y, offset.z);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		TopazTorchOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		TopazTorchBlockIsPlacedByProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
