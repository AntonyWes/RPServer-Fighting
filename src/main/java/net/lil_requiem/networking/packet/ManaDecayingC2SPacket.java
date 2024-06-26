package net.lil_requiem.networking.packet;

import net.fabricmc.fabric.api.entity.FakePlayer;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.lil_requiem.util.IEntityDataSaver;
import net.lil_requiem.util.ManaData;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class ManaDecayingC2SPacket {
    private static final String MESSAGE_DECAYING_WATER = "message.rpserver-fighting.mana_decaying";
    private static final String MESSAGE_NO_DECAYING = "message.rpserver-fighting.no_decaying";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        if (player instanceof IEntityDataSaver playerDataSaver) {
                ManaData.removeMana(playerDataSaver, 1);
                System.out.println(String.valueOf(playerDataSaver.getPersistentData().getInt("mana")));
            }
    }
}
