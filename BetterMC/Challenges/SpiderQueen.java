package net.mcreator.betterminecraft.entity;

public class SpiderQueenEntity extends Spider {

	public SpiderQueenEntity(EntityType<SpiderQueenEntity> type, Level world) {
		super(type, world);
		xpReward = 40;
		setNoAi(false);

		setPersistenceRequired();

	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));

	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.FERMENTED_SPIDER_EYE));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:spider_queen_idle"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.spider.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:spider_queen_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:spider_queen_death"));
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

		SpiderQueenEntityIsHurtProcedure.execute(world, x, y, z, sourceentity);
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public void awardKillScore(Entity entity, DamageSource damageSource) {
		super.awardKillScore(entity, damageSource);
		SpiderQueenThisEntityKillsAnotherOneProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		SpiderQueenPlayerCollidesWithThisEntityProcedure.execute(sourceentity);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 80);
		builder = builder.add(Attributes.ARMOR, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 48);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.75);

		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);

		return builder;
	}

}
