package net.lil_requiem.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.lil_requiem.networking.ModMessages;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyBindingHolder {
    public static final String KEY_CATEGORY_FAST_SKILLS = "key.category.rpserver-fighting.fastskills";
    public static final String KEY_FIRST_SKILL = "key.rpserver-fighting.firstskill";

    public static KeyBinding firstSkill;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(firstSkill.wasPressed()) {
                ClientPlayNetworking.send(ModMessages.MANA_DECAYING_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register() {
        firstSkill = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FIRST_SKILL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_FAST_SKILLS
        ));

        registerKeyInputs();
    }
}
