package net.mcreator.betterminecraft.block;

public class BlessedwaterBlock extends LiquidBlock {
	public BlessedwaterBlock(BlockBehaviour.Properties properties) {
		super(BetterminecraftModFluids.BLESSEDWATER.get(), properties.mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		BlessedwaterMobplayerCollidesBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
