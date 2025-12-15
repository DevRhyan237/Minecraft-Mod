package net.mcreator.betterminecraft.block;

public class WildPetalsBlock extends FlowerBlock {
	public WildPetalsBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.DAMAGE_BOOST, 100, properties.mapColor(MapColor.PLANT).sound(SoundType.PINK_PETALS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}
}
