package net.lil_requiem.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.lil_requiem.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class ManaSyncDataS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        if (client.player instanceof IEntityDataSaver playerDataSaver) {
            playerDataSaver.getPersistentData().putInt("mana", buf.readInt());
        }

    }
}
