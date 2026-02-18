package net.mcreator.betterminecraft.block;

public class Palm_wood_packPressurePlateBlock extends PressurePlateBlock {
	public Palm_wood_packPressurePlateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, properties.sound(SoundType.CHERRY_WOOD).strength(0.5f).noCollission().pushReaction(PushReaction.DESTROY).ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
