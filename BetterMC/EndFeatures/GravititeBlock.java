package net.mcreator.betterminecraft.block;

/* imports omitted */

public class GravititeBlockBlock extends FallingBlock {
	public static final MapCodec<GravititeBlockBlock> CODEC = simpleCodec(GravititeBlockBlock::new);

	public MapCodec<GravititeBlockBlock> codec() {
		return CODEC;
	}

	public GravititeBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.ANCIENT_DEBRIS).strength(10f, 30f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState blockstate, BlockGetter blockAccess, BlockPos pos, Direction direction) {
		return 15;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		GravititeBlockOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
