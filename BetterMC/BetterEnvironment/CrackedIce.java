package net.mcreator.betterminecraft.block;

public class CrackedIceBlock extends Block {
	public CrackedIceBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GLASS).strength(0.15f, 0.2f).requiresCorrectToolForDrops().friction(0.8f).speedFactor(1.5f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		CrackedIceEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
