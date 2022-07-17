package me.zomibe_striker.sewingmachine.events;

import me.zomibe_striker.sewingmachine.functions.Function;
import me.zomibe_striker.sewingmachine.SewingMachine;

public abstract class Event {

    private String name;
    public Event(String name){
        this.name=name;
    }

    public void call(){
        for(Function f : SewingMachine.instance.getFunctionality().getFunctions()){
            if(f.getCalledEvent().isInstance(this)){
                if(f.isEnabled())
                f.onCall(this,SewingMachine.instance);
            }
        }
    }
}
