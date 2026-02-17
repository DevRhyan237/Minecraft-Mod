package net.mcreator.betterminecraft.block;

public class RopeBlock extends EndRodBlock {
	public RopeBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.CANDLE).strength(0.5f).noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).replaceable().forceSolidOff());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
