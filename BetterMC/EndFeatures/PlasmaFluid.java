package net.mcreator.betterminecraft.block;

public class PlasmaFluidBlock extends LiquidBlock {
	public PlasmaFluidBlock(BlockBehaviour.Properties properties) {
		super(BetterminecraftModFluids.PLASMA_FLUID.get(), properties.mapColor(MapColor.FIRE).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().noLootTable().liquid()
				.pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		PlasmaFluidMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}
