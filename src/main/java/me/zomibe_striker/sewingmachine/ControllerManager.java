package me.zomibe_striker.sewingmachine;

import me.zomibe_striker.sewingmachine.data.MovementDirectionKeys;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.mixin.client.keybinding.KeyBindingAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;

public class ControllerManager {

    public void movePlayer(MovementDirectionKeys keys){
        MinecraftClient client = MinecraftClient.getInstance();
        if(client.player!=null)
            keys.getKeyBinding().setPressed(true);
    }
    public void stopMoving(MovementDirectionKeys keys){
        MinecraftClient client = MinecraftClient.getInstance();
        if(client.player!=null)
            keys.getKeyBinding().setPressed(false);
    }
}
