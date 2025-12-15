package net.mcreator.betterminecraft.recipe.brewing;

@EventBusSubscriber
public class LevitationPotionCraftBrewingRecipe implements IBrewingRecipe {

	@SubscribeEvent
	public static void init(RegisterBrewingRecipesEvent event) {
		event.getBuilder().addRecipe(new LevitationPotionCraftBrewingRecipe());
	}

	@Override
	public boolean isInput(ItemStack input) {
		Item inputItem = input.getItem();
		return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION) && input.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.SLOW_FALLING);
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return Ingredient.of(BetterminecraftModItems.END_GRAVITITE_ITEM.get()).test(ingredient);
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if (isInput(input) && isIngredient(ingredient)) {
			return PotionContents.createItemStack(input.getItem(), BetterminecraftModPotions.LEVITATION_POTION);
		}
		return ItemStack.EMPTY;
	}

}
