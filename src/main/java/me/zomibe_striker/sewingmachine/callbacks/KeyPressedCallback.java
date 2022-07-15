package me.zomibe_striker.sewingmachine.callbacks;


import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.util.ActionResult;

public interface KeyPressedCallback {


    Event<KeyPressedCallback> EVENT = EventFactory.createArrayBacked(KeyPressedCallback.class,((listeners) -> (key, hasShiftDown) -> {
        for(KeyPressedCallback callback : listeners){
            ActionResult a = callback.keypressed(key, hasShiftDown);
            if(a != ActionResult.PASS){
                return a;
            }
        }
        return ActionResult.PASS;
    }));

    ActionResult keypressed(int key, boolean hasShiftDown);
}
