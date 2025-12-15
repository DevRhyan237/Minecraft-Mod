package net.mcreator.betterminecraft.block;

public class SilverOreBlock extends Block {
	public SilverOreBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.HEAVY_CORE).strength(4f, 3f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
