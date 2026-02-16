package net.mcreator.betterminecraft.block;

public class DungeonSlabBlock extends SlabBlock {
	public DungeonSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_BRICKS).strength(2.5f, 8f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
