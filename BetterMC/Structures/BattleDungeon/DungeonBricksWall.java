package net.mcreator.betterminecraft.block;

public class DungeonBricksWallBlock extends WallBlock {
	public DungeonBricksWallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_BRICKS).strength(2.5f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
