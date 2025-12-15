package net.mcreator.betterminecraft.block;

public class EndFungiWartBlock extends Block {
	public EndFungiWartBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SHROOMLIGHT).strength(1f, 10f).lightLevel(s -> 4));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
