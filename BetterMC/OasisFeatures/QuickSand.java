package net.mcreator.betterminecraft.block;

public class QuicksandBlock extends FallingBlock {
	public static final MapCodec<QuicksandBlock> CODEC = simpleCodec(QuicksandBlock::new);

	public MapCodec<QuicksandBlock> codec() {
		return CODEC;
	}

	public QuicksandBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SUSPICIOUS_SAND).strength(1f).friction(0.55f).speedFactor(0.35f).jumpFactor(0.2f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
