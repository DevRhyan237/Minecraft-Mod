package net.mcreator.betterminecraft.block;

public class CrackedDungeonBricksBlock extends Block {
	public CrackedDungeonBricksBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHER_BRICKS).strength(2.5f, 8f).instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
