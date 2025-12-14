package net.mcreator.betterminecraft.entity;

public class PuffwindEntity extends PathfinderMob {

	public final AnimationState animationState0 = new AnimationState();

	public PuffwindEntity(EntityType<PuffwindEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);

		setPersistenceRequired();

		this.moveControl = new FlyingMoveControl(this, 10, true);

	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8, 20) {

			@Override
			protected Vec3 getPosition() {
				RandomSource random = PuffwindEntity.this.getRandom();
				double dir_x = PuffwindEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = PuffwindEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = PuffwindEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

		});
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(3, new BreathAirGoal(this));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1, Ingredient.of(BetterminecraftModBlocks.CLOUD_BLOCK.get().asItem()), false));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 6));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float f) {
		return super.getPassengerAttachmentPoint(entity, dimensions, f).add(0, -0.2f, 0);
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.SNOWBALL));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:puffwind_idle"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.breeze.whirl")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:puffwind_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:puffwinf_death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {

		return false;
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.SUCCESS;

		super.mobInteract(sourceentity, hand);

		sourceentity.startRiding(this);

		return retval;
	}

	@Override
	public void tick() {
		super.tick();

		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(true, this.tickCount);
		}
	}

	@Override
	public void travel(Vec3 dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isVehicle()) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();

			if (entity instanceof ServerPlayer passenger) {
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));

				float forward = passenger.getLastClientInput().forward() == passenger.getLastClientInput().backward() ? 0 : (passenger.getLastClientInput().forward() ? 1 : -1);

				float strafe = passenger.getLastClientInput().left() == passenger.getLastClientInput().right() ? 0 : (passenger.getLastClientInput().left() ? 1 : -1);

				super.travel(new Vec3(strafe, 0, forward));
			}

			double d1 = this.getX() - this.xo;
			double d0 = this.getZ() - this.zo;
			float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.walkAnimation.setSpeed(this.walkAnimation.speed() + (f1 - this.walkAnimation.speed()) * 0.4F);
			this.walkAnimation.position(this.walkAnimation.position() + this.walkAnimation.speed());
			this.calculateEntityAnimation(true);
			return;
		}

		super.travel(dir);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();

		this.setNoGravity(true);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(Attributes.FLYING_SPEED, 0.3);

		builder = builder.add(Attributes.TEMPT_RANGE, 10);

		return builder;
	}
}
