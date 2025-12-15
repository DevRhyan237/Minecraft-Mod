package net.mcreator.betterminecraft.block;

public class PalmPlanksBlock extends Block {
	public PalmPlanksBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.CHERRY_WOOD).strength(2f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
		PalmPlanksOnBlockHitByProjectileProcedure.execute(world, hit.getBlockPos().getX(), hit.getBlockPos().getY(), hit.getBlockPos().getZ(), hit.getDirection());
	}
}
