package net.mcreator.betterminecraft.block;

public class SkyrrackBricksBlock extends Block {
	public SkyrrackBricksBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.DEEPSLATE_BRICKS).strength(2.5f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
