package net.mcreator.betterminecraft.block;

public class Palm_wood_packButtonBlock extends ButtonBlock {
	public Palm_wood_packButtonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, 30, properties.sound(SoundType.CHERRY_WOOD).strength(0.5f).noCollission().pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
