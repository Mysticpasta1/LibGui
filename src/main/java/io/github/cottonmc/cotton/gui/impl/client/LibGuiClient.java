package io.github.cottonmc.cotton.gui.impl.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import io.github.cottonmc.cotton.gui.impl.ScreenNetworkingImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = "libgui", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LibGuiClient {
	public static final Logger logger = LogManager.getLogger();
	public static volatile LibGuiConfig config;

	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {

		ClientPlayNetworking.registerGlobalReceiver(ScreenNetworkingImpl.SCREEN_MESSAGE_S2C, (client, networkHandler, buf, responseSender) -> {
			ScreenNetworkingImpl.handle(client, client.player, buf);
		});

		LibGuiShaders.register();
	}
}
