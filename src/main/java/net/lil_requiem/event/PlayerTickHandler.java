package net.lil_requiem.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.lil_requiem.util.IEntityDataSaver;
import net.lil_requiem.util.ManaData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Random;

public class PlayerTickHandler implements ServerTickEvents.StartTick{
    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if(new Random().nextFloat() <= 0.005f) {
                if (player instanceof IEntityDataSaver playerDataSaver) {
                    ManaData.addMana(playerDataSaver, 1);
                    player.sendMessage(Text.literal(playerDataSaver.getPersistentData().toString()));
                }

                player.sendMessage(Text.literal("Added Mana"));
            }
        }
    }
}
