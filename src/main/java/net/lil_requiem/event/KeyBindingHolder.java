package net.lil_requiem.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.lil_requiem.networking.ModMessages;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

public class KeyBindingHolder {
    public static final String KEY_CATEGORY_RPSF = "key.category.rpserver-fighting.skills";
    public static KeyBinding firstKey;
    public static final String KEY_FIRST_SKILL = "key.rpserver-fighting.first";
    public static KeyBinding secondKey;
    public static final String KEY_SECOND_SKILL = "key.rpserver-fighting.second";
    public static KeyBinding thirdKey;
    public static final String KEY_THIRD_SKILL = "key.rpserver-fighting.third";
    public static KeyBinding foureKey;
    public static final String KEY_FOURE_SKILL = "key.rpserver-fighting.fore";
    public static KeyBinding fiveKey;
    public static final String KEY_FIVE_SKILL = "key.rpserver-fighting.five";


    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(firstKey.wasPressed()) {
                ClientPlayNetworking.send(ModMessages.MANA_DECAYING_ID, PacketByteBufs.create());
            }
            if(secondKey.wasPressed()) {
                System.out.println("2");
            }
            if(thirdKey.wasPressed()) {
                System.out.println("3");
            }
            if(foureKey.wasPressed()) {
                System.out.println("4");
            }
            if(fiveKey.wasPressed()) {
                System.out.println("5");
            }
        });
    }

    public static void register() {
        firstKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FIRST_SKILL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_RPSF
        ));
        secondKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SECOND_SKILL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                KEY_CATEGORY_RPSF
        ));
        thirdKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_THIRD_SKILL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                KEY_CATEGORY_RPSF
        ));
        foureKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FOURE_SKILL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY_RPSF
        ));
        fiveKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FIVE_SKILL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_L,
                KEY_CATEGORY_RPSF
        ));

        registerKeyInputs();
    }
}
