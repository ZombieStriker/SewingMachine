package me.zomibe_striker.sewingmachine;

import com.mojang.blaze3d.systems.RenderSystem;
import me.zomibe_striker.sewingmachine.functions.Function;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.awt.*;

public class BotScreen extends Screen {

    protected BotScreen(Text title) {
        super(title);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TextureManager.BOTMOD_BG);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        this.drawTexture(matrices, 0, 0, 0, 0, this.width, this.height);
        TitleScreen.drawStringWithShadow(matrices,textRenderer,"Press ESC to exit.", 1,10,new Color(200,200,200).getRGB());
        for(int i = 0 ; i < SewingMachine.instance.getFunctionality().getFunctions().size();i++) {
            Function f = SewingMachine.instance.getFunctionality().getFunctions().get(i);
            if(f!=null) {
                if(f.isEnabled()) {
                    TitleScreen.drawStringWithShadow(matrices, textRenderer, f.getName(), 20, 30 + (i * 30), new Color(200, 200, 200).getRGB());
                }else{
                    TitleScreen.drawStringWithShadow(matrices, textRenderer, f.getName(), 20, 30 + (i * 30), new Color(200, 20, 20).getRGB());
                }

            }
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        return super.charTyped(chr, modifiers);
    }

    @Override
    public void renderBackground(MatrixStack matrices) {
        super.renderBackground(matrices);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        int Yfunct = (int) ((mouseY-30)/30);
        if(Yfunct >= 0 && Yfunct < SewingMachine.instance.getFunctionality().getFunctions().size()){
            Function f = SewingMachine.instance.getFunctionality().getFunctions().get(Yfunct);
            f.setEnabled(!f.isEnabled());
        }


        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
