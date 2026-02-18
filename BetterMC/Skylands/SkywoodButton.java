package net.mcreator.betterminecraft.block;

public class SkywoodpackButtonBlock extends ButtonBlock {
	public SkywoodpackButtonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, 30, properties.sound(SoundType.CHERRY_WOOD).strength(0.5f).noCollission().pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
