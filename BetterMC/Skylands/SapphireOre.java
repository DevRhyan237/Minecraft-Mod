package net.mcreator.betterminecraft.block;

public class SapphireBlock extends Block {
	public SapphireBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.ANCIENT_DEBRIS).strength(4f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
