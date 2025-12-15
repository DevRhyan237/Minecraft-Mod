package net.mcreator.betterminecraft.block;

public class OrangeBushBlock extends FlowerBlock {
	public OrangeBushBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.MOVEMENT_SPEED, 100, properties.mapColor(MapColor.PLANT).sound(SoundType.AZALEA).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
