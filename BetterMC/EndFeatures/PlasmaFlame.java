package net.mcreator.betterminecraft.block;

public class PlasmaFlameBlock extends Block {
	public PlasmaFlameBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.extinguish")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.fire.ambient")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.resin.place")),
				() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.furnace.fire_crackle")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.resin_bricks.fall")))).instabreak().noCollission()
				.noOcclusion().isRedstoneConductor((bs, br, bp) -> false).replaceable());
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
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		PlasmaFlameEntityCollidesInTheBlockProcedure.execute(world, entity);
	}
}
