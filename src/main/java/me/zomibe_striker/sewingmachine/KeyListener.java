package me.zomibe_striker.sewingmachine;

import me.zomibe_striker.sewingmachine.callbacks.KeyPressedCallback;
import net.minecraft.util.ActionResult;

public class KeyListener implements KeyPressedCallback {
    @Override
    public ActionResult keypressed(int key, boolean hasShiftDown) {
        System.out.println("Test");
        return ActionResult.PASS;
    }
}
