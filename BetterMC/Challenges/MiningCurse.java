package net.mcreator.betterminecraft.potion;

public class MiningCurseMobEffect extends InstantenousMobEffect {
	public MiningCurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ambient.cave")));
		this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath(BetterminecraftMod.MODID, "effect.mining_curse_0"), 10, AttributeModifier.Operation.ADD_VALUE);
	}
}
