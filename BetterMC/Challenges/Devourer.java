package net.mcreator.betterminecraft.entity;

public class DevourerEntity extends Monster implements RangedAttackMob {

	public final AnimationState animationState0 = new AnimationState();

	public DevourerEntity(EntityType<DevourerEntity> type, Level world) {
		super(type, world);
		xpReward = 15;
		setNoAi(false);

		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (DevourerEntity.this.isInWater())
					DevourerEntity.this.setDeltaMovement(DevourerEntity.this.getDeltaMovement().add(0, 0.005, 0));

				if (this.operation == MoveControl.Operation.MOVE_TO && !DevourerEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - DevourerEntity.this.getX();
					double dy = this.wantedY - DevourerEntity.this.getY();
					double dz = this.wantedZ - DevourerEntity.this.getZ();

					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * DevourerEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

					DevourerEntity.this.setYRot(this.rotlerp(DevourerEntity.this.getYRot(), f, 10));
					DevourerEntity.this.yBodyRot = DevourerEntity.this.getYRot();
					DevourerEntity.this.yHeadRot = DevourerEntity.this.getYRot();

					if (DevourerEntity.this.isInWater()) {
						DevourerEntity.this.setSpeed((float) DevourerEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						DevourerEntity.this.setXRot(this.rotlerp(DevourerEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(DevourerEntity.this.getXRot() * (float) (Math.PI / 180.0));

						DevourerEntity.this.setZza(f3 * f1);
						DevourerEntity.this.setYya((float) (f1 * dy));
					} else {
						DevourerEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					DevourerEntity.this.setSpeed(0);
					DevourerEntity.this.setYya(0);
					DevourerEntity.this.setZza(0);
				}
			}
		};

		refreshDimensions();
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.5, 40));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, true));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 2.5, true) {

			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

		});
		this.goalSelector.addGoal(4, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.5));
		this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
		this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 60, 30f) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.INK_SAC));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:devourer_swims"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.skeleton_horse.swim")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("enchant.thorns.hit"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.elder_guardian.death_land"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		DevourerEntityIsHurtProcedure.execute(world, sourceentity);
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
	public void performRangedAttack(LivingEntity target, float flval) {
		DevourerInkEntity.shoot(this, target);
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

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(2.75f);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(BetterminecraftModEntities.DEVOURER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.8);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.75);

		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.25);

		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0.8);

		return builder;
	}

}
