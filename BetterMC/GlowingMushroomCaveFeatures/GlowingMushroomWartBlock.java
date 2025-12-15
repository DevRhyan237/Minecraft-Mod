package net.mcreator.betterminecraft.block;

public class GlowingMushroomWartBlockBlock extends Block {
	public GlowingMushroomWartBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.FUNGUS).strength(1.5f, 3.5f).lightLevel(s -> 5));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
