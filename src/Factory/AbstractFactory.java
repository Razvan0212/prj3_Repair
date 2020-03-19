package Factory;

import Observer.BoatObserver;
import Observer.BridgeObserver;
import Observer.TrafficLightObserver;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import objects.Boat;
import objects.Bridge;
import objects.TrafficLight;

import javax.swing.text.html.ImageView;

public class AbstractFactory {
    public AbstractFactory() {}

    private BridgeObserver createBridgeObserver(){
        return new BridgeObserver();
    }

    private TrafficLightObserver createTrafficLightObserver(){
        return new TrafficLightObserver();
    }

    private BoatObserver createBoatObserver(){ return new BoatObserver();}

    public Bridge createBridge(Pane givenBridge){
        Bridge bridge = new Bridge(givenBridge);
        bridge.addObserver(createBridgeObserver());
        return bridge;
    }

    public TrafficLight createTrafficLight(Circle green, Circle yellow, Circle red){
        TrafficLight trafficLight = new TrafficLight(green, yellow, red);
        trafficLight.addObserver(createTrafficLightObserver());
        return trafficLight;
    }

    public Boat createBoat(javafx.scene.image.ImageView boatBody, Bridge bridge){
        Boat boat = new Boat(boatBody, bridge);
        boat.addObserver(createBoatObserver());
        return boat;
    }
}
