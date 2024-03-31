package net.lil_requiem;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.lil_requiem.client.ManaHudOverlay;
import net.lil_requiem.event.KeyBindingHolder;
import net.lil_requiem.event.PlayerTickHandler;
import net.lil_requiem.item.ModItemGroup;
import net.lil_requiem.item.ModItems;
import net.lil_requiem.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RPServerFighting implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "rpserver-fighting";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();

		ModMessages.registerC2SPackets();
		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

	}
}