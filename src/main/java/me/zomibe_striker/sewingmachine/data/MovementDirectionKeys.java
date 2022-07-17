package me.zomibe_striker.sewingmachine.data;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public enum MovementDirectionKeys {
    FORWARD(MinecraftClient.getInstance().options.forwardKey),
    BACK(MinecraftClient.getInstance().options.backKey),
    LEFT(MinecraftClient.getInstance().options.leftKey),
    RIGHT(MinecraftClient.getInstance().options.rightKey),
    JUMP(MinecraftClient.getInstance().options.jumpKey);

    private KeyBinding keyBinding;

    MovementDirectionKeys(KeyBinding binding){
        this.keyBinding = binding;
    }

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }
}
