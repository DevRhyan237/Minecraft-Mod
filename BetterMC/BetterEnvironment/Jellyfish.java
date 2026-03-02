package net.mcreator.betterminecraft.entity;

public class JellyfishEntity extends PathfinderMob {

	public final AnimationState animationState0 = new AnimationState();

	public JellyfishEntity(EntityType<JellyfishEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);

		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (JellyfishEntity.this.isInWater())
					JellyfishEntity.this.setDeltaMovement(JellyfishEntity.this.getDeltaMovement().add(0, 0.005, 0));

				if (this.operation == MoveControl.Operation.MOVE_TO && !JellyfishEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - JellyfishEntity.this.getX();
					double dy = this.wantedY - JellyfishEntity.this.getY();
					double dz = this.wantedZ - JellyfishEntity.this.getZ();

					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * JellyfishEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

					JellyfishEntity.this.setYRot(this.rotlerp(JellyfishEntity.this.getYRot(), f, 10));
					JellyfishEntity.this.yBodyRot = JellyfishEntity.this.getYRot();
					JellyfishEntity.this.yHeadRot = JellyfishEntity.this.getYRot();

					if (JellyfishEntity.this.isInWater()) {
						JellyfishEntity.this.setSpeed((float) JellyfishEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						JellyfishEntity.this.setXRot(this.rotlerp(JellyfishEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(JellyfishEntity.this.getXRot() * (float) (Math.PI / 180.0));

						JellyfishEntity.this.setZza(f3 * f1);
						JellyfishEntity.this.setYya((float) (f1 * dy));
					} else {
						JellyfishEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					JellyfishEntity.this.setSpeed(0);
					JellyfishEntity.this.setYya(0);
					JellyfishEntity.this.setZza(0);
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

		this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 40));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.2));

	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.glow_squid.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.squid.ambient")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.squid.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.squid.death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
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
	public void baseTick() {
		super.baseTick();
		JellyfishOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
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
		event.register(BetterminecraftModEntities.JELLYFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0.3);

		return builder;
	}

}
