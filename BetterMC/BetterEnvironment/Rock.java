package net.mcreator.betterminecraft.block;

public class RockBlock extends FallingBlock {
	public static final MapCodec<RockBlock> CODEC = simpleCodec(RockBlock::new);

	public MapCodec<RockBlock> codec() {
		return CODEC;
	}

	public RockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.POINTED_DRIPSTONE).strength(1f, 10f).requiresCorrectToolForDrops().noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
		return box(0, 0, 0, 16, 4, 16);
	}
}
