package superlord.prehistoricfauna.entity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.ItemInit;

public class StegosaurusSkeletonEntity extends PrehistoricEntity {
	private static final DataParameter<Boolean> RESTING_POSE = EntityDataManager.createKey(StegosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> RETRO_POSE = EntityDataManager.createKey(StegosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ACTION_LEFT_POSE = EntityDataManager.createKey(StegosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ACTION_RIGHT_POSE = EntityDataManager.createKey(StegosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(StegosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(StegosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);

	public boolean isResting() {
		return this.dataManager.get(RESTING_POSE);
	}

	private void setResting(boolean isResting) {
		this.dataManager.set(RESTING_POSE, isResting);
	}
	
	public boolean isRetro() {
		return this.dataManager.get(RETRO_POSE);
	}

	private void setRetro(boolean isRetro) {
		this.dataManager.set(RETRO_POSE, isRetro);
	}
	
	public boolean isActionLeft() {
		return this.dataManager.get(ACTION_LEFT_POSE);
	}

	private void setActionLeft(boolean isActionLeft) {
		this.dataManager.set(ACTION_LEFT_POSE, isActionLeft);
	}
	
	public boolean isActionRight() {
		return this.dataManager.get(ACTION_RIGHT_POSE);
	}

	private void setActionRight(boolean isActionRight) {
		this.dataManager.set(ACTION_RIGHT_POSE, isActionRight);
	}
	
	public boolean isPushable() {
		return this.dataManager.get(PUSHING);
	}

	private void setPushable(boolean isPushable) {
		this.dataManager.set(PUSHING, isPushable);
	}
	
	public boolean isLooking() {
		return this.dataManager.get(LOOKING);
	}

	private void setLooking(boolean isLooking) {
		this.dataManager.set(LOOKING, isLooking);
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(RESTING_POSE, false);
		this.dataManager.register(ACTION_LEFT_POSE, false);
		this.dataManager.register(ACTION_RIGHT_POSE, false);
		this.dataManager.register(RETRO_POSE, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(LOOKING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsResting", this.isResting());
		compound.putBoolean("IsActionLeft", this.isActionLeft());
		compound.putBoolean("IsActionRight", this.isActionRight());
		compound.putBoolean("IsRetro", this.isRetro());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setResting(compound.getBoolean("IsResting"));
		this.setActionLeft(compound.getBoolean("IsActionLeft"));
		this.setActionRight(compound.getBoolean("IsActionRight"));
		this.setRetro(compound.getBoolean("IsRetro"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}
	
	public StegosaurusSkeletonEntity(EntityType<? extends StegosaurusSkeletonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
	}

	protected int getExperiencePoints(PlayerEntity player) {
		return 0;
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public boolean canBePushed() {
		return this.isPushable();
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
	    if (itemstack.getItem() == ItemInit.GEOLOGY_HAMMER.get()) {
	    	if (!this.isResting() && !player.isSneaking() && !this.isRetro() && !this.isActionLeft() && !this.isActionRight()) {
	    		this.setResting(true);
	    	} else if (this.isResting() && !player.isSneaking()) {
	    		this.setResting(false);
	    		this.setRetro(true);
	    	} else if (!player.isSneaking() && this.isRetro()) {
	    		this.setRetro(false);
	    		this.setActionLeft(true);
	    	} else if (!player.isSneaking() && this.isActionLeft()) {
	    		this.setActionLeft(false);
	    		this.setActionRight(true);
	    	} else if (!player.isSneaking() && this.isActionRight()) {
	    		this.setActionRight(false);
	    	} else if (player.isSneaking() && !this.isPushable() && !this.isLooking()) {
	    		this.setPushable(true);
	    	} else if (player.isSneaking() && this.isPushable()) {
	    		this.setPushable(false);
	    		this.setLooking(true);
	    	} else if (player.isSneaking() && this.isLooking()) {
	    		this.setLooking(false);
	    	}
	    }
        return super.processInteract(player, hand);
	}

	protected void collideWithEntity(Entity entityIn) {
	}

	private void playBrokenSound() {
		this.world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_SKELETON_DEATH, this.getSoundCategory(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.world instanceof ServerWorld) {
			((ServerWorld)this.world).spawnParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.getDefaultState()), this.getPosX(), this.getPosYHeight(0.6666666666666666D), this.getPosZ(), 10, (double)(this.getWidth() / 4.0F), (double)(this.getHeight() / 4.0F), (double)(this.getWidth() / 4.0F), 0.05D);
		}
	}


	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() instanceof PlayerEntity) {
			this.remove();
			this.playBrokenSound();
			this.playParticles();
			this.spawnFossil(source);
		}
		return false;
	}

	public boolean canBeHitWithPotion() {
		return false;
	}

	public void onKillCommand() {
		this.remove();
	}

	private void spawnFossil(DamageSource p_213815_1_) {
		Block.spawnAsEntity(this.world, new BlockPos(this), new ItemStack(ItemInit.STEGOSAURUS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends LookAtGoal {

		StegosaurusSkeletonEntity entity;
		
		public LookAtPlayerGoal(StegosaurusSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
			super(entityIn, watchTargetClass, maxDistance);
			entity = entityIn;
		}
		
		public boolean shouldExecute() {
			if (entity.isLooking()) {
				return super.shouldExecute();
			} else {
				return false;
			}
		}
		
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && entity.isLooking();
		}
		
	}

}