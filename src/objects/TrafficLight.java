package objects;

import Observer.TrafficLightObserver;
import States.TrafficLightStates.Red;
import interfaces.Updatable;
import interfaces.TrafficLightStatesInterface;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight implements Updatable {
    private TrafficLightStatesInterface currState;
    private List<TrafficLightObserver> observers = new ArrayList<>();
    private Circle green;
    private Circle yellow;
    private Circle red;

    public TrafficLight() {
        currState = new Red();
    }

    public TrafficLight(Circle green, Circle yellow, Circle red) {
        this.green = green;
        this.yellow = yellow;
        this.red = red;
        currState = new Red();
    }

    public void setState(TrafficLightStatesInterface state) {
        currState = state;
    }

    public void next(){
        currState.next(this);
        for(TrafficLightObserver obs : observers){
            obs.update();
        }
    }

    public void addObserver(TrafficLightObserver obs){
        observers.add(obs);
        obs.setUpdatable(this);
    }

    @Override
    public String toString(){
        return currState.toString();
    }

    private void turnGreen(){
        this.green.setFill(Color.LIGHTGREEN);
        this.red.setFill(Color.DARKRED);
        this.yellow.setFill(Color.DARKGOLDENROD);
    }

    private void turnRed(){
        this.green.setFill(Color.DARKGREEN);
        this.red.setFill(Color.RED);
        this.yellow.setFill(Color.DARKGOLDENROD);
    }

    private void turnYellow(){
        this.green.setFill(Color.DARKGREEN);
        this.red.setFill(Color.DARKRED);
        this.yellow.setFill(Color.YELLOW);
    }

    public void update(){
        switch (toString()){
            case "Green":
                turnGreen();
                break;
            case "Yellow":
                turnYellow();
                break;
            case "Red":
                turnRed();
                break;
        }
    }
}
