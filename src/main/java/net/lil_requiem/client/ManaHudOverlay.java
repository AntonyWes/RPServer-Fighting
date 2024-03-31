package net.lil_requiem.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.lil_requiem.RPServerFighting;
import net.lil_requiem.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.GameRenderer;

public class ManaHudOverlay implements HudRenderCallback {

    private static final Identifier FILLED_MANA = new Identifier(RPServerFighting.MODID,
            "textures/mana/filled_mana.png");
    private static final Identifier EMPTY_MANA = new Identifier(RPServerFighting.MODID,
            "textures/mana/empty_mana.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MatrixStack matrixStack = drawContext.getMatrices();
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_MANA);
        for(int i = 0; i < 10; i++) {
            drawContext.drawTexture(EMPTY_MANA,x - 94 + (i * 9),y - 54,0,0,12,12,
                    12,12);
        }

        RenderSystem.setShaderTexture(0, FILLED_MANA);
        for(int i = 0; i < 10; i++) {
            if(((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") > i) {
                drawContext.drawTexture(FILLED_MANA,x - 94 + (i * 9),y - 54,0,0,12,12,
                        12,12);
            } else {
                break;
            }
        }
    }
}
