package net.mcreator.betterminecraft.entity;

public class AncientNautilusEntity extends Animal {

	public final AnimationState animationState0 = new AnimationState();

	public AncientNautilusEntity(EntityType<AncientNautilusEntity> type, Level world) {
		super(type, world);
		xpReward = 5;
		setNoAi(false);

		setPersistenceRequired();

		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (AncientNautilusEntity.this.isInWater())
					AncientNautilusEntity.this.setDeltaMovement(AncientNautilusEntity.this.getDeltaMovement().add(0, 0.005, 0));

				if (this.operation == MoveControl.Operation.MOVE_TO && !AncientNautilusEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - AncientNautilusEntity.this.getX();
					double dy = this.wantedY - AncientNautilusEntity.this.getY();
					double dz = this.wantedZ - AncientNautilusEntity.this.getZ();

					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * AncientNautilusEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

					AncientNautilusEntity.this.setYRot(this.rotlerp(AncientNautilusEntity.this.getYRot(), f, 10));
					AncientNautilusEntity.this.yBodyRot = AncientNautilusEntity.this.getYRot();
					AncientNautilusEntity.this.yHeadRot = AncientNautilusEntity.this.getYRot();

					if (AncientNautilusEntity.this.isInWater()) {
						AncientNautilusEntity.this.setSpeed((float) AncientNautilusEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						AncientNautilusEntity.this.setXRot(this.rotlerp(AncientNautilusEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(AncientNautilusEntity.this.getXRot() * (float) (Math.PI / 180.0));

						AncientNautilusEntity.this.setZza(f3 * f1);
						AncientNautilusEntity.this.setYya((float) (f1 * dy));
					} else {
						AncientNautilusEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					AncientNautilusEntity.this.setSpeed(0);
					AncientNautilusEntity.this.setYya(0);
					AncientNautilusEntity.this.setZza(0);
				}
			}
		};

	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new BreedGoal(this, 1));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.8));
		this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1, 40));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1, Ingredient.of(Items.DRIED_KELP), false));
		this.goalSelector.addGoal(7, new TryFindWaterGoal(this));
		this.targetSelector.addGoal(8, new HurtByTargetGoal(this).setAlertOthers());

	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.NAUTILUS_SHELL));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:ancient_nautilus_idle"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.bubble_column.bubble_pop")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:ancient_nautilus_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:ancient_nautilus_death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		if (damagesource.getDirectEntity() instanceof AbstractThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud || damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(true, this.tickCount);
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		AncientNautilusEntity retval = BetterminecraftModEntities.ANCIENT_NAUTILUS.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Items.DRIED_KELP).test(stack);
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(BetterminecraftModEntities.ANCIENT_NAUTILUS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getFluidState(pos.below()).is(FluidTags.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER) && pos.getY() >= (world.getSeaLevel() - 13) && pos.getY() <= world.getSeaLevel()),
				RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.75);

		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.5);

		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0.35);

		builder = builder.add(Attributes.TEMPT_RANGE, 10);

		return builder;
	}

}
