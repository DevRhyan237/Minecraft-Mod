package net.mcreator.betterminecraft.entity;

public class CrossbowPirateEntity extends Raider implements RangedAttackMob {

	public static final EnumProxy<Raid.RaiderType> RAIDER_TYPE = new EnumProxy<>(Raid.RaiderType.class, BetterminecraftModEntities.CROSSBOW_PIRATE, new int[]{0, 0, 0, 0, 2, 2, 3, 4});

	public CrossbowPirateEntity(EntityType<CrossbowPirateEntity> type, Level world) {
		super(type, world);
		xpReward = 15;
		setNoAi(false);

		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));

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
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Drowned.class, false, false));
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, Creaking.class, (float) 6, 1, 1.2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<>(this, DevourerEntity.class, (float) 6, 1, 1.2));
		this.targetSelector.addGoal(9, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(11, new FloatGoal(this));

		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10f) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.ARROW));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:crossbow_pirate_idle"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.chain.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.pillager.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:pirate_death"));
	}

	@Override
	public SoundEvent getCelebrateSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("betterminecraft:pirate_celebrate"));
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		Arrow entityarrow = new Arrow(this.level(), this, new ItemStack(Items.ARROW), null);
		double d0 = target.getY() + target.getEyeHeight() - 1.1;
		double d1 = target.getX() - this.getX();
		double d3 = target.getZ() - this.getZ();
		entityarrow.shoot(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
		this.level().addFreshEntity(entityarrow);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(BetterminecraftModEntities.CROSSBOW_PIRATE.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	@Override
	public void applyRaidBuffs(ServerLevel serverLevel, int num, boolean logic) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		return builder;
	}

}
