package net.mcreator.betterminecraft.entity;

public class GrizzlyBearEntity extends Animal {

	public GrizzlyBearEntity(EntityType<GrizzlyBearEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);

	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

		});
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 0.8));
		this.goalSelector.addGoal(3, new BreedGoal(this, 1));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(5, new TemptGoal(this, 1, Ingredient.of(Items.SALMON), false));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));

	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.SALMON));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.polar_bear.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.polar_bear.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.polar_bear.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.polar_bear.death"));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		GrizzlyBearEntity retval = BetterminecraftModEntities.GRIZZLY_BEAR.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Items.SALMON, Items.HONEYCOMB).test(stack);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(BetterminecraftModEntities.GRIZZLY_BEAR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(Attributes.TEMPT_RANGE, 10);

		return builder;
	}

}
