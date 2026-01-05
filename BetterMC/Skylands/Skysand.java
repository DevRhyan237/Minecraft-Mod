package net.mcreator.betterminecraft.block;

public class SkysandBlock extends Block {
	public SkysandBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SAND).strength(0.6f, 1f).friction(0.8f).speedFactor(1.25f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
