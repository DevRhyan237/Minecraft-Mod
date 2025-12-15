package net.mcreator.betterminecraft.block;

public class LeafLitterBlockBlock extends FallingBlock {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	public static final MapCodec<LeafLitterBlockBlock> CODEC = simpleCodec(LeafLitterBlockBlock::new);

	public MapCodec<LeafLitterBlockBlock> codec() {
		return CODEC;
	}

	public LeafLitterBlockBlock(BlockBehaviour.Properties properties) {
		super(properties
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:leaf_litter_step")),
						() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:leaf_litter_step")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:leaf_litter_extrasounds")),
						() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:leaf_litter_step")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:leaf_litter_extrasounds"))))
				.strength(0.5f, 10f).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
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
		return switch (state.getValue(FACING)) {
			default -> box(0, 0, 0, 16, 1, 16);
			case NORTH -> box(0, 0, 0, 16, 1, 16);
			case EAST -> box(0, 0, 0, 16, 1, 16);
			case WEST -> box(0, 0, 0, 16, 1, 16);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		LeafLitterBlockOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
