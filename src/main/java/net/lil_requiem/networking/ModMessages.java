package net.lil_requiem.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.lil_requiem.RPServerFighting;
import net.lil_requiem.networking.packet.ManaDecayingC2SPacket;
import net.lil_requiem.networking.packet.ManaSyncDataS2CPacket;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier MANA_DECAYING_ID = new Identifier(RPServerFighting.MODID, "decaying_mana");
    public static final Identifier MANA_SYNC_ID = new Identifier(RPServerFighting.MODID, "mana_sync");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(MANA_DECAYING_ID, ManaDecayingC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC_ID, ManaSyncDataS2CPacket::receive);
    }
}
