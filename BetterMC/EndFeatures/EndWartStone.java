package net.mcreator.betterminecraft.block;

public class EndWartStoneBlock extends Block {
	public EndWartStoneBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WART_BLOCK).strength(3f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
