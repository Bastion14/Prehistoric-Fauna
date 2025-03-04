package superlord.prehistoricfauna.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

	public void init() {
		
	}
	
	public boolean chickensDie() {
		return false;
	}

	
	@SubscribeEvent
	public void spaceTimeContinuumWarping(LivingDeathEvent event) {
		if (PrehistoricFaunaConfig.spaceTimeContinuumWarping) {
			if (event.getEntity() instanceof HesperornithoidesEntity) {
				if (event.getSource().getTrueSource() instanceof PlayerEntity) {
					this.chickensDie();
				}
			}
		}
	}
	
	public void openPaleopediaGui(ItemStack book) {
		
	}
	
	public boolean shouldSeePaleopediaContents() {
		return true;
	}
	
	public Object getFontRenderer() {
		return null;
	}
	
	public TileEntity getReferencedTE() {
		return null;
	}
	
	public void setReferencedTE(TileEntity tileentity) {
		
	}
	
	public PlayerEntity getClientSidePlayer() {
		return null;
	}
	
    public void setup() {
        MinecraftForge.EVENT_BUS.register(new ServerEvents());
    }
	
}
