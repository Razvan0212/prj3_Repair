package objects;

import GFXHelpers.Transitions;
import Observer.BoatObserver;
import Observer.BridgeObserver;
import States.BoatStates.AfterBridge;
import States.BoatStates.DefaultPos;
import interfaces.BoatStatesInterface;
import interfaces.Updatable;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Boat implements Updatable{
    private BoatStatesInterface currState;
    private ImageView boatObject;
    private List<BoatObserver> observers= new ArrayList<>();
    private Transitions gfx = new Transitions();
    private Bridge bridge;
    private double defaultXPos;

    public Boat(ImageView boatObject, Bridge bridge) {
        currState = new AfterBridge();
        this.boatObject = boatObject;
        this.bridge = bridge;
        defaultXPos = boatObject.getLayoutX();
    }

    public double getRightXPos(){
        return boatObject.getX() + boatObject.getFitWidth();
    }

    public void setState(BoatStatesInterface state){
        currState = state;
        for(BoatObserver obs : observers){
            obs.update();
        }
    }

    public void addObserver(BoatObserver obs){
        observers.add(obs);
        obs.setUpdatable(this);
    }

    public void next(){
        currState.next(this);
    }

    @Override
    public void update() {
        switch (currState.toString()){
            case "DefaultPos":
                gfx.moveTo(bridge.getX() - 100, 1.8, this.boatObject);
                break;
            case "UnderBridge":
                gfx.moveTo(bridge.getX() + 300, 3.8, this.boatObject);
                break;
            case "AfterBridge":
                Thread t1 = new Thread(){
                    public void run(){
                        gfx.fadeOutTransition(0,1.5,boatObject);
                    }
                };
                Thread t2 = new Thread(){
                    public void run(){
                        try {
                            Thread.sleep(1600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        gfx.moveTo(defaultXPos, 0.1, boatObject);
                    }
                };
                Thread t3 = new Thread(){
                    public void run(){
                        try {
                            Thread.sleep(7000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        gfx.fadeInTransition(1, 1.5, boatObject);
                    }
                };
                t1.start();
                t2.start();
                t3.start();
                break;
        }
    }
}
