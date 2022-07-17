package me.zomibe_striker.sewingmachine;

import me.zomibe_striker.sewingmachine.callbacks.KeyPressedCallback;
import me.zomibe_striker.sewingmachine.events.TickEvent;
import me.zomibe_striker.sewingmachine.functions.AutoWalkFunction;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class SewingMachine implements ModInitializer {

    public static final String MODID = "sewingmachine";
    public static SewingMachine instance;

    private KeyListener keyListener = new KeyListener();
    private Functionality functionality = new Functionality();
    private ControllerManager controllerManager = new ControllerManager();
    private KeyBinding keyBinding;
    private BotScreen botScreen;
    private Screen previousScreen = null;
    private boolean released = true;

    @Override
    public void onInitialize() {
        instance = this;
        KeyPressedCallback.EVENT.register(keyListener);

        this.botScreen = new BotScreen(Text.literal("SewingMachine Screen"));

        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "keybindings.sewingmachine.title.name", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_MINUS, // The keycode of the key
                "keybindings.sewingmachine.openmenu.name" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(keyBinding.isPressed()) {
                if(released) {
                    released = false;
                    if (previousScreen == null) {
                        previousScreen = MinecraftClient.getInstance().currentScreen;
                        if(previousScreen!=botScreen) {
                            MinecraftClient.getInstance().setScreenAndRender(botScreen);
                        }
                    } else {
                        if(previousScreen!=null) {
                            MinecraftClient.getInstance().setScreenAndRender(previousScreen);
                            previousScreen = null;
                        }
                    }
                }
            }else{
                released=true;
            }
        });

        getFunctionality().registerFunction(new AutoWalkFunction());

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            TickEvent tickEvent = new TickEvent();
            tickEvent.call();
        });
    }

    public Functionality getFunctionality() {
        return functionality;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
