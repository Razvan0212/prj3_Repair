package States.TrafficLightStates;

import interfaces.TrafficLightStatesInterface;
import objects.TrafficLight;

public class Yellow implements TrafficLightStatesInterface {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(new Red());
    }

    @Override
    public String toString(){
        return "Yellow";
    }
}
