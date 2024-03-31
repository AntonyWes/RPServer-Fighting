package net.lil_requiem;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.lil_requiem.client.ManaHudOverlay;
import net.lil_requiem.event.KeyBindingHolder;
import net.lil_requiem.networking.ModMessages;

public class RPServerFightingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyBindingHolder.register();
        ModMessages.registerS2CPackets();

        HudRenderCallback.EVENT.register(new ManaHudOverlay());
    }
}
