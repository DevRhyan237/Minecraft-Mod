package net.mcreator.betterminecraft.block;

public class YellowSeasonalLeavesBlock extends LeavesBlock {
	public YellowSeasonalLeavesBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.AZALEA_LEAVES).strength(0.2f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).isSuffocating((bs, br, bp) -> false).isViewBlocking((bs, br, bp) -> false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}
