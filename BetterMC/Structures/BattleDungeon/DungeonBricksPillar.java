package net.mcreator.betterminecraft.block;

public class DungeonBricksPillarBlock extends Block {
	public DungeonBricksPillarBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_BRICKS).strength(2.5f, 8f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
