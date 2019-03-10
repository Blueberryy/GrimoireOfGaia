package gaia.items;

import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemSpawn extends ItemGaiaLootable {
	public ItemSpawn() {
		super("spawn");
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.RightClickUse"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		ItemStack stack = player.getHeldItem(handIn);

		player.playSound(GaiaSounds.BOX_OPEN_2, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random random = new Random();
		int i = random.nextInt(6);
		switch (i) {
			case 0:
				return loot(GaiaItems.SPAWN_CREEPER_GIRL);
			case 1:
				return loot(GaiaItems.SPAWN_ENDER_GIRL);
			case 2:
				return loot(GaiaItems.SPAWN_HOLSTAURUS);
			case 3:
				return loot(GaiaItems.SPAWN_SLIME_GIRL);
			case 4:
				return loot(GaiaItems.SPAWN_TRADER);
			case 5:
				return loot(GaiaItems.SPAWN_WERESHEEP);
			default:
				return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
	}
}
