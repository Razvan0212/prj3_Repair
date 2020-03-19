package States.BoatStates;

import interfaces.BoatStatesInterface;
import objects.Boat;

public class AfterBridge implements BoatStatesInterface {
    @Override
    public void next(Boat boat) {
        boat.setState(new DefaultPos());
    }

    @Override
    public String toString(){
        return "AfterBridge";
    }
}
