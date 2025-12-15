package net.mcreator.betterminecraft.block;

public class EndMossBlockBlock extends Block {
	public EndMossBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NYLIUM).strength(3f, 20f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
