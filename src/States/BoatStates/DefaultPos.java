package States.BoatStates;

import interfaces.BoatStatesInterface;
import objects.Boat;

public class DefaultPos implements BoatStatesInterface {
    @Override
    public void next(Boat boat) {
        boat.setState(new UnderBridge());
    }

    @Override
    public String toString(){
        return "DefaultPos";
    }
}
