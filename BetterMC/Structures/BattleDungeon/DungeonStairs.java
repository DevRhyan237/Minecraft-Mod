package net.mcreator.betterminecraft.block;

public class DungeonStairsBlock extends StairBlock {
	public DungeonStairsBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.sound(SoundType.NETHER_BRICKS).strength(2.5f, 8f));
	}

	@Override
	public float getExplosionResistance() {
		return 8f;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
