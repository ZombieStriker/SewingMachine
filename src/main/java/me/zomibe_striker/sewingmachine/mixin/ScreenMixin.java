package me.zomibe_striker.sewingmachine.mixin;

import me.zomibe_striker.sewingmachine.callbacks.KeyPressedCallback;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)
public abstract class ScreenMixin {


    @Inject(method = "keyPressed", at = @At("RETURN"), cancellable = true)
    public void onKeyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir){
        KeyPressedCallback.EVENT.invoker().keypressed(keyCode,Screen.hasShiftDown());
    }
}
