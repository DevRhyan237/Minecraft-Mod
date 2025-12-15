package net.mcreator.betterminecraft.block;

public class EndFungiStemBlock extends Block {
	public EndFungiStemBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_WOOD).strength(2.5f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
