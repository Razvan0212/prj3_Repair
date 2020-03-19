package objects;

import GFXHelpers.Transitions;
import States.BridgeStates.Lowered;
import interfaces.BridgeStatesInterface;
import interfaces.Updatable;
import Observer.BridgeObserver;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Bridge implements Updatable {
    private BridgeStatesInterface currState;
    private List<BridgeObserver> observers = new ArrayList<>();
    private Pane bridge;
    private Transitions gfx = new Transitions();

    public Bridge(Pane bridge) {
        this.currState = new Lowered();
        this.bridge = bridge;
    }

    public void setState(BridgeStatesInterface state) {
        currState = state;
    }

    public void next(){
        currState.next(this);
        for(BridgeObserver obs : observers){
            obs.update();
        }
    }

    public void addObserver(BridgeObserver obs){
        observers.add(obs);
        obs.setUpdatable(this);
    }

    @Override
    public String toString(){
        return currState.toString();
    }

    @Override
    public void update() {
        switch (currState.toString()){
            case "Lowered":
                gfx.fadeInTransition(1, 1.8,bridge);
                break;
            case "Raising":
                gfx.fadeOutTransition(0.4,1.8,bridge);
                break;
            case "Lowering":
                gfx.fadeInTransition(0.4,1.8,bridge);
                break;
            case "Raised":
                gfx.fadeOutTransition(0,1.8,bridge);
                break;
        }
    }

    public double getX(){
        return bridge.getLayoutX();
    }
}
