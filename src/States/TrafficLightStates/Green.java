package States.TrafficLightStates;

import interfaces.TrafficLightStatesInterface;
import objects.TrafficLight;

public class Green implements TrafficLightStatesInterface {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(new Yellow());
    }

    @Override
    public String toString(){
        return "Green";
    }
}
