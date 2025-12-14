package net.mcreator.betterminecraft.block;

public class TopazOreBlock extends Block {
	public TopazOreBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GILDED_BLACKSTONE).strength(2.5f, 5f).instrument(NoteBlockInstrument.BASS));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
