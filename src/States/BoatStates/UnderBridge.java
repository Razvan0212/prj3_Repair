package States.BoatStates;

import interfaces.BoatStatesInterface;
import objects.Boat;

public class UnderBridge implements BoatStatesInterface {
    @Override
    public void next(Boat boat) {
        boat.setState(new AfterBridge());
    }

    @Override
    public String toString(){
        return "UnderBridge";
    }
}
