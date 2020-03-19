package States.TrafficLightStates;

import interfaces.TrafficLightStatesInterface;
import objects.TrafficLight;

public class Red implements TrafficLightStatesInterface {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.setState(new Green());
    }

    @Override
    public String toString(){
        return "Red";
    }
}
