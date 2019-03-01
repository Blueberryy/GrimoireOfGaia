package gaia.entity;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

//Adapted from DivineRPG code
public abstract class EntityMobMerchant extends EntityVillager implements INpc, IMerchant {
	private static final String OFFERS_TAG = "Offers";
	private static final int MAX_RECIPES_TO_ADD = 75;
	private MerchantRecipeList buyingList;
	private int wealth;

	public EntityMobMerchant(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		if (hasCustomName()) {
			return super.getDisplayName();
		}

		TextComponentTranslation nameString = new TextComponentTranslation(this.getType().getTranslationKey() + ".name");
		nameString.getStyle().setHoverEvent(getHoverEvent());
		nameString.getStyle().setInsertion(getCachedUniqueIdString());

		return nameString;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();

		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return null;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		final boolean flag = stack != ItemStack.EMPTY && stack.getItem() instanceof ItemSpawnEgg;

		if (!flag && isAlive() && !isTrading() && !isChild() && !player.isSneaking()) {
			if (!world.isRemote && (buyingList == null || !buyingList.isEmpty())) {
				setCustomer(player);
				player.displayVillagerTradeGui(this);
			}

			player.addStat(StatList.TALKED_TO_VILLAGER);
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	public abstract void addRecipies(MerchantRecipeList list);

	@Override
	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);

		compound.setInt("Riches", wealth);

		if (buyingList != null) {
			compound.setTag(OFFERS_TAG, buyingList.write());
		}
	}

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);

		wealth = compound.getInt("Riches");

		if (compound.hasKey(OFFERS_TAG)) {
			NBTTagCompound offerCompound = compound.getCompound(OFFERS_TAG);
			buyingList = new GaiaTradeList(offerCompound);
		}
	}

	@Override
	public void useRecipe(MerchantRecipe recipe) {
		recipe.incrementToolUses();
		livingSoundTime = -getTalkInterval();
		int i = 3 + rand.nextInt(4);

		if (recipe.getToolUses() == 1 || rand.nextInt(5) == 0) {
			// TODO Will need to come back to this, mating code got changed
			// TODO isWillingToMate = true;

			i += 5;
		}

		if (recipe.getItemToBuy()
				.getItem() == Items.EMERALD) {
			wealth += recipe.getItemToBuy()
					.getMaxStackSize();
		}

		if (recipe.getRewardsExp()) {
			world.spawnEntity(new EntityXPOrb(world, posX, posY + 0.5D, posZ, i));
		}
	}

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer var1) {
		if (buyingList == null) {
			addDefaultEquipmentAndRecipies(MAX_RECIPES_TO_ADD);
		}

		return buyingList;
	}

	private void addDefaultEquipmentAndRecipies(int maxRecipesToAdd) {
		MerchantRecipeList rec = new MerchantRecipeList();
		addRecipies(rec);
		if (buyingList == null) {
			buyingList = new MerchantRecipeList();
		}

		for (int i = 0; i < maxRecipesToAdd && i < rec.size(); ++i) {
			buyingList.add(rec.get(i));
		}
	}

	@Override
	public boolean canSpawn(IWorld worldIn, boolean value) {
		return posY < 0.0D && super.canSpawn(world, value);
	}
}
