package net.mcreator.betterminecraft.entity;

public class BossEntity extends Monster {

	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.YELLOW, ServerBossEvent.BossBarOverlay.NOTCHED_10);

	public BossEntity(EntityType<BossEntity> type, Level world) {
		super(type, world);
		xpReward = 30;
		setNoAi(false);

		setPersistenceRequired();

		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BetterminecraftModItems.PLATINUM_SWORD.get()));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BetterminecraftModItems.PLATINUM_ARMOR_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BetterminecraftModItems.PLATINUM_ARMOR_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BetterminecraftModItems.PLATINUM_ARMOR_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BetterminecraftModItems.PLATINUM_ARMOR_BOOTS.get()));

	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);

		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, true));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < 4 && this.mob.getSensing().hasLineOfSight(entity);
			}

		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(7, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, false));

	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.wither.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.wither_skeleton.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.wither.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.respawn_anchor.deplete"));
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep(ServerLevel serverLevel) {
		super.customServerAiStep(serverLevel);
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 125);
		builder = builder.add(Attributes.ARMOR, 12);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 7);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);

		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);

		return builder;
	}

}
