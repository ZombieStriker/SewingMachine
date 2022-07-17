package me.zomibe_striker.sewingmachine.functions;

import me.zomibe_striker.sewingmachine.SewingMachine;
import me.zomibe_striker.sewingmachine.data.MovementDirectionKeys;
import me.zomibe_striker.sewingmachine.events.Event;
import me.zomibe_striker.sewingmachine.events.TickEvent;

public class AutoWalkFunction extends Function{

    public AutoWalkFunction() {
        super("AutoWalk", TickEvent.class);
    }

    @Override
    public void onEnable(SewingMachine sewingMachine) {

    }

    @Override
    public boolean onCall(Event event, SewingMachine sewingMachine) {
        sewingMachine.getControllerManager().movePlayer(MovementDirectionKeys.FORWARD);
        return true;
    }

    @Override
    public void onDisable(SewingMachine sewingMachine) {
        sewingMachine.getControllerManager().stopMoving(MovementDirectionKeys.FORWARD);
    }
}
