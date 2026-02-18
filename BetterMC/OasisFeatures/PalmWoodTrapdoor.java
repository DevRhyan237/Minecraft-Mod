package net.mcreator.betterminecraft.block;

public class Palm_wood_packTrapdoorBlock extends TrapDoorBlock {
	public Palm_wood_packTrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, properties.sound(SoundType.CHERRY_WOOD).strength(3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).ignitedByLava().instrument(NoteBlockInstrument.BASS));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
