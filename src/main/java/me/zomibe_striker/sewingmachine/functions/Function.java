package me.zomibe_striker.sewingmachine.functions;

import me.zomibe_striker.sewingmachine.SewingMachine;
import me.zomibe_striker.sewingmachine.events.Event;

public abstract class Function {

    private final String name;
    private final Class<? extends Event> calledEvent;


    private boolean enabled = false;

    public Function(String name, Class<? extends Event> event){
        this.name = name;
        this.calledEvent = event;
    }

    public String getName() {
        return name;
    }
    public abstract void onEnable(SewingMachine sewingMachine);

    public abstract boolean onCall(Event event, SewingMachine sewingMachine);

    public abstract void onDisable(SewingMachine sewingMachine);

    public Class<? extends Event> getCalledEvent() {
        return calledEvent;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
