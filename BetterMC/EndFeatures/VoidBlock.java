package net.mcreator.betterminecraft.block;

public class VoidBlockBlock extends Block {
	public VoidBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SCULK_SHRIEKER).strength(3.5f, 20f).lightLevel(s -> 3).speedFactor(0.2f).jumpFactor(0.2f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		VoidBlockEntityWalksOnTheBlockProcedure.execute(world, entity);
	}
}
