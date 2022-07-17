package me.zomibe_striker.sewingmachine;

import me.zomibe_striker.sewingmachine.functions.Function;

import java.util.LinkedList;
import java.util.List;

public class Functionality {

    private List<Function> functions = new LinkedList<>();


    public List<Function> getFunctions() {
        return functions;
    }

    public void registerFunction(Function function){
        this.functions.add(function);
    }
    public void removeFunction(Function function){
        this.functions.remove(function);
    }
}
